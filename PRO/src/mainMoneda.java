import javax.swing.*;

public class mainMoneda {
    public static void main(String[] args) {
        Moneda dinero = new Moneda(); //crea el objeto dinero con la clase moneda

        boolean rep;
        do {
        rep=false;

        String[] selec={"Dólares a Euros", "Euros a Dólares","Nuevo cambio"};
        int opcion=JOptionPane.showOptionDialog(null,"¿Qué cambio desea hacer? -> Por defecto: "+dinero.getCambio(),"Seleccione",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,selec,selec[0]);
        //get cambio devuelve el valor del cambio actual
        try {
            if (opcion == 0) {
                double dolares = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca los dólares: "));
                dinero.dolaresAeuros(dolares); //inicia el método dolaresAeuros de la clase Moneda del objeto dinero (realiza la operación)
            }
            if (opcion == 1) {
                double euros = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca los euros: "));
                dinero.eurosAdolares(euros);
            }
            if (opcion == 2) {
                double newCambio = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca el nuevo valor del cambio: "));
                dinero = new Moneda(newCambio); //al ser constructor, new Moneda(nuevocambio), para iniciar el constructor de la clase Moneda del objeto dinero
                rep = true;
            }
        }catch (NumberFormatException e) { //catch de errores global
            rep=true;
            JOptionPane.showMessageDialog(null,"ERROR: SOLAMENTE SE ADMITEN NÚMEROS ENTEROS/DECIMALES");
        }

        }while(rep);

        JOptionPane.showMessageDialog(null,"El valor tras el cambio es de: "+dinero.getTrasCambio()); //getter devuelve el valor
    }
}
