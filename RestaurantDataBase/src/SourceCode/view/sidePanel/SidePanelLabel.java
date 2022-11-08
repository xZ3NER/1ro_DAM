package SourceCode.view.sidePanel;

import SourceCode.view.IPanelNames;
import SourceCode.view.MenuFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SidePanelLabel extends JLabel implements IPanelNames {

    final private Color clickColor = new Color(50, 162, 162);

    public SidePanelLabel(String text) {
        setText(text);
        setForeground(Color.white);
        setOpaque(true);
        setBackground(SidePanel.getBGColor());
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Candara Light", Font.BOLD, 28));
        SetInitialColor();
        AddSelectorListener();
    }

    private void AddSelectorListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                ResetSideColor();
                setBackground(clickColor);

                SetActivePanel();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }

    private void SetActivePanel() {
        CardLayout cardLayout = (CardLayout) (MenuFrame.mainPanel.getLayout());
        cardLayout.show(MenuFrame.mainPanel, getText());
    }

    private void ResetSideColor() {
        for (SidePanelLabel label : SidePanel.labelList) {
            label.setBackground(SidePanel.getBGColor());
        }
    }

    private void SetInitialColor() {
        if (getText().equals(MENU)) {
            setBackground(clickColor);
        }
    }

}
