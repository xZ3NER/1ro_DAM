package actividadInterfaces.UI;

import actividadInterfaces.MainClass;
import actividadInterfaces.Objects.People;
import actividadInterfaces.Objects.Students;
import actividadInterfaces.Objects.Teachers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

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
        buttonsList.add(new JButton("Search"));
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
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    People teacher= MainClass.CreateTeacher();

                    if (teacher.getClass().getName().equals("actividadInterfaces.Objects.Tutors")) {
                        MainClass.ShowTutor(teacher);
                    } else{
                        MainClass.ShowTeacher(teacher);
                    }
                }
            });
        }

        if (button.getText().equals("Student")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    People student = MainClass.CreateStudent();
                    MainClass.ShowStudent(student);
                }
            });
        }

        if (button.getText().equals("Search")) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SearchOptionsSelector();
                }
            });
        }
    }

    private void SearchOptionsSelector() {
        String[] options = {buttonsList.get(0).getText(),buttonsList.get(1).getText()};
        int selected;


        selected = JOptionPane.showOptionDialog(null, "Select which one you want to search", "Search", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if(CheckNullData(selected)) {
            JOptionPane.showMessageDialog(null, "No data available", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (selected == 0) {
            TeacherSearchPane(MainClass.getTeachersArrayList());
        }
        if (selected == 1) {
            StudentsSearchPane(MainClass.getStudentsArrayList());
        }
    }

    private boolean CheckNullData(int selected) {
        if (selected == 0) {
            if (MainClass.getTeachersArrayList().size()!=0) return false;
        }

        if (selected==1) {
            if (MainClass.getStudentsArrayList().size()!=0) return false;
        }

        return true;
    }

    private void TeacherSearchPane(ArrayList<Teachers> teachersList) {
        Vector<String> options = new Vector<>();
        options.add("--Select--");

        for (int i=0;i<teachersList.size();i++) {
            options.add(teachersList.get(i).getDni());
        }

        String selected = (String) JOptionPane.showInputDialog(null,"Choose a DNI","Search",JOptionPane.DEFAULT_OPTION,null,options.toArray(), options.get(0));

        if (selected == null) {
            return;
        }
        if (selected.equals("--Select--")) {
            return;
        }

        ShowTeacherObjectInfo(teachersList, selected);
    }

    private void StudentsSearchPane(ArrayList<Students> studentsList) {
        Vector<String> options = new Vector<>();
        options.add("--Select--");

        for (int i=0;i<studentsList.size();i++) {
            options.add(studentsList.get(i).getDni());
        }

        String selected = (String) JOptionPane.showInputDialog(null,"Choose a DNI","Search",JOptionPane.DEFAULT_OPTION,null,options.toArray(), options.get(0));

        if (selected == null) {
            return;
        }
        if (selected.equals("--Select--")) {
            return;
        }

        ShowStudentObjectInfo(studentsList, selected);
    }

    private void ShowStudentObjectInfo(ArrayList<Students> students, String selected) {
        for (int i=0;i< students.size();i++) {
            if (students.get(i).getDni().equals(selected)) {
                MainClass.ShowStudent(students.get(i));
            }
        }
    }

    private void ShowTeacherObjectInfo(ArrayList<Teachers> teachers, String selected) {
        for (int i=0;i< teachers.size();i++) {
            if (teachers.get(i).getDni().equals(selected)) {
                MainClass.ShowTeacher(teachers.get(i));
            }
        }
    }
}
