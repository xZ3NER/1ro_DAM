import javax.swing.*;
import java.util.ArrayList;

public class mainJugadores {

    static String datosJugadores= //apartado 1
            "Messi,FC Barcelona,Argentina,55000.0$" +
            "Modric,Real Madrid,Croacia,52000.5$" +
            "Iniesta,FC Barcelona,España,275000.0$" +
            "Stoichkov,FC Barcelona,Bulgaria,752003.25$" +
            "Ferrari,Sassuolo,Italia,99999.9";
    static String[] arrayJugadores=datosJugadores.split("\\$"); //apartado 2
    static ArrayList<jugadores> listaJugadores = new ArrayList<>();

    public static void main(String[] args) {

        for (String dato:arrayJugadores) { //apartado 3
            JOptionPane.showMessageDialog(null,dato,"Datos de la matriz",JOptionPane.DEFAULT_OPTION);
        }

        for (int i=0;i<arrayJugadores.length;i++) {  //apartado 5
            String[] subArrayJugadores = arrayJugadores[i].split(",");

            listaJugadores.add(new jugadores(subArrayJugadores[0],subArrayJugadores[1],subArrayJugadores[2],Double.parseDouble(subArrayJugadores[3])));
        }

        for (int i=0;i<listaJugadores.size();i++) { //apartado 6
            String mensaje = "Nombre: "+listaJugadores.get(i).getNombre()+"\n" +
                                "Equipo: "+listaJugadores.get(i).getEquipo()+"\n" +
                                "Nacionalidad: "+listaJugadores.get(i).getNacionalidad()+"\n" +
                                "Ficha: "+listaJugadores.get(i).getFicha()+" $";

            JOptionPane.showMessageDialog(null,mensaje,"Jugador "+(i+1)+" de la lista",JOptionPane.DEFAULT_OPTION);
        }

        for (int i=0;i<listaJugadores.size();i++) { //a oartadi 7

            if (listaJugadores.get(i).getEquipo().equals("FC Barcelona")) {
                String mensaje = "Nombre: " + listaJugadores.get(i).getNombre() + "\n" +
                        "Equipo: " + listaJugadores.get(i).getEquipo() + "\n" +
                        "Nacionalidad: " + listaJugadores.get(i).getNacionalidad() + "\n" +
                        "Ficha: " + listaJugadores.get(i).getFicha() + " $\n\n" +
                        "Coste total de traspaso: "+listaJugadores.get(i).calcular_transfe(20)+" $";

                JOptionPane.showMessageDialog(null, mensaje, "Jugador del FC Barcelona "+listaJugadores.get(i).getNombre(), JOptionPane.DEFAULT_OPTION);
            }
        }

        for (int i=0;i<listaJugadores.size();i++) { //apartado 8
            if (listaJugadores.get(i).getNacionalidad().equals("Italia")) {
                listaJugadores.remove(i);
            }
        }
        for (int i=0;i<listaJugadores.size();i++) {
            String mensaje = "Nombre: "+listaJugadores.get(i).getNombre()+"\n" +
                    "Equipo: "+listaJugadores.get(i).getEquipo()+"\n" +
                    "Nacionalidad: "+listaJugadores.get(i).getNacionalidad()+"\n" +
                    "Ficha: "+listaJugadores.get(i).getFicha()+" $";

            JOptionPane.showMessageDialog(null,mensaje,"Lista sin el jugador de Nacionalidad Italiana",JOptionPane.DEFAULT_OPTION);
        }
    }
}
