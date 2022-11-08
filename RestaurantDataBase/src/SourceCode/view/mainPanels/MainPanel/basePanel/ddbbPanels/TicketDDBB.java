package SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels;

import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.DdbbView;

import java.awt.*;

public class TicketDDBB extends BasePanel {

    public TicketDDBB() {
        getSearchBar().AddTicketsCodes();
        AddTicketsListener();

        SetAllDDBB();
    }

    private void SetAllDDBB() {
        ddbbView = new DdbbView(TICKETS_COL_NUMBER);
        ddbbView.SetTableData(TICKETS_SQL_QUERY);
        add(ddbbView, BorderLayout.CENTER);
    }
}
