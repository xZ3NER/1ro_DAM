package SourceCode.view.mainPanels.VehiclesFormsPanels;

import SourceCode.MainClass;
import SourceCode.model.classes.PassengerCars;
import SourceCode.view.mainPanels.VehiclesFormsPanels.Input.FormInput;
import SourceCode.view.mainPanels.VehiclesFormsPanels.Input.FormInputSelector;

import java.sql.SQLException;
import java.util.Locale;

public class PassengerCarPanel extends ParentPanel {

    public PassengerCarPanel() {
        super();
        additionalPanelAspect();

    }

    @Override
    public void additionalPanelAspect() {
        for (String title : ONLY_CARS_COLS) {
            if (!title.equals("Possibility")) {
                additionalFormInputList.add(new FormInput(title));
            } else {
                additionalFormInputSelectorList.add(new FormInputSelector(title, CAR_POSSIBILITIES_SELECTOR));
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

        vehicle = new PassengerCars(
                globalData[0], globalData[1], globalData[2], globalData[3], Integer.parseInt(globalData[4]), globalData[5],
                Integer.parseInt(additionalData[0]), Integer.parseInt(additionalData[1]), additionalSelectionData[0]
        );
    }

    @Override
    protected void insertToDDBB() throws SQLException {
        MainClass.getDataBase().executeUpdate("INSERT INTO `turismos` " +
                "(`matricula_turismos`,`numero_plazas`,`posibilidad`,`numero_puertas`) " +
                "VALUES ('" + vehicle.getLicensePlate() + "','" + ((PassengerCars) vehicle).getNumberOfPlaces() + "'," +
                "'" + ((PassengerCars) vehicle).getPossibility() + "','" + ((PassengerCars) vehicle).getNumberOfDoors() + "')");
    }

}
