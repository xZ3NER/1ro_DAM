package SourceCode.view.topPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class TopPanelClose extends JLabel {

    private ImageIcon closeIconHover =
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../../../res/closeHover.png")));
    private ImageIcon closeIcon =
            new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../../../res/close.png")));

    public TopPanelClose() {

        CloseIconStyle();

        AddStyleListeners();
        setIcon(closeIcon);
    }

    private void CloseIconStyle() {

        closeIcon = ResizeIcon(closeIcon);
        closeIconHover = ResizeIcon(closeIconHover);
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
    }

    private ImageIcon ResizeIcon(ImageIcon icon) {
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);

        return icon;
    }

    private void AddStyleListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                setIcon(closeIconHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setIcon(closeIcon);
            }
        });
    }
}
