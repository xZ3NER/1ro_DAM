package SourceCode.view.mainPanels.MainPanel.basePanel;

import SourceCode.MainClass;
import SourceCode.model.DDBB.IVehiclesCols;
import SourceCode.view.ImageLabel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchBar extends JPanel implements IVehiclesCols {

    private Border titledBorder = BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(52, 203, 203), 5, true), "Search"
    );

    private JComboBox searchBar = new JComboBox();
    private ImageLabel reloadImage = new ImageLabel("reload", "reload");

    public ImageLabel getReloadImage() {
        return reloadImage;
    }

    public JComboBox getSearchBar() {
        return searchBar;
    }

    public SearchBar() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 65));

        searchBar.setBorder(titledBorder);
        searchBar.setFont(new Font("Candara", Font.BOLD, 25));
        searchBar.setEditable(true);
        searchBar.setBackground(Color.white);
        searchBar.addItem("ALL");

        reloadImage.setOpaque(true);
        reloadImage.setBackground(Color.WHITE);
        reloadImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        add(searchBar);
        add(reloadImage, BorderLayout.EAST);
    }

    public void AddCarLicenses() {

        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery("SELECT * FROM `" + CAR_TABLE_NAME + "` INNER JOIN `vehiculos` ON `vehiculos`." + VEHICLE_LICENSE_PLATE + " LIKE `" + CAR_TABLE_NAME + "`." + CAR_LICENSE_PLATE + "");
            while (resultSet.next()) {
                searchBar.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void AddBusLicenses() {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery("SELECT * FROM `" + BUS_TABLE_NAME + "` INNER JOIN `vehiculos` ON `vehiculos`." + VEHICLE_LICENSE_PLATE + " LIKE `" + BUS_TABLE_NAME + "`." + BUS_LICENSE_PLATE + "");
            while (resultSet.next()) {
                searchBar.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void AddMotorcycleLicenses() {
        ResultSet resultSet;

        try {
            resultSet = MainClass.getDataBase().executeQuery("SELECT * FROM `" + MOTORCYCLE_TABLE_NAME + "` INNER JOIN `vehiculos` ON `vehiculos`." + VEHICLE_LICENSE_PLATE + " LIKE `" + MOTORCYCLE_TABLE_NAME + "`." + MOTORCYCLE_LICENSE_PLATE + "");

            while (resultSet.next()) {
                searchBar.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void AddAllDataBaseLicenses() {
        AddMotorcycleLicenses();
        AddCarLicenses();
        AddBusLicenses();
    }
}
