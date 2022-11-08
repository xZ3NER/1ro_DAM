package SourceCode.view.mainPanels.MainPanel.basePanel;

import SourceCode.MainClass;
import SourceCode.model.DDBB.IRestaurantSentences;
import SourceCode.view.ImageLabel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SearchBar extends JPanel implements IRestaurantSentences {

    private Border titledBorder = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(52, 203, 203), 5, true), "Search"
    );

    private JComboBox searchBar = new JComboBox();
    private ImageLabel reloadImage = new ImageLabel("reload", "reload");
    private ImageLabel payImage;

    public ImageLabel getPayImage() {
        return payImage;
    }

    public ImageLabel getReloadImage() {
        return reloadImage;
    }

    public JComboBox getSearchBar() {
        return searchBar;
    }

    public SearchBar() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 65));

        searchBar.setBorder(titledBorder);
        searchBar.setFont(new Font("Candara", Font.BOLD, 25));
        searchBar.setEditable(true);
        searchBar.setBackground(Color.white);
        searchBar.addItem("ALL");

        reloadImage.setOpaque(true);
        reloadImage.setBackground(Color.WHITE);
        reloadImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        add(searchBar);
        add(reloadImage, BorderLayout.EAST);
    }

    public void AddCustomerTickets() {

        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(CUSTOMER_SEARCH_BAR);
            while (resultSet.next()) {
                searchBar.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void AddPaymentsTickets() {

        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(PAYMENTS_SEARCH_BAR);
            while (resultSet.next()) {
                searchBar.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void AddTicketsCodes() {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(TICKETS_SEARCH_BAR);
            while (resultSet.next()) {
                searchBar.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void AddFoodProducts() {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(PRODUCT_SEARCH_BAR);

            while (resultSet.next()) {
                searchBar.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void AddPayButton() {
        SetOptionPaneUI();
        payImage = new ImageLabel("payTicket", "payTicket");

        payImage.setOpaque(true);
        payImage.setVisible(false);
        payImage.setBackground(Color.WHITE);
        payImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                String[] paymentMethod = {"Cash","Card"};
                String ticketCode = (String) searchBar.getSelectedItem();

                double totalPrice = 0;
                totalPrice = getTotalPrice(ticketCode, totalPrice);

                double amount=0;
                int option = 0;

                do{
                    try {
                        amount = Double.parseDouble(JOptionPane.showInputDialog(null,"Total: "+totalPrice+"€\n\nAmount to pay: ","Payment",JOptionPane.PLAIN_MESSAGE));

                        if (amount<totalPrice) {
                            JOptionPane.showMessageDialog(null, "Try again","Error",JOptionPane.PLAIN_MESSAGE);
                        }else {
                            option = JOptionPane.showOptionDialog(null, "Select a payment method: ", "Payment", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, paymentMethod, paymentMethod[0]);

                            try {
                                InsertPaymentData(option,ticketCode,amount);

                                JOptionPane.showMessageDialog(null, "Amount to return: "+(amount-totalPrice)+" €","Return",JOptionPane.PLAIN_MESSAGE);
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } catch (NumberFormatException e1) {
                        JOptionPane.showMessageDialog(null, "Try again","Error",JOptionPane.PLAIN_MESSAGE);
                        continue;
                    }catch (NullPointerException e2) {
                        break;
                    }
                }while (amount<totalPrice);

            }
        });

        add(payImage,BorderLayout.WEST);
    }

    private void InsertPaymentData(int option,String ticketCode,double payed) throws SQLException {
        String method,clientID = null;

        if (option==0) {
            method = "Efectivo";
        }else {
            method = "Tarjeta";
        }

        clientID = getClientID(ticketCode, clientID);

        try {
            MainClass.getDataBase().executeUpdate(
                    "INSERT INTO `pagos` (`codigoQR_cliente_pago`, `codigo_ticket_pago`, `tipo_pago`, `cantidad_pagada`) " +
                            "VALUES ('" + clientID + "', '" + ticketCode + "', '" + method + "', '" + payed + "');");

            MainClass.getDataBase().executeUpdate("UPDATE `tickets` SET `pagado` = '1' WHERE `tickets`.`codigo_ticket` = "+ticketCode+";");
        }catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Already payed","Error",JOptionPane.PLAIN_MESSAGE);
        }
    }

    private String getClientID(String ticketCode, String clientID) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(GET_CLIENTID_BY_TICKET+ ticketCode);

            while (resultSet.next()) {
                clientID = resultSet.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientID;
    }

    private void SetOptionPaneUI() {
        UIManager.put("Button.font", new Font("Candara Light", Font.BOLD, 20));
        UIManager.put("OptionPane.messageFont", new Font("Candara", Font.BOLD, 20));
        UIManager.put("Button.background", new Color(52, 203, 203));
        UIManager.put("Button.foreground", Color.white);
        UIManager.put("Button.border", BorderFactory.createLineBorder(new Color(50, 162, 162), 2));
    }

    private double getTotalPrice(String ticketCode, double totalPrice) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(PAYMENTS_GET_TOTAL_BY_TICKET+ ticketCode);

            while (resultSet.next()) {
                totalPrice = resultSet.getDouble(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return totalPrice;
    }
}
