package SourceCode.view.mainPanels.MainPanel.basePanel;

import SourceCode.MainClass;
import SourceCode.model.DDBB.IRestaurantSentences;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Vector;

public class DdbbView extends JPanel implements IRestaurantSentences {

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
            case CUSTOMER_COL_NUMBER -> SetColsNames(CUSTOMER_COLS_NAMES);
            case TICKETS_COL_NUMBER -> SetColsNames(TICKET_COLS_NAMES);
            case PRODUCT_COL_NUMBER -> SetColsNames(PRODUCT_COLS_NAMES);
            case PAYMENTS_COL_NUMBER -> SetColsNames(PAYMENTS_COLS_NAMES);
        }
    }

    private void SetColsNames(String[] colNames) {
        for (int i = 0; i < colNames.length; i++) {
            tableModel.addColumn(colNames[i]);
        }
    }

    public void SetTableData(String query) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(query);
            while (resultSet.next()) {
                AddData(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void AddData(ResultSet resultSet) throws SQLException {
        Vector<String> rowData = new Vector<>();

        for (int i = 1; i <= tableModel.getColumnCount() ; i++) {
            rowData.add(resultSet.getString(i));
        }

        tableModel.addRow(rowData);
    }

    private void AddFoodData(ResultSet resultSet) throws SQLException {
        Vector<String> rowData = new Vector<>();

        for (int i = 1; i <= tableModel.getColumnCount() ; i++) {
            rowData.add(resultSet.getString(i));

            if (i==3) {
                rowData.add("");
                i++;
            }
        }

        tableModel.addRow(rowData);
    }

    public void SearchByID(String query,String extraQuery, String id) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(query+id+")"+extraQuery);
            while (resultSet.next()) {
                AddData(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void SearchByFoodID(String query,String extraQuery, String id) {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery(query+id+")"+extraQuery);
            while (resultSet.next()) {
                AddFoodData(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
