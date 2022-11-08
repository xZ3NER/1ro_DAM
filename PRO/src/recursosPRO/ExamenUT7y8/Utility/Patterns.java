package recursosPRO.ExamenUT7y8.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {

    private Patterns() {
    }

    public static boolean DniCheck(String dni) {
        String stringPattern = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";

        if (PatternCompiler(stringPattern, dni) && CheckDniLetter(dni)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean CheckDniLetter(String dni) {
        String characters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int dniNumbers = Integer.parseInt(dni.substring(0, 8));

        char dniCharacter = characters.charAt(dniNumbers % 23);

        if (dniCharacter == dni.charAt(8)) return true;
        else return false;
    }

    public static boolean DateCheck(String date) {
        String stringPattern = "^(\\d{4})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";

        return PatternCompiler(stringPattern, date);
    }

    public static boolean CheckIfNull(String data) {
        if (data == null) return true;
        if (data.equals("")) return true;

        return false;
    }

    public static boolean NegativeNumberCheck(String number) {
        double num;

        try {
            num = Double.parseDouble(number);

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

    public static boolean onlyDoubleCheck(String text) {
        try {
            Double.parseDouble(text);
        }catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean onlyStringCheck(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return false;
            }
        }

        return true;
    }

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
