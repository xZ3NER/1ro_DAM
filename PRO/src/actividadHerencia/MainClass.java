package actividadHerencia;

//Commit 2

import actividadHerencia.Objects.People;
import actividadHerencia.Objects.Students;
import actividadHerencia.Objects.Teachers;
import actividadHerencia.UI.Frame;
import actividadHerencia.Utilities.DateFormat;
import actividadHerencia.Utilities.Patterns;
import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class MainClass {

    private static Frame frame;

    public static void main(String[] args) {
        frame = new Frame();
        SetOptionPaneStyle();
    }

    /**
     * Modify JOptionPane style (UIManager.put)
     */
    private static void SetOptionPaneStyle() {
        UIManager.put("OptionPane.minimumSize",new Dimension(300,200));
        UIManager.put("Button.background", new Color(185, 185, 185));
        UIManager.put("OptionPane.okButtonText", "Next");
        UIManager.put("OptionPane.cancelButtonText", "Exit");
        UIManager.put("OptionPane.messageFont",new Font("Candara",Font.BOLD,20));
        UIManager.put("TextField.font", new Font("Candara Light",Font.PLAIN,20));
        UIManager.put("Button.font",new Font("Candara Light",Font.BOLD,20));
    }

    /**
     * Creates a new Teachers object and returns it.
     * @return Teachers object.
     */
    public static People CreateTeacher() {
        String name = ReadInput("Name");
        String dni = ReadInput("DNI");
        DateFormat birthday = new DateFormat(ReadInput("Birthday"));
        String nrp = ReadInput("NRP");
        int speciality = Integer.parseInt(ReadInput("Speciality"));
        String center = ReadInput("Center");

        return new Teachers(name,dni,birthday,nrp,speciality,center);
    }

    /**
     * Creates a new Students object and returns it.
     * @return Students object.
     */
    public static People CreateStudent() {
        String name = ReadInput("Name");
        String dni = ReadInput("DNI");
        DateFormat birthday = new DateFormat(ReadInput("Birthday"));
        String cial = ReadInput("CIAL");
        String course = ReadInput("Course");

        return new Students(name,dni,birthday,cial,course);
    }

    /**
     * Reads the input from the user and validates it.
     * @param displayText Texto to display in the input message.
     * @return User input.
     */
    private static String ReadInput(String displayText) {

        String userInput;
        boolean repeat;

        do {
            userInput = JOptionPane.showInputDialog(
              null, "Enter the " + displayText + ":", "Data Input", JOptionPane.PLAIN_MESSAGE
            );

            repeat = !VerifyInput(displayText, userInput);
            if (repeat) {
                JOptionPane.showMessageDialog(
                        null,"¡WRONG INPUT PATTERN!","Warning",JOptionPane.WARNING_MESSAGE
                );
            }
        }while (repeat);

        return userInput;
    }

    /**
     * Verify and checks the correct pattern of each user input.
     * @param displayText A guide to know what type of pattern we will apply to.
     * @param userInput User input string.
     * @return True or false, depends on the pattern applied.
     */
    private static boolean VerifyInput(String displayText, String userInput) {
        if (userInput==null || userInput.length()<1) return false;

        switch (displayText) {
            case "DNI":
                return Patterns.DniCheck(userInput);

            case "Birthday":
                return Patterns.DateCheck(userInput);

            case "NRP":
                return Patterns.NrpCheck(userInput);

            case "CIAL":
                return Patterns.CialCheck(userInput);

            case "Course":
                return Patterns.CourseCheck(userInput);

            case "Speciality":
                for (int i = 0; i < userInput.length(); i++) {
                        if (Character.isLetter(userInput.charAt(i))) {
                            return false;
                        }
                    }
                return true;

            default: return true;
        }
    }

    /**
     * Shows the Teachers object data.
     * @param teacher Teachers/People object.
     */
    public static void ShowTeacher(People teacher) {
        String message =
                "Name: "+teacher.getName()+"\n" +
                "DNI: "+teacher.getDni()+"\n" +
                "Age: "+teacher.Age()+"\n" +
                "NRP: "+((Teachers) teacher).getNrp()+"\n" +
                "Speciality: "+((Teachers) teacher).getSpeciality()+"\n" +
                "Center: "+((Teachers) teacher).getDestinationCenter();

        ShowMessage(message,"Teacher");
    }

    /**
     * Shows the Students object data.
     * @param student Students/People object.
     */
    public static void ShowStudent(People student) {
        String message =
                "Name: "+student.getName()+"\n" +
                "DNI: "+student.getDni()+"\n" +
                "Age: "+student.Age()+"\n" +
                "CIAL: "+((Students) student).getCial().toUpperCase(Locale.ROOT)+"\n" +
                "Course: "+((Students) student).getCourse().toUpperCase(Locale.ROOT);

        ShowMessage(message,"Student");
    }

    /**
     * Shows a message in JOptionPane and chooses an option for continue or close.
     * @param message The message to display.
     * @param type The type of object, for display too.
     */
    private static void ShowMessage(String message,String type) {
        String[] options = {"Continue","Exit"};

        int choose = JOptionPane.showOptionDialog(
                null,message,type+" Object Information",
                JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]
        );

        if (choose==1 || choose ==-1) {
            frame.dispose();
        }
    }
}
