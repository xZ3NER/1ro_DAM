package SourceCode.view.mainPanels.FormsPanels.Input;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FormInputSelector extends JComboBox {

    private Border titledBorder;

    public FormInputSelector(String title, String[] options) {

        titledBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(52, 203, 203), 3), title
        );

        setBackground(Color.white);
        setFont(new Font("Candara", Font.PLAIN, 25));
        setBorder(titledBorder);

        addItem("");
        AddOptions(options);
    }

    private void AddOptions(String[] options) {

        for (String option : options) {
            addItem(option);
        }
    }
}

