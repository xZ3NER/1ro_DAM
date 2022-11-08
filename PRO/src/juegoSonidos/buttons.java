package juegoSonidos;

import javax.swing.*;
import java.awt.*;

public class buttons extends JButton {

    public buttons(pokemon pokemon) {
        setName(pokemon.getName());
        setBackground(Color.WHITE);
        setBorderPainted(false);
        setFocusPainted(false);
        setIcon(new ImageIcon(getClass().getResource(pokemon.getImage())));
    }
}
