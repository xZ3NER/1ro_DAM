package SourceCode.view.mainPanels.VehiclesFormsPanels;

import SourceCode.MainClass;
import SourceCode.model.DDBB.IVehiclesCols;
import SourceCode.model.classes.Vehicles;
import SourceCode.model.utilities.Patterns;
import SourceCode.view.mainPanels.VehiclesFormsPanels.Input.FormInput;
import SourceCode.view.mainPanels.VehiclesFormsPanels.Input.FormInputSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class ParentPanel extends JPanel implements IVehiclesCols {

    protected final ArrayList<FormInput> globalFormInputList = new ArrayList<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final JPanel globalPanel = new JPanel(new GridLayout(3, 2, 20, 20));
    private final JPanel buttonPanel = new JPanel();
    private final JButton submitButton = new JButton("Add vehicle");
    protected Vehicles vehicle;
    protected ArrayList<FormInput> additionalFormInputList = new ArrayList<>();
    protected ArrayList<FormInputSelector> additionalFormInputSelectorList = new ArrayList<>();
    protected JPanel additionalPanel = new JPanel(new GridLayout(2, 2, 20, 20));

    public ParentPanel() {
        setLayout(new BorderLayout());

        initializeGlobalPanel();
        initializeAdditionalPanel();
        initializeButtonPanel();
    }

    private void initializeGlobalPanel() {
        globalPanel.setBackground(Color.WHITE);
        globalPanel.setPreferredSize(new Dimension(1000, 300));
        globalPanel.setBorder(BorderFactory.createEmptyBorder(50, 80, 30, 80));

        for (String title : VEHICLE_COLS_NAMES) {
            globalFormInputList.add(new FormInput(title));
        }

        for (FormInput form : globalFormInputList) {
            globalPanel.add(form);
        }

        add(globalPanel, BorderLayout.NORTH);
    }

    private void initializeAdditionalPanel() {
        additionalPanel.setBackground(Color.WHITE);
        additionalPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 50, 80));

        add(additionalPanel, BorderLayout.CENTER);
    }

    private void initializeButtonPanel() {
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setPreferredSize(new Dimension(1000, 100));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 80));

        SetButtonStyle();
        AddButtonListener();
        buttonPanel.add(submitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void SetButtonStyle() {
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Candara", Font.PLAIN, 25));
        submitButton.setBackground(new Color(52, 203, 203));
        submitButton.setForeground(Color.white);
        submitButton.setBorder(BorderFactory.createLineBorder(new Color(50, 162, 162), 2));
        submitButton.setPreferredSize(new Dimension(150, 50));
    }

    private void AddButtonListener() {
        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                boolean globalData = VerifyGlobalData();
                boolean additionalData = verifyAdditionalData();

                if (globalData && additionalData) {

                    try {
                        createVehicleObject();
                        boolean error = insertVehicleDDBB();

                        if (!error) {
                            ShowOptionPane("Successfully added!", "../../../../res/checked.png");
                        }
                    } catch (ParseException | SQLException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    ShowOptionPane("Verify the entered data", "../../../../res/cancel.png");
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }

    private boolean insertVehicleDDBB() throws ParseException, SQLException {
        try {
            MainClass.getDataBase().executeUpdate(
                    "INSERT INTO `vehiculos` " +
                            "(`matricula`,`dni_propietario`, `numero_chasis`, `marca`, `potencia`, `fecha_matriculacion`, `proximo_itv`) " +
                            "VALUES " +
                            "('" + vehicle.getLicensePlate() + "', '" + vehicle.getOwnerDNI() + "', " +
                            "'" + vehicle.getChassisNumber() + "', '" + vehicle.getBrand() + "', '" + vehicle.getPower() + "', " +
                            "'" + vehicle.getRegistrationDate() + "', '" + NextItvYear(vehicle.getRegistrationDate(), vehicle.itv()) + "');"
            );

            insertToDDBB();
            return false;
        } catch (SQLIntegrityConstraintViolationException e) {
            ShowOptionPane("Duplicated License plate!", "../../../../res/cancel.png");
            return true;
        }
    }

    private boolean VerifyGlobalData() {
        String[] data = new String[globalFormInputList.size()];
        int noCheckPosition = 3;

        for (int i = 0; i < globalFormInputList.size(); i++) {
            data[i] = globalFormInputList.get(i).getText();
        }

        if (CheckNull(data)) {
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            if (i == noCheckPosition) {
            } else {
                if (i == 0) {
                    if (!Patterns.LicensePlateCheck(data[i])) {
                        globalFormInputList.get(i).setForeground(Color.red);
                        return false;
                    }
                }
                if (i == 1) {
                    if (!Patterns.DniCheck(data[i])) {
                        globalFormInputList.get(i).setForeground(Color.red);
                        return false;
                    }
                }
                if (i == 2) {
                    if (!Patterns.ChassisNumberCheck(data[i])) {
                        globalFormInputList.get(i).setForeground(Color.red);
                        return false;
                    }
                }
                if (i == 4) {
                    if (!Patterns.onlyDigitCheck(data[i])) {
                        globalFormInputList.get(i).setForeground(Color.red);
                        return false;
                    } else {
                        if (!Patterns.NegativeNumberCheck(data[i])) {
                            globalFormInputList.get(i).setForeground(Color.red);
                            return false;
                        }
                    }
                }
                if (i == 5) {
                    if (!Patterns.DateCheck(data[i])) {
                        globalFormInputList.get(i).setForeground(Color.red);
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean verifyAdditionalData() {
        String[] data = new String[additionalFormInputList.size()];
        String[] selectorData = new String[additionalFormInputSelectorList.size()];

        for (int i = 0; i < additionalFormInputList.size(); i++) {
            data[i] = additionalFormInputList.get(i).getText();
        }

        for (int i = 0; i < additionalFormInputSelectorList.size(); i++) {
            selectorData[i] = (String) additionalFormInputSelectorList.get(i).getSelectedItem();
        }

        if (CheckNull(data) || CheckNull(selectorData)) {
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            if (!Patterns.onlyDigitCheck(data[i])) {
                additionalFormInputList.get(i).setForeground(Color.red);
                return false;
            } else {
                if (!Patterns.NegativeNumberCheck(data[i])) {
                    additionalFormInputList.get(i).setForeground(Color.red);
                    return false;
                }
            }
        }

        return true;
    }

    protected boolean CheckNull(String[] data) {
        for (int i = 0; i < data.length; i++) {

            if (Patterns.CheckIfNull(data[i])) {
                return true;
            }
        }
        return false;
    }

    private void ShowOptionPane(String message, String url) {
        UIManager.put("Button.font", new Font("Candara Light", Font.BOLD, 20));
        UIManager.put("OptionPane.messageFont", new Font("Candara", Font.BOLD, 20));
        UIManager.put("Button.background", new Color(52, 203, 203));
        UIManager.put("Button.foreground", Color.white);
        UIManager.put("Button.border", BorderFactory.createLineBorder(new Color(50, 162, 162), 2));

        JOptionPane.showMessageDialog(
                null, message, "Input result", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Objects.requireNonNull(this.getClass().getResource(url))));
    }

    protected String NextItvYear(String date, int itvYears) throws ParseException {
        Date newDate;
        newDate = dateFormat.parse(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        calendar.add(Calendar.YEAR, itvYears);

        newDate = calendar.getTime();

        return dateFormat.format(newDate);
    }

    protected void AddForms() {
        for (FormInput form : additionalFormInputList) {
            additionalPanel.add(form);
        }

        for (FormInputSelector form : additionalFormInputSelectorList) {
            additionalPanel.add(form);
        }
    }

    protected abstract void additionalPanelAspect();

    protected abstract void createVehicleObject() throws ParseException;

    protected abstract void insertToDDBB() throws SQLException, ParseException;
}
