package SourceCode.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class ImageLabel extends JLabel {

    private ImageIcon logo;
    private String url;

    public ImageLabel(String url, String name) {

        setName(name);
        this.url = url;

        //"/img/logo.png"
        this.logo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../../res/"+url + ".png")));

        setBackground(Color.WHITE);
        setIcon(logo);
        setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 15));
    }

    public void AddGifListeners() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                SetActivePanel();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursor(new Cursor(Cursor.HAND_CURSOR));

                logo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../../res/"+url + ".gif")));
                setIcon(logo);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);

                logo = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../../res/"+url + ".png")));
                setIcon(logo);
            }
        });
    }

    private void SetActivePanel() {
        CardLayout cardLayout = (CardLayout) (MenuFrame.mainPanel.getLayout());
        cardLayout.show(MenuFrame.mainPanel, getName());
    }
}
