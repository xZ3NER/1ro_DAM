import javax.swing.*;
import java.text.DecimalFormat;

public class actividad3Matrices {

    static DecimalFormat decimal = new DecimalFormat("#0.00");

    public static int input(String tipo) { //metodo de input para asignar dimensiones del array, y controlar errores
        boolean rep=true;
        int valor=1;

        do{
            try{
                valor=Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad de "+tipo+": "));
                rep=false;
                if(valor<1) JOptionPane.showMessageDialog(null,"Dato introducido inválido, pruebe de nuevo.","Error",1);
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Dato introducido inválido, pruebe de nuevo.","Error",1);
            }
        }
        while(rep||valor<1);

        return valor;
    }

    public static void main(String[] args) {

        int modulos = input("módulos");
        int alumnos = input("alumnos");

        String[][] calificaciones = createArray(alumnos,modulos);
        calificaciones=setArray(calificaciones);
        calificaciones=setNotas(calificaciones);

        showArray(calificaciones);
        showMedia(calificaciones);
    }

    public static void showArray(String[][] calificaciones) {
        String showArray="";

        for(int i = 0; i< calificaciones.length; i++){
            for(int j = 0; j< calificaciones[0].length; j++){
                showArray += calificaciones[i][j];
                if (i==0) showArray+="           ";
                else showArray+="             ";
            }
            showArray+="\n";
        }

        JOptionPane.showMessageDialog(null,showArray);
    }

    public static String[][] createArray(int filas, int columnas) {  //crear array
        columnas++; filas++;

        String[][] array = new String[filas][columnas];
        array[0][0] ="Nombre";

        return  array;
    }

    public static String[][] setArray(String[][] array) { //asignar nombre de módulos y de alumnos al array

        for(int i=1;i<array[0].length;i++) {
            array[0][i]=leerArray("módulo",i).toUpperCase().trim();
        }

        for(int i=1;i<array.length;i++) {
            array[i][0]=leerArray("alumno",i).toUpperCase().trim();
        }

        return array;
    }

    public static String leerArray(String tipo,int i) { // método de lectura de los nombres con control de la correcta introducción de datos
        int rep=1;
        String valor;

        do{
            valor = JOptionPane.showInputDialog("Introduzca el nombre del "+tipo+" "+i+": ");
            rep= JOptionPane.showConfirmDialog(null,"¿Está seguro que el nombre es: "+valor+"?");
        }while(rep==1);

        return valor;
    }

    public static String[][] setNotas(String[][] array) { //asignación de las notas

        for(int i=1;i<array.length;i++){
            for(int j=1;j<array[1].length;j++) {
                boolean rep=true;
                double nota=1;

                do{
                    try{
                        nota = Double.parseDouble(JOptionPane.showInputDialog("Nota de "+array[i][0]+" en "+array[0][j]));
                        rep=false;
                        if(nota<1||nota>10) JOptionPane.showMessageDialog(null,"Nota introducida inválida, pruebe de nuevo.","Error",1);
                    }catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,"Nota introducida inválida, pruebe de nuevo.","Error",1);
                    }
                } while(rep||nota<1||nota>10);

                array[i][j]=String.valueOf(nota);
            }
        }
        return array;
    }

    public static void showMedia(String[][] calificaciones) {
        boolean rep=true;
        String[] sino={"Si","No","Ver notas"};
        String[] modulos=new String[calificaciones[0].length-1];
        for(int i=0;i<modulos.length;i++) {
            modulos[i]=calificaciones[0][i+1];
        }

        while(rep){
            int eleccion=JOptionPane.showOptionDialog(null,"¿Desea ver la media de alguna asignatura?","Media",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,sino,sino[0]);
            if(eleccion==1) {
                rep=false;
                continue;
            }

            if(eleccion==2) {
                showArray(calificaciones);
                continue;
            }

            int numModulo= JOptionPane.showOptionDialog(null,"Seleccione: ","Media",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,modulos,modulos[0]);

            double valor=0;
            valor = getMedia(calificaciones, valor, numModulo);

            JOptionPane.showMessageDialog(null,"La media de "+modulos[numModulo]+" es de "+decimal.format(valor));
        }
    }

    public static double getMedia(String[][] calificaciones, double valor, int numModulo) {
        for(int i = 1; i< calificaciones.length; i++) {
            valor +=Double.parseDouble(calificaciones[i][numModulo +1]);
        }

        valor=valor/(calificaciones.length-1);
        return valor;
    }
}
