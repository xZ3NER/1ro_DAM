package SourceCode.view.mainPanels.MainPanel;

import SourceCode.view.IPanelNames;
import SourceCode.view.ImageLabel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements IPanelNames {

    private ImageLabel motorcycleGif = new ImageLabel("motorcycle", MOTORCYCLE_DDBB);
    private ImageLabel busGif = new ImageLabel("bus", BUS_DDBB);
    private ImageLabel carGif = new ImageLabel("car", PASSENGER_CAR_DDBB);
    private ImageLabel databaseGif = new ImageLabel("database", ALL_DATABASE);

    public MainPanel() {
        setLayout(new GridLayout(2, 2, 100, 80));
        setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 50));
        setBackground(Color.WHITE);

        AddGif();
    }

    private void AddGif() {
        add(motorcycleGif);
        add(busGif);
        add(carGif);
        add(databaseGif);

        carGif.AddGifListeners();
        busGif.AddGifListeners();
        motorcycleGif.AddGifListeners();
        databaseGif.AddGifListeners();
    }
}
