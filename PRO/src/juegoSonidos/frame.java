package juegoSonidos;

import javax.swing.*;

public class frame extends JFrame {

    static protected panel panelObj = new panel();

    public frame() {
        setBounds(100,100,800,800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(panelObj);
        setVisible(true);
    }
}

