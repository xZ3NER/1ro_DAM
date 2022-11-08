package SourceCode.model.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {

    private Patterns() {
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
