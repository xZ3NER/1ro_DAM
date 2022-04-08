package actividadHerencia.UI;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    protected static TitlePanel titlePanel;
    protected static ButtonsPanel buttonsPanel;

    /**
     * Frame aspect configuration. (Constructor)
     */
    public Frame() {
        setBounds(100,100,600,400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Test System");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        SetPanels();
        setVisible(true);
    }

    /**
     * Add and set panels positions inside our frame.
     */
    private void SetPanels() {
        titlePanel = new TitlePanel();
        add(titlePanel, BorderLayout.NORTH);

        buttonsPanel = new ButtonsPanel();
        add(buttonsPanel,BorderLayout.SOUTH);
    }
}
