package SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels;

import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.DdbbView;

import java.awt.*;

public class CustomerDDBB extends BasePanel {

    public CustomerDDBB() {
        getSearchBar().AddCustomerTickets();
        AddCustomerListener();

        SetAllDDBB();
    }

    public void SetAllDDBB() {
        ddbbView = new DdbbView(CUSTOMER_COL_NUMBER);
        ddbbView.SetTableData(CUSTOMER_SQL_QUERY);
        add(ddbbView, BorderLayout.CENTER);
    }
}
