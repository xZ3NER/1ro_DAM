package SourceCode.view.mainPanels.VehiclesFormsPanels.Input;

import SourceCode.model.utilities.TextPrompt;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormInput extends JTextField {

    private Border titledBorder;
    private TextPrompt placeHolder;

    public FormInput(String title) {

        titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(52, 203, 203), 3), title
        );
        placeHolder = new TextPrompt(title, this);

        setFont(new Font("Candara", Font.PLAIN, 25));
        placeHolder.setFont(new Font("Candara", Font.PLAIN, 25));
        setBorder(titledBorder);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setForeground(Color.black);
            }
        });
    }

    public TextPrompt getPlaceHolder() {
        return placeHolder;
    }

}
