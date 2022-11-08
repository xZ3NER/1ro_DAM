package Decompiler;

import java.util.Random;
import java.util.Scanner;

public class JuegoAveriguarNumeroSecreto
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final int n = new Random().nextInt(30) + 1;
        int i = 0;
        do {
            System.out.print("Averigue el numero secreto entre 1 y 30: ");
            final int nextInt = scanner.nextInt();
            ++i;
            if (nextInt < n) {
                System.out.println("El numero secreto es mayor");
            }
            if (nextInt > n) {
                System.out.println("El numero secreto es menor");
            }
            if (nextInt == n) {
                System.out.println("Enhorabuena, has acertado");
                System.exit(0);
            }
        } while (i < 4);
        System.out.println("Fin del juego. Has agotado los cuatro intentos.");
    }
}
