package SourceCode.view.mainPanels;

import SourceCode.view.IPanelNames;
import SourceCode.view.mainPanels.MainPanel.MainPanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels.Payment;
import SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels.TicketDDBB;
import SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels.FoodDDBB;
import SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels.CustomerDDBB;
import SourceCode.view.mainPanels.FormsPanels.FoodPanel;
import SourceCode.view.mainPanels.FormsPanels.CustomerPanel;

import javax.swing.*;
import java.awt.*;

public class CardLayoutPanel extends JPanel implements IPanelNames {

    private MainPanel menuPanel = new MainPanel();
    private CustomerPanel customerPanel = new CustomerPanel();
    private FoodPanel foodPanel = new FoodPanel();

    private BasePanel customerDDBB = new CustomerDDBB();
    private BasePanel ticketDDBB = new TicketDDBB();
    private BasePanel foodDDBB = new FoodDDBB();
    private BasePanel payment = new Payment();

    public CardLayoutPanel() {
        setLayout(new CardLayout());

        AddInitialPanels();
        AddDataBasePanels();

        setVisible(true);
    }

    private void AddDataBasePanels() {
        add(foodDDBB,FOOD_DDBB);
        add(ticketDDBB, TICKET_DDBB);
        add(customerDDBB, CUSTOMER_DDBB);
        add(payment, PAYMENT);
    }

    private void AddInitialPanels() {
        add(menuPanel, MENU);
        add(customerPanel, CUSTOMER);
        add(foodPanel, FOOD);
    }
}
