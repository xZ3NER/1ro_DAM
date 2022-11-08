package SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels;

import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.DdbbView;

import java.awt.*;

public class MotorcycleDDBB extends BasePanel {

    public MotorcycleDDBB() {
        getSearchBar().AddMotorcycleLicenses();
        AddMotorcycleListener();

        SetAllDDBB();
    }

    public void SetAllDDBB() {
        ddbbView = new DdbbView(MOTORCYCLE_COL_NUMBER);
        ddbbView.SetTableData(MOTORCYCLE_TABLE_NAME, MOTORCYCLE_LICENSE_PLATE);
        add(ddbbView, BorderLayout.CENTER);
    }
}
