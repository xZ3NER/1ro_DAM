package JDBC.loginCodigoSucio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class frame extends JFrame {

    JPanel panel = new JPanel(new GridLayout(5,1));
    JLabel labelUsername = new JLabel("Username");
    JLabel labelPassword = new JLabel("Password");
    JTextField usernameInput = new JTextField();
    JPasswordField passwordInput = new JPasswordField();
    JPanel buttonPanel = new JPanel();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");

    loginTest dataBase = new loginTest();

    public frame() {
        setBounds(100,100,600,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setPanelStyle();
        add(panel);
        setVisible(true);
    }

    private void setPanelStyle() {
        panel.add(labelUsername);
        labelUsername.setHorizontalAlignment(JLabel.CENTER);
        panel.add(usernameInput);
        usernameInput.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));
        panel.add(labelPassword);
        labelPassword.setHorizontalAlignment(JLabel.CENTER);
        panel.add(passwordInput);
        passwordInput.setBorder(BorderFactory.createEmptyBorder(0,50,0,50));

        setButtonActions();
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        panel.add(buttonPanel);
    }

    private void setButtonActions() { //SEGUIR AQUI, LAS ACCIONES DEL LOGIN
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String pwd = dataBase.dataBaseConnect(usernameInput.getText());

                if (pwd.equals("noAccount")) {
                    JOptionPane.showMessageDialog(null, "¡Not an existing account!");
                } else {
                    if (passwordInput.getText().equals(pwd)) {
                        JOptionPane.showMessageDialog(null, "¡Login successfull!");

                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");

                            Connection conexion = DriverManager.getConnection
                                    ("jdbc:mysql://u5bsdwo4zmgawi7a:gZkHKbhadadMUsp5hfVV@bk6wxk7lwpjpx0tama9l-mysql.services.clever-cloud.com:3306/bk6wxk7lwpjpx0tama9l",
                                            "u5bsdwo4zmgawi7a", "u5bsdwo4zmgawi7a");

                            Statement sentencia = conexion.createStatement();
                            ResultSet resul = sentencia.executeQuery("SELECT Nombre,Apellidos1,Apellidos2 FROM usuarios WHERE pwd LIKE '"+pwd+"'");

                            if (resul.next()) {
                                JOptionPane.showMessageDialog(null,"Name: "+resul.getString(1)+"\nSurname: "+
                                        resul.getString(2)+"\nSecond Last Name: "+resul.getString(3));
                            }

                            setVisible(false);
                            dispose();

                            //Cerramos todas las sentencias (muy importante)
                            resul.close();
                            sentencia.close();
                            conexion.close();
                        } catch (ClassNotFoundException ec) {
                            ec.printStackTrace();
                        } catch (SQLException es) {
                            es.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Login failed!");
                    }
                }
            }
        });

        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new registerFrame();
            }
        });
    }
}
