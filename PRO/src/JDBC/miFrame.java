package JDBC;

import javax.swing.*;

public class miFrame extends JFrame {

    miPanel panelFondo;

    public miFrame() {
        setBounds(100,100,600,700);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void setPanelFondo(miPanel panelFondo) {
        this.panelFondo = panelFondo;
        add(this.panelFondo);
    }
}

