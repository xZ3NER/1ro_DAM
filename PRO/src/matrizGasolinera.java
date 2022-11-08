import javax.swing.*;
import java.text.DecimalFormat;

public class matrizGasolinera {

    final static DecimalFormat decimal=new DecimalFormat("#0.000");
    final static String[] campos1={"Gasolinera","Ubicación"};
    final static String[] campos2={"Gasóleo A", "Gasolina 95", "Gasolina 98"};
    final static String[][] gasolineras = {
            {"Petroprix","Agüimes","0.969€","1.019€","Sin existencias"},
            {"Canary Oil","Agüimes","0.975€","1.025€","1.150€"},
            {"H2EXAGON","Las Palmas","0.989€","1.049€","Sin existencias"},
    };

    public static void main(String[] args) {

        getPreview();

        int seleccion = JOptionPane.showOptionDialog(
                null,"Selecciona su tipo de gasolina","Gasolinas", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,campos2,campos2[0]);

        int columna=returnType(seleccion);
        double precioMenor=999999;

        for(int i=0;i<gasolineras.length;i++) {
            String precio=gasolineras[i][columna];

                if (precio.endsWith("€")) {
                    String precio2=precio.substring(0,precio.indexOf('€'));
                    double precioAux = Double.parseDouble(precio2);
                    if(precioAux<precioMenor) precioMenor=precioAux;

            }
        }

        JOptionPane.showMessageDialog(null,"El más barato tendría un precio de: "+decimal.format(precioMenor)+" €");

    }

    private static int returnType(int seleccion) {
        switch (seleccion) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 4;
            default: return 5;
        }
    }

    private static void getPreview() {
        for (String dato1:campos1) {
            System.out.print(dato1+"     ");
        }

        for (String dato2:campos2) {
            System.out.print(dato2+"     ");
        }

        System.out.println();

        for (int i=0;i<gasolineras.length;i++) {
            for (String datoColumna:gasolineras[i]) {
                System.out.print(datoColumna+"     ");

            }
            System.out.println();
        }
        ;
    }
}
