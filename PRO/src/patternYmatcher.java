import javax.swing.*;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class patternYmatcher { //expresiones regulares

    static String letrasDNI="TRWAGMYFPDXBNJZSQVHLCKE";

    public static void main(String[] args) {
        String dni = JOptionPane.showInputDialog("Introduzca su DNI").toUpperCase(Locale.ROOT);
        String patternDNI= "[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$"; //definimos el patrón del DNI ->
        //-> valores entre el 0 y el 9, 8 veces, y al final '$' que sea una de esas letras
        //(podemos verificar la letra mediante otros metodos y probarlo ahí, es decir, numero del dni % 23,
        // y poner eso al final como 'letra'$)

        Pattern patron = Pattern.compile(patternDNI, Pattern.CASE_INSENSITIVE); //crea un objeto de la clase Pattern,
        // y almaneca en ella la compilación 'Pattern.compile()' de nuestro patrón del DNI, y el Pattern.CASE_INSENSITIVE,
        // que no diferencia entre mayusculas y minusculas

        Matcher matcher = patron.matcher(dni); //crea un objeto de clase Matcher, y almacena en ella el objeto patron de clase Pattern
        // pudiendo acceder a sus metodos, patron.matcher(), es decir, si el dni introducido por el usuario encaja (hace match) con el patron
        // que establecimos, el resultado lo almacena en matcher

        boolean esDNI=matcher.find(); //con matcher.find(), devuelve un true/false, dependiendo del resultado de la anterior operación

        if (esDNI) {
            if (letraDNI(dni))
            JOptionPane.showMessageDialog(null,"Es un DNI válido");
            else JOptionPane.showMessageDialog(null,"No es un DNI válido");
        }
        else JOptionPane.showMessageDialog(null,"No es un DNI válido");
    }

    private static boolean letraDNI(String dni) {
        int numerosDNI=Integer.parseInt(dni.substring(0,8));
        char letra= letrasDNI.charAt(numerosDNI%23);

        if (letra==dni.charAt(8)) return true;
        else return false;
    }
}
