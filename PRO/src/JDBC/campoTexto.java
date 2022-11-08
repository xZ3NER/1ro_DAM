package JDBC;

import javax.swing.*;
import java.awt.*;

public class campoTexto extends JLabel {

    public campoTexto(String texto) {
        setText(texto);
        setBorder(BorderFactory.createSoftBevelBorder(0, Color.white,Color.white));
        setFont(new Font("Candara",Font.BOLD,15));
        setHorizontalAlignment(JLabel.CENTER);
    }
}
