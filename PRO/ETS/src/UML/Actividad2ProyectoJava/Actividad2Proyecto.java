package UML.Actividad2ProyectoJava;

import java.util.Random;

public class Actividad2Proyecto {

    public static void main(String[] args) {
        Cono cono = new Cono(GetRandomNumber(),GetRandomNumber(),RandomColor(),GetRandomNumber(),GetRandomNumber());

        cono.imprimir();
    }

    private static float GetRandomNumber() {
        Random random = new Random();

        return random.nextFloat(0, 100);
    }

    private static String RandomColor() {
        String[] colores = {"Rojo","Azul","Verde","Amarillo","Rosa","Naranja"};
        Random random = new Random();

        return colores[random.nextInt(0,5)];
    }
}
