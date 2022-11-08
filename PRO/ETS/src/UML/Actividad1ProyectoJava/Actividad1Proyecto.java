package UML.Actividad1ProyectoJava;

import java.util.Random;

/**
 * Clase Main
 */
public class Actividad1Proyecto {
    /**
     * Método main, crea un obtejo de tipo Cono, le asigna un valor a sus atributos y los imprime
     * @param args Parámetros por defecto del método
     */
    public static void main(String[] args) {
        Cono cono = new Cono();

        cono.setAltura(GetRandomNumber());
        cono.setRadio(GetRandomNumber());
        cono.setCentroX(GetRandomNumber());
        cono.setCentroY(GetRandomNumber());
        cono.setColor(RandomColor());

        cono.imprimir();
    }

    /**
     * Genera un número aleatorio (float) comprendido entre el 0 y 100
     * @return El número generado
     */
    private static float GetRandomNumber() {
        Random random = new Random();

        return random.nextFloat(0, 100);
    }

    /**
     * Genera un número aleatorio (int) comprendido entre el 0 y 5
     * @return Devuelve el color correspondiente al número
     */
    private static String RandomColor() {
        String[] colores = {"Rojo","Azul","Verde","Amarillo","Rosa","Naranja"};
        Random random = new Random();

        return colores[random.nextInt(0,5)];
    }
}
