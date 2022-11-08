package recursosPRO;

import javax.swing.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class metodoPatternNif {
    public static void main(String[] args) {
        String nif;

        do {
            try {

                nif = JOptionPane.showInputDialog(null, "Introduzca su NIF", "NIF verificator", JOptionPane.DEFAULT_OPTION).toUpperCase(Locale.ROOT).trim();

            }catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null,"Saliendo del programa...","Exit", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }while(!esNIF(nif));
    }

    private static boolean esNIF(String nif) {
        String patronNIF="[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";

        Pattern patron = Pattern.compile(patronNIF);
        Matcher match = patron.matcher(nif);

        boolean esNIF=match.find();
        if (esNIF) esNIF = validarNIF(nif);

        return esNIF;
    }

    private static boolean validarNIF(String nif) {
        String letras ="TRWAGMYFPDXBNJZSQVHLCKE";
        String numStr=nif.substring(0,8);

        int num = Integer.parseInt(numStr);
        num = num%23;

        if (letras.charAt(num)==nif.charAt(8)) return true;
        else return false;
    }
}
