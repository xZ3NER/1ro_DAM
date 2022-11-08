package SourceCode.view.mainPanels.MainPanel.basePanel;

import SourceCode.model.DDBB.IRestaurantSentences;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public abstract class BasePanel extends JPanel implements IRestaurantSentences {

    protected DdbbView ddbbView;
    private SearchBar searchBar = new SearchBar();

    public SearchBar getSearchBar() {
        return searchBar;
    }

    public BasePanel() {
        setBackground(Color.WHITE);

        add(searchBar, BorderLayout.NORTH);
    }

    protected void AddCustomerListener() {
        searchBar.getSearchBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerSearchBar();
            }
        });

        searchBar.getReloadImage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CustomerSearchBar();
            }
        });
    }

    private void CustomerSearchBar() {
        if (searchBar.getSearchBar().getSelectedItem().equals("ALL")) {
            BugPatch();

            ddbbView = new DdbbView(CUSTOMER_COL_NUMBER);
            ddbbView.SetTableData(CUSTOMER_SQL_QUERY);

            add(ddbbView, BorderLayout.CENTER);
        } else {
            BugPatch();

            ddbbView = new DdbbView(CUSTOMER_COL_NUMBER);

            String ticket_code = (String) searchBar.getSearchBar().getSelectedItem();
            ddbbView.SearchByID(CUSTOMER_SEARCH_BY_ID,CUSTOMER_EXTRA_QUERY, ticket_code);

            add(ddbbView, BorderLayout.CENTER);
        }
    }

    protected void AddPaymentsListener() {
        searchBar.getSearchBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentsSearchBar();
            }
        });

        searchBar.getReloadImage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PaymentsSearchBar();
            }
        });
    }

    private void PaymentsSearchBar() {
        if (!searchBar.getSearchBar().getSelectedItem().equals("ALL")) {

            BugPatch();
            searchBar.getPayImage().setVisible(true);

            ddbbView = new DdbbView(PAYMENTS_COL_NUMBER);

            String ticket_code = (String) searchBar.getSearchBar().getSelectedItem();
            ddbbView.SearchByID(PAYMENTS_SEARCH_BY_ID,PAYMENTS_EXTRA_QUERY, ticket_code);

            SetSpacer();
            SetFoodView();

            ddbbView.SearchByFoodID(PAYMENTS_FOOD_VIEW,PAYMENTS_FOOD_VIEW_EXTRA,ticket_code);

            add(ddbbView, BorderLayout.CENTER);
        }else {
            BugPatch();
            searchBar.getPayImage().setVisible(false);

            ddbbView = new DdbbView(PAYMENTS_COL_NUMBER);
            add(ddbbView, BorderLayout.CENTER);
        }
    }

    private void SetSpacer() {
        String[] spacer ={"","","",""};
        ddbbView.getTableModel().addRow(spacer);

    }

    public void SetFoodView() {
        Vector<String> header = new Vector<>();

        for (String title: PAYMENTS_FOOD_VIEW_NAMES) {
            header.add(title);
        }

        ddbbView.getTableModel().addRow(header);
    }

    protected void AddTicketsListener() {
        searchBar.getSearchBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicketsSearchBar();
            }
        });

        searchBar.getReloadImage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TicketsSearchBar();
            }
        });
    }

    private void TicketsSearchBar() {
        if (searchBar.getSearchBar().getSelectedItem().equals("ALL")) {
            BugPatch();

            ddbbView = new DdbbView(TICKETS_COL_NUMBER);
            ddbbView.SetTableData(TICKETS_SQL_QUERY);
        } else {
            BugPatch();

            ddbbView = new DdbbView(TICKETS_COL_NUMBER);

            String licensePlate = (String) searchBar.getSearchBar().getSelectedItem();
            ddbbView.SearchByID(TICKETS_SEARCH_BY_ID,TICKETS_EXTRA_QUERY, licensePlate);
        }

        add(ddbbView, BorderLayout.CENTER);
    }

    protected void AddFoodListener() {
        searchBar.getSearchBar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FoodSearchBar();
            }
        });

        searchBar.getReloadImage().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FoodSearchBar();
            }
        });
    }

    private void FoodSearchBar() {
        if (searchBar.getSearchBar().getSelectedItem().equals("ALL")) {
            BugPatch();

            ddbbView = new DdbbView(PRODUCT_COL_NUMBER);
            ddbbView.SetTableData(PRODUCT_SQL_QUERY);
        } else {
            BugPatch();

            ddbbView = new DdbbView(PRODUCT_COL_NUMBER);

            String ID = (String) searchBar.getSearchBar().getSelectedItem();
            ddbbView.SearchByID(PRODUCT_SEARCH_BY_ID,"", ID);
        }

        add(ddbbView, BorderLayout.CENTER);
    }

    private void BugPatch() {
        ddbbView.setVisible(false);
        remove(ddbbView);
        ddbbView.setVisible(true);
    }
}
