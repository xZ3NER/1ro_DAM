package SourceCode.view.mainPanels.MainPanel.basePanel.ddbbPanels;

import SourceCode.view.mainPanels.MainPanel.basePanel.BasePanel;
import SourceCode.view.mainPanels.MainPanel.basePanel.DdbbView;

import java.awt.*;

public class FoodDDBB extends BasePanel {

    public FoodDDBB() {
        getSearchBar().AddFoodProducts();
        AddFoodListener();

        SetAllDDBB();
    }

    public void SetAllDDBB() {
        ddbbView = new DdbbView(PRODUCT_COL_NUMBER);
        ddbbView.SetTableData(PRODUCT_SQL_QUERY);
        add(ddbbView, BorderLayout.CENTER);
    }
}
