package SourceCode.view.mainPanels;

import SourceCode.view.IPanelNames;
import SourceCode.view.mainPanels.MainPanel.MainPanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels.AllDataBase;
import SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels.BusDDBB;
import SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels.CarDDBB;
import SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels.MotorcycleDDBB;
import SourceCode.view.mainPanels.VehiclesFormsPanels.BusPanel;
import SourceCode.view.mainPanels.VehiclesFormsPanels.MotorcyclePanel;
import SourceCode.view.mainPanels.VehiclesFormsPanels.PassengerCarPanel;

import javax.swing.*;
import java.awt.*;

public class CardLayoutPanel extends JPanel implements IPanelNames {

    private MainPanel mainPanel = new MainPanel();
    private MotorcyclePanel motorcyclePanel = new MotorcyclePanel();
    private BusPanel busPanel = new BusPanel();
    private PassengerCarPanel passengerCarPanel = new PassengerCarPanel();

    private BasePanel motorcycleDDBB = new MotorcycleDDBB();
    private BasePanel carDDBB = new CarDDBB();
    private BasePanel busDDBB = new BusDDBB();
    private BasePanel allDataBase = new AllDataBase();

    public CardLayoutPanel() {
        setLayout(new CardLayout());

        AddInitialPanels();
        AddDataBasePanels();

        setVisible(true);
    }

    private void AddDataBasePanels() {
        add(motorcycleDDBB, MOTORCYCLE_DDBB);
        add(carDDBB, PASSENGER_CAR_DDBB);
        add(busDDBB, BUS_DDBB);
        add(allDataBase, ALL_DATABASE);
    }

    private void AddInitialPanels() {
        add(mainPanel, DATABASE);
        add(motorcyclePanel, MOTORCYCLE);
        add(busPanel, BUS);
        add(passengerCarPanel, PASSENGER_CAR);
    }
}
