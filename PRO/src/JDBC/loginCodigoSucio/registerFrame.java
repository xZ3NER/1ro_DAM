package JDBC.loginCodigoSucio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class registerFrame extends JFrame {

    JPanel panel = new JPanel(new GridLayout(6,1,30,30));
    JPanel namePanel = new JPanel(new GridLayout(2,3,30,30));
    JPanel buttonPanel = new JPanel(new GridLayout(1,2,30,30));
    JTextField name = new JTextField();
    JTextField surname = new JTextField();
    JTextField secondlastname = new JTextField();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();

    public registerFrame() {
        setBounds(100,100,450,750);
        setResizable(false);
        setLocationRelativeTo(null);

        setPanels();
        add(panel);
        setVisible(true);
    }

    private void setPanels() {
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        createNamePanel();
        panel.add(namePanel);
        panel.add(new JLabel("Username"));
        panel.add(username);
        panel.add(new JLabel("Password"));
        panel.add(password);
        createButtonPanel();
        panel.add(buttonPanel);
    }

    private void createNamePanel() {

        namePanel.add(new JLabel("Name"));
        namePanel.add(new JLabel("Surname"));
        namePanel.add(new JLabel("Second Last Name"));
        namePanel.add(name);
        namePanel.add(surname);
        namePanel.add(secondlastname);
    }

    private void createButtonPanel() {
        JButton registerButton = new JButton("Register");

        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                try {
                    if (!checkNull()) {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection conexion = DriverManager.getConnection
                                ("jdbc:mysql://u5bsdwo4zmgawi7a:gZkHKbhadadMUsp5hfVV@bk6wxk7lwpjpx0tama9l-mysql.services.clever-cloud.com:3306/bk6wxk7lwpjpx0tama9l",
                                        "u5bsdwo4zmgawi7a", "u5bsdwo4zmgawi7a");

                        Statement sentencia = conexion.createStatement();
                        sentencia.executeUpdate("INSERT INTO usuarios VALUES ('" + username.getText() + "','" + password.getText() + "'," +
                                "'" + name.getText() + "','" + surname.getText() + "','" + secondlastname.getText() + "')");

                        sentencia.close();
                        conexion.close();

                        JOptionPane.showMessageDialog(null, "¡Account created!");

                        setVisible(false);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Fill all fields!");
                    }
                } catch (ClassNotFoundException ec) {
                    ec.printStackTrace();
                } catch (SQLException es) {
                    es.printStackTrace();
                }
            }

        });

        JButton cancelButton = new JButton("Cancel");

        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setVisible(false);
                dispose();
            }
        });

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        buttonPanel.add(registerButton);
        buttonPanel.add(cancelButton);
    }

    private boolean checkNull() {
        if (name.getText().equals("")) {
            return true;
        }
        if (surname.getText().equals("")) {
            return true;
        }
        if (username.getText().equals("")) {
            return true;
        }
        if (password.getText().equals("")) {
            return true;
        }

        return false;
    }
}
