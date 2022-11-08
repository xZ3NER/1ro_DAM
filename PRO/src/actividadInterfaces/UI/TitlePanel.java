package actividadInterfaces.UI;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

    protected static JLabel title = new JLabel("Object creator tester");
    protected static JLabel subTitle = new JLabel("Select which class of object do you want to create...");

    /**
     * Title panel configurations. (Constructor)
     */
    public TitlePanel() {
        setLayout(new GridLayout(2,1));
        setPreferredSize(new Dimension(600,150));

        SetTitleStyle();
        SetSubTitleStyle();
        add(title);
        add(subTitle);
    }

    /**
     * Set the style of the title text.
     */
    private void SetTitleStyle() {
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Candara", Font.BOLD,40));
        title.setBorder(BorderFactory.createEmptyBorder(40,40,0,40));
    }

    /**
     * Set the style of the subtitle text.
     */
    private void SetSubTitleStyle() {
        subTitle.setHorizontalAlignment(JLabel.CENTER);
        subTitle.setFont(new Font("Candara Light", Font.PLAIN,22));
        subTitle.setBorder(BorderFactory.createEmptyBorder(40,40,0,40));
    }
}
