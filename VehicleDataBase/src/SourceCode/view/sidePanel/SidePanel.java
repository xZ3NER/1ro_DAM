package SourceCode.view.sidePanel;

import SourceCode.view.IPanelNames;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SidePanel extends JPanel implements IPanelNames {

    protected static ArrayList<SidePanelLabel> labelList = new ArrayList<>();
    private static Color color;

    public SidePanel() {
        setLayout(new GridLayout(8, 1));
        setBackground(new Color(52, 203, 203));
        color = getBackground();

        setPreferredSize(new Dimension(250, 600));

        AddLabels();
    }

    public static Color getBGColor() {
        return color;
    }

    private void AddLabels() {
        labelList.add(new SidePanelLabel(DATABASE));
        labelList.add(new SidePanelLabel(MOTORCYCLE));
        labelList.add(new SidePanelLabel(BUS));
        labelList.add(new SidePanelLabel(PASSENGER_CAR));

        for (SidePanelLabel label : labelList) {
            add(label);
        }
    }
}
