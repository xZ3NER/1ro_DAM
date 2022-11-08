package SourceCode.view.mainPanels.FormsPanels;

import SourceCode.model.DDBB.IRestaurantSentences;
import SourceCode.view.mainPanels.FormsPanels.Input.FormInput;
import SourceCode.view.mainPanels.FormsPanels.Input.FormInputSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Objects;

public abstract class ParentPanel extends JPanel implements IRestaurantSentences {

    protected final ArrayList<FormInput> formInputList = new ArrayList<>();
    protected final ArrayList<FormInputSelector> formInputSelectorList = new ArrayList<>();
    private final JPanel panel = new JPanel(new GridLayout(2, 2, 20, 20));
    private final JPanel buttonPanel = new JPanel();
    private final JButton submitButton = new JButton("CREATE");

    public JPanel getPanel() {
        return panel;
    }

    public ParentPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        initializeButtonPanel();
    }

    protected void initializePanel() {
        panel.setBackground(Color.WHITE);
        panel.setPreferredSize(new Dimension(1000, 250));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 80, 30, 80));

        for (FormInput form : formInputList) {
            panel.add(form);
        }

        for (FormInputSelector form : formInputSelectorList) {
            panel.add(form);
        }

        add(panel, BorderLayout.NORTH);
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

                try {
                    if (VerifyData()) {
                        createObject();
                    }else {
                        ShowOptionPane("Verify the entered data", "../../../../res/cancel.png");
                    }
                } catch (ParseException | SQLException ex) {
                    ex.printStackTrace();
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {
                submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
    }

    protected void ShowOptionPane(String message, String url) {
        UIManager.put("Button.font", new Font("Candara Light", Font.BOLD, 20));
        UIManager.put("OptionPane.messageFont", new Font("Candara", Font.BOLD, 20));
        UIManager.put("Button.background", new Color(52, 203, 203));
        UIManager.put("Button.foreground", Color.white);
        UIManager.put("Button.border", BorderFactory.createLineBorder(new Color(50, 162, 162), 2));

        JOptionPane.showMessageDialog(
                null, message, "Input result", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Objects.requireNonNull(this.getClass().getResource(url))));
    }

    protected abstract boolean VerifyData();

    protected abstract void additionalPanelAspect();

    protected abstract void createObject() throws ParseException, SQLException;

    protected abstract void insertToDDBB() throws SQLException, ParseException;
}
