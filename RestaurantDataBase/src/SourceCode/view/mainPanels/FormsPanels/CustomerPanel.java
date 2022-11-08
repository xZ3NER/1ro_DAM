package SourceCode.view.mainPanels.FormsPanels;

import SourceCode.MainClass;
import SourceCode.model.classes.Customer;
import SourceCode.model.utilities.Patterns;
import SourceCode.view.mainPanels.FormsPanels.Input.FormInput;
import SourceCode.view.mainPanels.FormsPanels.Input.FormInputSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;

public class CustomerPanel extends ParentPanel {

    private final JPanel productSelectorPanel = new JPanel(new BorderLayout());
    private JList<String> productsList = new JList<>();
    private final Vector<String> productListStrings = new Vector<>();
    private final JButton addButton = new JButton("Add product to list");
    private final JScrollPane scrollBar = new JScrollPane(productsList);

    private Customer customer;

    public CustomerPanel() {
        additionalPanelAspect();

        SetButtonStyle();
        ProductList();
        ProductPanel();

    }

    private void ProductList() {
        productSelectorPanel.add(addButton, BorderLayout.NORTH);

        productsList.setListData(productListStrings);
        productsList.setBorder(BorderFactory.createEmptyBorder(20, 120, 10, 120));
        productsList.setFont(new Font("Candara Light", Font.PLAIN, 20));

        productSelectorPanel.add(scrollBar,BorderLayout.CENTER);
    }

    private void SetButtonStyle() {
        addButton.setFocusPainted(false);
        addButton.setFont(new Font("Candara", Font.PLAIN, 25));
        addButton.setBackground(new Color(52, 203, 203));
        addButton.setForeground(Color.white);
        addButton.setBorder(BorderFactory.createLineBorder(new Color(50, 162, 162), 2));
        addButton.setPreferredSize(new Dimension(150, 50));

        AddButtonListener();
    }

    private void AddButtonListener() {
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (VerifyProductData()) {
                    String productRow = formInputList.get(2).getText()+"x" +
                            "                                                                              "+
                            formInputSelectorList.get(0).getSelectedItem();

                    productListStrings.add(productRow);

                    productsList.setListData(productListStrings);
                }else {
                    ShowOptionPane("Verify the products data", "../../../../res/cancel.png");
                }
            }
        });
    }

    private boolean VerifyProductData() {
        String[] data = {formInputList.get(2).getText(), (String) formInputSelectorList.get(0).getSelectedItem()};

        if (CheckNull(data)) {
            return false;
        }

        if (!Patterns.onlyDigitCheck(data[0])) {
            return false;
        } else {
            if (!Patterns.NegativeNumberCheck(data[0])) {

                return false;
            }
        }

        return true;
    }

    protected boolean CheckNull(String[] data) {
        for (int i = 0; i < data.length; i++) {

            if (Patterns.CheckIfNull(data[i])) {
                return true;
            }
        }
        return false;
    }

    private void ProductPanel() {
        productSelectorPanel.setBackground(Color.WHITE);
        productSelectorPanel.setPreferredSize(new Dimension(1000, 200));
        productSelectorPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 40, 80));

        add(productSelectorPanel,BorderLayout.CENTER);
    }

    @Override
    protected boolean VerifyData() {
        String[] data = {formInputList.get(0).getText(),formInputList.get(1).getText()};

        if (CheckNull(data)) {
            return false;
        }

        for (int i = 0; i < data.length; i++) {

            if (!Patterns.onlyDigitCheck(data[i])) {
                    formInputList.get(i).setForeground(Color.red);
                    return false;
            } else {
                    if (!Patterns.NegativeNumberCheck(data[i])) {
                        formInputList.get(i).setForeground(Color.red);
                        return false;
                    }
            }
        }

        return true;
    }

    @Override
    public void additionalPanelAspect() {
        Vector<String> productsName = new Vector<>();

        AddFoodProducts(productsName);

        formInputList.add(new FormInput("Client ID"));
        formInputList.add(new FormInput("Table Number"));
        formInputSelectorList.add(new FormInputSelector("Products",ToArray(productsName)));
        formInputList.add(new FormInput("Amount"));

        initializePanel();
        getPanel().setPreferredSize(new Dimension(1000, 250));
    }

    private void AddFoodProducts(Vector<String> productsName) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(NEW_CUSTOMER_SEARCH_BAR);

            while (resultSet.next()) {
                productsName.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private String[] ToArray(Vector<String> productsName) {
        String[] productArray = new String[productsName.size()];
        int i=0;

        for(String product: productsName) {
            productArray[i] = product;
            i++;
        }

        return productArray;
    }

    @Override
    protected void createObject() throws ParseException, SQLException {
        customer = new Customer(formInputList.get(0).getText(), formInputList.get(1).getText());

        SetProductListData(customer);

        insertToDDBB();

        ClearAll();
    }

    private void SetProductListData(Customer customer) {
        String[] rowData;

        for (int i=0;i<productsList.getModel().getSize();i++) {
            rowData = productsList.getModel().getElementAt(i).split("x");

            customer.addProducts(Integer.parseInt(rowData[0].trim()),rowData[1].trim());
        }
    }

    private void ClearAll() {
        for (FormInput data: formInputList) {
            data.setText("");
        }

        formInputSelectorList.get(0).setSelectedIndex(0);

        String[] zero = {""};

        productsList.setListData(zero);
        productListStrings.clear();
    }

    @Override
    protected void insertToDDBB() throws SQLException {
        try {
            MainClass.getDataBase().executeUpdate("INSERT INTO `clientes` " +
                    "(`codigoQR_cliente`, `idioma_principal_cliente`, `mesa_cliente`) " +
                    "VALUES ('"+customer.getClientID()+"', NULL, '"+customer.getTableNumber()+"')");

            MainClass.getDataBase().executeUpdate("INSERT INTO `tickets` " +
                    "(`codigo_ticket`, `precio_total`, `fecha_ticket`, `codigoQR_cliente_ticket`, `pagado`) " +
                    "VALUES ('"+customer.getTicketCode()+"', '"+customer.Total_Price()+"'," +
                    " CURRENT_TIMESTAMP, '"+customer.getClientID()+"', '0')");

            customer.ProductsNameToID();

            for (int i=0;i<customer.getProducts().size();i++) {
                MainClass.getDataBase().executeUpdate("INSERT INTO `detalles_ticket` " +
                        "(`cantidad_detallada`, `codigo_ticket_detalle`, `codigo_producto_detalle`) " +
                        "VALUES ('"+customer.getProducts_amount().get(i)+"', '"+customer.getTicketCode()+"', '"+customer.getProducts().get(i)+"')");
            }

            ShowOptionPane("Successfully added!", "../../../../res/checked.png");
        }catch (SQLException ex) {
            ShowOptionPane("¡ID already exists!", "../../../../res/cancel.png");
        }
    }
}
