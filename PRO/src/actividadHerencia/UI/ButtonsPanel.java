package actividadHerencia.UI;

import actividadHerencia.MainClass;
import actividadHerencia.Objects.People;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonsPanel extends JPanel {

    protected static ArrayList<JButton> buttonsList = new ArrayList<>();

    /**
     * Buttons panel configurations. (Constructor)
     */
    public ButtonsPanel() {
        setLayout(new GridLayout(1,2,50,0));
        setPreferredSize(new Dimension(600,200));
        setBorder(BorderFactory.createEmptyBorder(50,50,70,50));

        CreateButtons();
        SetButtons();
    }

    /**
     * Create and add to an array list our buttons.
     */
    private void CreateButtons() {
        buttonsList.add(new JButton("Teacher"));
        buttonsList.add(new JButton("Student"));
    }

    /**
     * Set the style and actions of our buttons from the array list, and add them to our panel.
     */
    private void SetButtons() {
        for (JButton button: buttonsList) {
            button.setFocusPainted(false);
            button.setFont(new Font("Candara", Font.BOLD, 25));
            button.setBackground(new Color(185, 185, 185));
            button.setBorder(BorderFactory.createLineBorder(Color.darkGray));
            AddListeners(button);
            add(button);
        }
    }

    /**
     * Add certain actions to our buttons depends on the type.
     * @param button Button to apply the listener.
     */
    private void AddListeners(JButton button) {

        if (button.getText().equals("Teacher")) {
            button.addActionListener(e -> {
                People teacher= MainClass.CreateTeacher();
                MainClass.ShowTeacher(teacher);
            });
        }

        if (button.getText().equals("Student")) {
            button.addActionListener(e -> {
                People student = MainClass.CreateStudent();
                MainClass.ShowStudent(student);
            });
        }
    }
}
