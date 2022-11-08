package SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels;

import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.DdbbView;

import java.awt.*;

public class Payment extends BasePanel {

    public Payment() {
        getSearchBar().AddPaymentsTickets();
        AddPaymentsListener();

        SetAllDDBB();
        getSearchBar().AddPayButton();
    }

    public void SetAllDDBB() {
        ddbbView = new DdbbView(PAYMENTS_COL_NUMBER);
        add(ddbbView, BorderLayout.CENTER);
    }
}
