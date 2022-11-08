package SourceCode.view.mainPanels.MainPanel;

import SourceCode.view.IPanelNames;
import SourceCode.view.ImageLabel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel implements IPanelNames {

    private ImageLabel customerGif = new ImageLabel("customer", CUSTOMER_DDBB);
    private ImageLabel ticketGif = new ImageLabel("ticket", TICKET_DDBB);
    private ImageLabel foodGif = new ImageLabel("food", FOOD_DDBB);
    private ImageLabel payGif = new ImageLabel("pay", PAYMENT);

    public MainPanel() {
        setLayout(new GridLayout(2, 2, 100, 80));
        setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 50));
        setBackground(Color.WHITE);

        AddGif();
    }

    private void AddGif() {
        add(customerGif);
        add(ticketGif);
        add(foodGif);
        add(payGif);

        customerGif.AddGifListeners();
        ticketGif.AddGifListeners();
        foodGif.AddGifListeners();
        payGif.AddGifListeners();
    }
}
