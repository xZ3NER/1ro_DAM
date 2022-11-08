package SourceCode.view;

import SourceCode.view.mainPanels.CardLayoutPanel;
import SourceCode.view.sidePanel.SidePanel;
import SourceCode.view.topPanel.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MenuFrame extends JFrame {

    public static CardLayoutPanel mainPanel = new CardLayoutPanel();
    private static int mouseX;
    private static int mouseY;
    private TopPanel topPanel = new TopPanel();
    private SidePanel sidePanel = new SidePanel();

    public MenuFrame() {
        setBounds(100, 100, 1200, 700);
        setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);

        AddPanels();
        AddDragListener();
        add(mainPanel);

        setVisible(true);
    }

    private void AddDragListener() {

        topPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {

                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        topPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                int x = e.getXOnScreen() - mouseX;
                int y = e.getYOnScreen() - mouseY;

                MoveFrame(x, y);
            }
        });
    }

    private void AddPanels() {
        add(sidePanel, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);
    }

    private void MoveFrame(int positionX, int positionY) {
        setLocation(positionX, positionY);
    }
}
