package actividadHerencia.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {

    private Patterns() {}

    /**
     * Pattern for check DNI documents. (00000000T)
     * @param dni DNI String.
     * @return True/False.
     */
    public static boolean DniCheck(String dni) {
        String stringPattern = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";

        return PatternCompiler(stringPattern, dni) && CheckDniLetter(dni);
    }

    /**
     * Checks if the letter correctly fits in the document.
     * @param dni DNI String.
     * @return True/False.
     */
    private static boolean CheckDniLetter(String dni) {
        String characters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int dniNumbers=Integer.parseInt(dni.substring(0,8));

        char dniCharacter= characters.charAt(dniNumbers%23);

        return dniCharacter == dni.charAt(8);
    }

    /**
     *  Pattern for check NRP documents. (12345678T12A1234)
     * @param nrp NRP String.
     * @return True/False.
     */
    public static boolean NrpCheck(String nrp) {
        String stringPattern = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE][0-9]{2}[ASIY][0-9]{4}$";

        return PatternCompiler(stringPattern, nrp) && CheckDniLetter(nrp) && CheckNrpNumbers(nrp);
    }

    /**
     * Checks if the numbers correctly fits in the document.
     * @param nrp NRP String.
     * @return True/False.
     */
    private static boolean CheckNrpNumbers(String nrp) {
        int dniNumbers=Integer.parseInt(nrp.substring(0,8));

        int firstNumber = dniNumbers%7;
        int secondNumber = firstNumber+2;

        return firstNumber == Integer.parseInt(String.valueOf(nrp.charAt(9)))
                && secondNumber == Integer.parseInt(String.valueOf(nrp.charAt(10)));
    }

    /**
     * Pattern for check CIAL documents. (A00A00000A)
     * @param cial CIAL String.
     * @return True/False.
     */
    public static boolean CialCheck(String cial) {
        String abc = "ABCDEFGHIJKLNMOPQRSTUVWYXZ";

        String stringPattern = "^["+abc+"][0-9]{2}["+abc+"][0-9]{5}["+abc+"]$";

        return PatternCompiler(stringPattern,cial);
    }

    /**
     * Pattern for check the Course name Input. (DAM1)
     * @param course Course name String.
     * @return True/False.
     */
    public static boolean CourseCheck(String course) {
        if (course.length()>4) {
            return false;
        }

        if (!Character.isDigit(course.charAt(course.length() - 1))) {
            return false;
        }

        for (int i=0;i<course.length()-2;i++) {
            if (!Character.isLetter(course.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Pattern for check the Date format. (dd/MM/yyyy)
     * @param date Date String.
     * @return True/False.
     */
    public static boolean DateCheck(String date) {
        String stringPattern = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(\\d{4})$";

        return PatternCompiler(stringPattern,date);
    }

    /**
     * Compiles and checks if match the assigned pattern with the user input.
     * @param stringPattern Pattern to compile.
     * @param input User Input String.
     * @return True/False.
     */
    private static boolean PatternCompiler(String stringPattern, String input) {
        Pattern pattern = Pattern.compile(stringPattern,Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
