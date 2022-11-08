package SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels;

import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.DdbbView;

import java.awt.*;

public class CarDDBB extends BasePanel {

    public CarDDBB() {
        getSearchBar().AddCarLicenses();
        AddCarListener();

        SetAllDDBB();
    }

    public void SetAllDDBB() {
        ddbbView = new DdbbView(CAR_COL_NUMBER);
        ddbbView.SetTableData(CAR_TABLE_NAME, CAR_LICENSE_PLATE);
        add(ddbbView, BorderLayout.CENTER);
    }
}
