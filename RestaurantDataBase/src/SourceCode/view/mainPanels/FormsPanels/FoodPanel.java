package SourceCode.view.mainPanels.FormsPanels;

import SourceCode.MainClass;
import SourceCode.model.classes.Food;
import SourceCode.model.utilities.Patterns;
import SourceCode.view.mainPanels.FormsPanels.Input.FormInput;
import SourceCode.view.mainPanels.FormsPanels.Input.FormInputSelector;

import java.awt.*;
import java.sql.SQLException;
import java.util.Vector;

public class FoodPanel extends ParentPanel {

    private Food newFood;

    public FoodPanel() {
        additionalPanelAspect();
    }

    @Override
    protected boolean VerifyData() {
        java.lang.String[] data = new java.lang.String[formInputList.size()];

        for (int i = 0; i < formInputList.size(); i++) {
            data[i] = formInputList.get(i).getText();
        }

        if (CheckNull(data)) {
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                if (!Patterns.onlyDigitCheck(data[i])) {
                    formInputList.get(i).setForeground(Color.red);
                    return false;
                }
            }
            if (i == 1) {
                if (!Patterns.onlyStringCheck(data[i])) {
                    formInputList.get(i).setForeground(Color.red);
                    return false;
                }
            }
            if (i == 2) {
                if (!Patterns.onlyDoubleCheck(data[i])) {
                    formInputList.get(i).setForeground(Color.red);
                    return false;
                } else {
                    if (!Patterns.NegativeNumberCheck(data[i])) {
                        formInputList.get(i).setForeground(Color.red);
                        return false;
                    }
                }
            }
            if (i == 3) {
                if (!Patterns.onlyStringCheck(data[i])) {
                    formInputList.get(i).setForeground(Color.red);
                    return false;
                }
            }
        }

        return true;
    }

    protected boolean CheckNull(java.lang.String[] data) {
        for (int i = 0; i < data.length; i++) {

            if (Patterns.CheckIfNull(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void additionalPanelAspect() {
        formInputList.add(new FormInput("Product Code"));
        formInputList.add(new FormInput("Product Name"));
        formInputList.add(new FormInput("Product Price"));
        formInputList.add(new FormInput("Product Ingredients"));
        formInputSelectorList.add(new FormInputSelector("Category",CATEGORY_OPTIONS));

        initializePanel();
    }

    @Override
    protected void createObject() throws SQLException {
        Vector<java.lang.String> allData = new Vector<>();
        GetAllData(allData);

        newFood = new Food(allData.get(0),allData.get(1),allData.get(2),allData.get(3),allData.get(4));
        insertToDDBB();
    }

    private void GetAllData(Vector<java.lang.String> allData) {

        for (int i=0;i<formInputList.size();i++) {
            allData.add(formInputList.get(i).getText());
        }

        for (int i=0;i<formInputSelectorList.size();i++) {
            allData.add((java.lang.String) formInputSelectorList.get(i).getSelectedItem());
        }
    }

    @Override
    protected void insertToDDBB() throws SQLException {
        try {
            MainClass.getDataBase().executeUpdate("INSERT INTO `productos` " +
                    "(`codigo_producto`, `codigo_categoria_producto`, `precio_producto`, `ingredientes_producto`, `nombre_producto`) " +
                    "VALUES ('" + newFood.getProductCode() + "', '" + newFood.getCategoryCode() + "', '" + newFood.getProductPrice() + "', '" + newFood.getProductIngredients() + "', '" + newFood.getProductName() + "');");

            ShowOptionPane("Successfully added!", "../../../../res/checked.png");
        }catch (SQLException ex) {
            ShowOptionPane("¡ID already exists!", "../../../../res/cancel.png");
        }
    }
}
