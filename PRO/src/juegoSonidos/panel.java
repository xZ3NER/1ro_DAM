package juegoSonidos;

import javax.swing.*;
import java.awt.*;

public class panel extends JPanel {

    static public buttons[] buttonsArray = new buttons[4];

    public panel() {
        setLayout(new GridLayout(2,2,100,100));
        setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setBackground(Color.WHITE);
    }

    public void setButtons() {
        for(buttons button: buttonsArray) {
            add(button);
        }
    }
}
