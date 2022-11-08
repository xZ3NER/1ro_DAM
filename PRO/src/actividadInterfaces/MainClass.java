package actividadInterfaces;

import actividadInterfaces.Objects.People;
import actividadInterfaces.Objects.Students;
import actividadInterfaces.Objects.Teachers;
import actividadInterfaces.Objects.Tutors;
import actividadInterfaces.UI.Frame;
import actividadInterfaces.Utilities.DateFormat;
import actividadInterfaces.Utilities.Patterns;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;

public class MainClass {

    //Finalmente, se solicita un DNI, dependiendo de la subclase se muestra su dato
    //identificador (NRP o CIAL), y en caso de ser profesor además informa del salario completo

    private static Frame frame;
    private static ArrayList<Teachers> teachersArrayList = new ArrayList<>();
    private static ArrayList<Students> studentsArrayList = new ArrayList<>();

    public static ArrayList<Teachers> getTeachersArrayList() {
        return teachersArrayList;
    }

    public static ArrayList<Students> getStudentsArrayList() {
        return studentsArrayList;
    }

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
        UIManager.put("OptionPane.okButtonText", "Continue");
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
        double salary = Double.parseDouble(ReadInput("Salary"));

        if (ReadType().equals("Default")) {
            Teachers teacher = new Teachers(name,dni,birthday,nrp,speciality,center,salary);

            teachersArrayList.add(teacher);
            return teacher;
        } else {
            String group = ReadInput("Group");

            Tutors tutor = new Tutors(name,dni,birthday,nrp,speciality,center,salary,group);

            teachersArrayList.add(tutor);
            return tutor;
        }
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

        Students student = new Students(name,dni,birthday,cial,course);

        studentsArrayList.add(student);
        return student;
    }

    private static String ReadType() {
        String[] options = {"Default","Tutor"};

        int type = JOptionPane.showOptionDialog(null,"Choose one option","Select",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);

        if (type == 0) {
            return options[0];
        }else {
            return options[1];
        }
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
                        null,"¡WRONG INPUT PATTERN OR DATA ALREADY EXISTS!","Warning",JOptionPane.WARNING_MESSAGE
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
            case "DNI": {
                return Patterns.DniCheck(userInput);
            }

            case "Birthday": {
                return Patterns.DateCheck(userInput);
            }

            case "NRP": {
                return Patterns.NrpCheck(userInput);
            }

            case "CIAL": {
                return Patterns.CialCheck(userInput);
            }

            case "Course":

            case "Group": {
                return Patterns.CourseCheck(userInput);
            }

            case "Speciality": {
                for (int i = 0; i < userInput.length(); i++) {
                    if (Character.isLetter(userInput.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }

            case "Salary": {
                return Patterns.SalaryCheck(userInput);
            }

            default: return true;
        }
    }

    /**
     * Shows the Teachers object data.
     * @param teacher Teachers/People object.
     */
    public static void ShowTeacher(People teacher) {
        String message =
                GetPeopleInfo(teacher)+
                        "NRP: "+teacher.IdentityAccess()+"\n" +
                        "Speciality: "+((Teachers) teacher).getSpeciality()+"\n" +
                        "Center: "+((Teachers) teacher).getDestinationCenter()+"\n" +
                        "Salary: "+((Teachers) teacher).getSalary()+"€";

        ShowMessage(message,"Teacher");
    }

    public static void ShowTutor(People tutor) {
        String message =
                GetPeopleInfo(tutor)+
                        "NRP: "+tutor.IdentityAccess()+"\n" +
                        "Speciality: "+((Tutors) tutor).getSpeciality()+"\n" +
                        "Center: "+((Tutors) tutor).getDestinationCenter()+"\n" +
                        "Group: "+((Tutors) tutor).getGroup()+"\n"+
                        "Salary: "+((Tutors) tutor).getSalary()+"€";

        ShowMessage(message,"Teacher");
    }

    /**
     * Shows the Students object data.
     * @param student Students/People object.
     */
    public static void ShowStudent(People student) {
        String message =
                GetPeopleInfo(student)+
                        "CIAL: "+student.IdentityAccess().toUpperCase(Locale.ROOT)+"\n" +
                        "Course: "+((Students) student).getCourse().toUpperCase(Locale.ROOT);

        ShowMessage(message,"Student");
    }

    private static String GetPeopleInfo(People people) {
        return "Name: "+people.getName()+"\n" +
                "DNI: "+people.getDni()+"\n" +
                "Age: "+people.Age()+"\n";
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
