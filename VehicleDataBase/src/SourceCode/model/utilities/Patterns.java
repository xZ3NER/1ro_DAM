package SourceCode.model.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {

    private Patterns() {
    }

    /**
     * Pattern for check DNI documents. (00000000T)
     *
     * @param dni DNI String.
     * @return True/False.
     */
    public static boolean DniCheck(String dni) {
        String stringPattern = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";

        if (PatternCompiler(stringPattern, dni) && CheckDniLetter(dni)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the letter correctly fits in the document.
     *
     * @param dni DNI String.
     * @return True/False.
     */
    private static boolean CheckDniLetter(String dni) {
        String characters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int dniNumbers = Integer.parseInt(dni.substring(0, 8));

        char dniCharacter = characters.charAt(dniNumbers % 23);

        if (dniCharacter == dni.charAt(8)) return true;
        else return false;
    }

    public static boolean CheckIfNull(String data) {
        if (data == null) return true;
        if (data.equals("")) return true;

        return false;
    }

    /**
     * Pattern for check the Date format. (dd/MM/yyyy)
     *
     * @param date Date String.
     * @return True/False.
     */
    public static boolean DateCheck(String date) {
        String stringPattern = "^(\\d{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

        return PatternCompiler(stringPattern, date);
    }

    public static boolean LicensePlateCheck(String licensePlate) {
        String stringPattern = "^([0-9]{4}) ([A-Z]{3})";

        return PatternCompiler(stringPattern, licensePlate);
    }

    public static boolean ChassisNumberCheck(String chassisNumber) {
        return chassisNumber.length() == 17;
    }

    public static boolean NegativeNumberCheck(String number) {
        int num;

        try {
            num = Integer.parseInt(number);

            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean onlyDigitCheck(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Compiles and checks if match the assigned pattern with the user input.
     *
     * @param stringPattern Pattern to compile.
     * @param input         User Input String.
     * @return True/False.
     */
    private static boolean PatternCompiler(String stringPattern, String input) {
        Pattern pattern = Pattern.compile(stringPattern, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
