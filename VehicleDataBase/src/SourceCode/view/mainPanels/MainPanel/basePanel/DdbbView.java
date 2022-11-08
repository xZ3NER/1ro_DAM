package SourceCode.view.mainPanels.MainPanel.basePanel;

import SourceCode.MainClass;
import SourceCode.model.DDBB.IVehiclesCols;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;

public class DdbbView extends JPanel implements IVehiclesCols {

    private JTable ddbbTable;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel = new DefaultTableModel();

    public DdbbView(int colsNumber) {

        DetectType(colsNumber);

        this.ddbbTable = new JTable(tableModel);

        this.scrollPane = new JScrollPane(ddbbTable);

        setPreferredSize(new Dimension(1000, 600));
        setBackground(Color.white);

        scrollPane.setPreferredSize(new Dimension(900, 500));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(36, 148, 148), 6, true));

        ddbbTable.setBackground(Color.white);
        ddbbTable.setRowHeight(30);
        ddbbTable.setEnabled(false);
        ddbbTable.setGridColor(new Color(52, 203, 203));
        ddbbTable.getTableHeader().setBackground(new Color(52, 203, 203));
        ddbbTable.getTableHeader().setPreferredSize(new Dimension(50, 40));

        scrollPane.setBackground(Color.white);
        scrollPane.setWheelScrollingEnabled(true);

        add(scrollPane);
    }

    public JTable getDdbbTable() {
        return ddbbTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    private void DetectType(int colsNumber) {
        switch (colsNumber) {
            case CAR_COL_NUMBER -> SetColsNames(CAR_COLS_NAMES);
            case BUS_COL_NUMBER -> SetColsNames(BUS_COLS_NAMES);
            case MOTORCYCLE_COL_NUMBER -> SetColsNames(MOTORCYCLE_COLS_NAMES);
            case ALL_COL_NUMBER -> SetColsNames(ALL_COLS_NAMES);
        }
    }

    private void SetColsNames(String[] colNames) {
        for (int i = 0; i < colNames.length; i++) {
            tableModel.addColumn(colNames[i]);
        }
    }

    public void SetTableData(String tableName, String licensePlate) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(
                    "SELECT * FROM `" + tableName + "` " +
                            "INNER JOIN `vehiculos` ON `vehiculos`." + VEHICLE_LICENSE_PLATE + " " +
                            "LIKE `" + tableName + "`." + licensePlate + "");
            while (resultSet.next()) {
                AddData(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void AddData(ResultSet resultSet) throws SQLException {
        Vector<String> rowData = new Vector<>();

        for (int i = 2; i <= tableModel.getColumnCount() + 1; i++) {
            rowData.add(resultSet.getString(i));
        }

        tableModel.addRow(rowData);
    }

    public void SetAllTableData(String tableName, String licensePlate) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery("SELECT * FROM `vehiculos` INNER JOIN `" + tableName + "` ON `vehiculos`." + VEHICLE_LICENSE_PLATE + " LIKE `" + tableName + "`." + licensePlate + "");
            while (resultSet.next()) {
                AddAllData(resultSet, tableName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void AddAllData(ResultSet resultSet, String tableName) throws SQLException {
        Vector<String> rowData = new Vector<>();
        rowData.add(tableName.toUpperCase(Locale.ROOT));

        for (int i = 2; i < tableModel.getColumnCount() + 1; i++) {
            try {
                rowData.add(resultSet.getString(i));
            } catch (SQLException e) {
                rowData.add("");
            }
        }

        tableModel.addRow(rowData);
    }

    public void SearchByLicensePlate(String tableName, String licensePlateName, String licensePlate) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(
                    "SELECT * FROM `" + tableName + "` " +
                            "INNER JOIN `vehiculos` ON `vehiculos`." + VEHICLE_LICENSE_PLATE + " " +
                            "LIKE `" + tableName + "`." + licensePlateName + " " +
                            "AND `" + tableName + "`." + licensePlateName + " " +
                            "LIKE '" + licensePlate + "'");
            while (resultSet.next()) {
                AddData(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void SearchByLicensePlateAll(String tableName, String licensePlateName, String licensePlate) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery("SELECT * FROM `vehiculos` INNER JOIN `" + tableName + "` ON `vehiculos`." + VEHICLE_LICENSE_PLATE + " LIKE `" + tableName + "`." + licensePlateName + " AND `" + tableName + "`." + licensePlateName + " LIKE '" + licensePlate + "'");
            while (resultSet.next()) {
                AddAllData(resultSet, tableName);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
