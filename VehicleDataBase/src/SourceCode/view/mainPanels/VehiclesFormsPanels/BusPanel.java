package SourceCode.view.mainPanels.VehiclesFormsPanels;

import SourceCode.MainClass;
import SourceCode.model.classes.Bus;
import SourceCode.view.mainPanels.VehiclesFormsPanels.Input.FormInput;
import SourceCode.view.mainPanels.VehiclesFormsPanels.Input.FormInputSelector;

import java.sql.SQLException;
import java.util.Locale;

public class BusPanel extends ParentPanel {

    public BusPanel() {
        super();
        additionalPanelAspect();

    }

    @Override
    public void additionalPanelAspect() {
        for (String title : ONLY_BUS_COLS) {
            if (!title.equals("Type of service")) {
                additionalFormInputList.add(new FormInput(title));
            } else {
                additionalFormInputSelectorList.add(new FormInputSelector(title, BUS_SERVICES_SELECTOR));
            }
        }

        AddForms();
    }

    @Override
    protected void createVehicleObject() {
        String[] globalData = new String[globalFormInputList.size()];
        String[] additionalData = new String[additionalFormInputList.size()];
        String[] additionalSelectionData = new String[additionalFormInputSelectorList.size()];

        for (int i = 0; i < globalData.length; i++) {
            globalData[i] = globalFormInputList.get(i).getText().toUpperCase(Locale.ROOT);
        }

        for (int i = 0; i < additionalData.length; i++) {
            additionalData[i] = additionalFormInputList.get(i).getText().toUpperCase(Locale.ROOT);
        }

        for (int i = 0; i < additionalFormInputSelectorList.size(); i++) {
            additionalSelectionData[i] = (String) additionalFormInputSelectorList.get(i).getSelectedItem();
        }

        vehicle = new Bus(
                globalData[0], globalData[1], globalData[2], globalData[3], Integer.parseInt(globalData[4]), globalData[5],
                Integer.parseInt(additionalData[0]), additionalSelectionData[0]
        );
    }

    @Override
    protected void insertToDDBB() throws SQLException {
        MainClass.getDataBase().executeUpdate("INSERT INTO `guaguas` " +
                "(`matricula_guaguas`,`numero_plazas`,`tipo_servicio`) " +
                "VALUES ('" + vehicle.getLicensePlate() + "','" + ((Bus) vehicle).getNumberOfPlaces() + "'," +
                "'" + ((Bus) vehicle).getServiceType() + "')");
    }
}
