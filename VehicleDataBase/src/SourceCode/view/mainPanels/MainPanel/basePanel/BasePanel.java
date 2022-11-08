package SourceCode.view.mainPanels.MainPanel.basePanel;

import SourceCode.model.DDBB.IVehiclesCols;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class BasePanel extends JPanel implements IVehiclesCols {

    protected DdbbView ddbbView;
    private SearchBar searchBar = new SearchBar();

    public SearchBar getSearchBar() {
        return searchBar;
    }

    public BasePanel() {
        setBackground(Color.WHITE);

        add(searchBar, BorderLayout.NORTH);
    }

    protected void AddCarListener() {
        searchBar.getSearchBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarSearchBar();
            }
        });

        searchBar.getReloadImage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CarSearchBar();

            }
        });
    }

    private void CarSearchBar() {
        if (searchBar.getSearchBar().getSelectedItem().equals("ALL")) {
            BugPatch();

            ddbbView = new DdbbView(CAR_COL_NUMBER);
            ddbbView.SetTableData(CAR_TABLE_NAME, CAR_LICENSE_PLATE);

            add(ddbbView, BorderLayout.CENTER);
        } else {
            BugPatch();

            ddbbView = new DdbbView(CAR_COL_NUMBER);

            String licensePlate = (String) searchBar.getSearchBar().getSelectedItem();
            ddbbView.SearchByLicensePlate(CAR_TABLE_NAME, CAR_LICENSE_PLATE, licensePlate);

            add(ddbbView, BorderLayout.CENTER);
        }
    }

    protected void AddBusListener() {
        searchBar.getSearchBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BusSearchBar();
            }
        });

        searchBar.getReloadImage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BusSearchBar();
            }
        });
    }

    private void BusSearchBar() {
        if (searchBar.getSearchBar().getSelectedItem().equals("ALL")) {
            BugPatch();

            ddbbView = new DdbbView(BUS_COL_NUMBER);
            ddbbView.SetTableData(BUS_TABLE_NAME, BUS_LICENSE_PLATE);
        } else {
            BugPatch();

            ddbbView = new DdbbView(BUS_COL_NUMBER);

            String licensePlate = (String) searchBar.getSearchBar().getSelectedItem();
            ddbbView.SearchByLicensePlate(BUS_TABLE_NAME, BUS_LICENSE_PLATE, licensePlate);
        }

        add(ddbbView, BorderLayout.CENTER);
    }

    protected void AddMotorcycleListener() {
        searchBar.getSearchBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MotorcycleSearchBar();
            }
        });

        searchBar.getReloadImage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MotorcycleSearchBar();
            }
        });
    }

    private void MotorcycleSearchBar() {
        if (searchBar.getSearchBar().getSelectedItem().equals("ALL")) {
            BugPatch();

            ddbbView = new DdbbView(MOTORCYCLE_COL_NUMBER);
            ddbbView.SetTableData(MOTORCYCLE_TABLE_NAME, MOTORCYCLE_LICENSE_PLATE);
        } else {
            BugPatch();

            ddbbView = new DdbbView(MOTORCYCLE_COL_NUMBER);

            String licensePlate = (String) searchBar.getSearchBar().getSelectedItem();
            ddbbView.SearchByLicensePlate(MOTORCYCLE_TABLE_NAME, MOTORCYCLE_LICENSE_PLATE, licensePlate);
        }

        add(ddbbView, BorderLayout.CENTER);
    }

    protected void AddAllDataBaseListener() {
        searchBar.getSearchBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AllDataBaseSearchBar();
            }
        });

        searchBar.getReloadImage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AllDataBaseSearchBar();
            }
        });
    }

    private void AllDataBaseSearchBar() {
        if (searchBar.getSearchBar().getSelectedItem().equals("ALL")) {
            BugPatch();
            ddbbView = new DdbbView(ALL_COL_NUMBER);

            ddbbView.SetAllTableData(MOTORCYCLE_TABLE_NAME, MOTORCYCLE_LICENSE_PLATE);
            ddbbView.SetAllTableData(CAR_TABLE_NAME, CAR_LICENSE_PLATE);
            ddbbView.SetAllTableData(BUS_TABLE_NAME, BUS_LICENSE_PLATE);
        } else {
            BugPatch();
            ddbbView = new DdbbView(ALL_COL_NUMBER);

            String licensePlate = (String) searchBar.getSearchBar().getSelectedItem();
            ddbbView.SearchByLicensePlateAll(MOTORCYCLE_TABLE_NAME, MOTORCYCLE_LICENSE_PLATE, licensePlate);
            ddbbView.SearchByLicensePlateAll(CAR_TABLE_NAME, CAR_LICENSE_PLATE, licensePlate);
            ddbbView.SearchByLicensePlateAll(BUS_TABLE_NAME, BUS_LICENSE_PLATE, licensePlate);
        }

        add(ddbbView, BorderLayout.CENTER);
    }

    private void BugPatch() {
        ddbbView.setVisible(false);
        remove(ddbbView);
        ddbbView.setVisible(true);
    }
}
