package SourceCode.view.mainPanels.VehiclesFormsPanels;

import SourceCode.MainClass;
import SourceCode.model.classes.Motorcycles;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Locale;

public class MotorcyclePanel extends ParentPanel {

    public MotorcyclePanel() {
        super();
        additionalPanelAspect();
    }

    @Override
    public void additionalPanelAspect() {
    }

    @Override
    protected void createVehicleObject() throws ParseException {
        String[] data = new String[globalFormInputList.size()];

        for (int i = 0; i < data.length; i++) {
            data[i] = globalFormInputList.get(i).getText().toUpperCase(Locale.ROOT);
        }

        vehicle = new Motorcycles(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), data[5]);
    }

    @Override
    protected void insertToDDBB() throws SQLException {
        MainClass.getDataBase().executeUpdate("INSERT INTO `motos` " +
                "(`matricula_moto`) VALUES ('" + vehicle.getLicensePlate() + "')");
    }
}
