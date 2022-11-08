package SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels;

import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.DdbbView;

import java.awt.*;

public class BusDDBB extends BasePanel {

    public BusDDBB() {
        getSearchBar().AddBusLicenses();
        AddBusListener();

        SetAllDDBB();
    }

    private void SetAllDDBB() {
        ddbbView = new DdbbView(BUS_COL_NUMBER);
        ddbbView.SetTableData(BUS_TABLE_NAME, BUS_LICENSE_PLATE);
        add(ddbbView, BorderLayout.CENTER);
    }
}
