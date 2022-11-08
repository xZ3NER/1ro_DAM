package SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels;

import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.DdbbView;

import java.awt.*;

public class AllDataBase extends BasePanel {

    public AllDataBase() {
        getSearchBar().AddAllDataBaseLicenses();
        AddAllDataBaseListener();

        SetAllDDBB();
    }

    private void SetAllDDBB() {
        ddbbView = new DdbbView(ALL_COL_NUMBER);

        ddbbView.SetAllTableData(MOTORCYCLE_TABLE_NAME, MOTORCYCLE_LICENSE_PLATE);
        ddbbView.SetAllTableData(CAR_TABLE_NAME, CAR_LICENSE_PLATE);
        ddbbView.SetAllTableData(BUS_TABLE_NAME, BUS_LICENSE_PLATE);
        add(ddbbView, BorderLayout.CENTER);
    }
}
