package SourceCode.view.topPanel;

import SourceCode.view.ImageLabel;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    private ImageLabel logoIcon = new ImageLabel("logo", "");
    private ImageLabel titleIcon = new ImageLabel("title", "");
    private TopPanelClose closeIcon = new TopPanelClose();

    public TopPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(36, 148, 148));
        setPreferredSize(new Dimension(1200, 100));

        add(closeIcon, BorderLayout.EAST);
        add(logoIcon, BorderLayout.WEST);
        add(titleIcon);
    }
}
