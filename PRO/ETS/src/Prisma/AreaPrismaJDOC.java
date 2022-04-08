package Prisma;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
//JDOC PROBLEMS FIX: Clear the Locale field. In the Other command line arguments field, add -encoding utf8 -docencoding utf8 -charset utf8

/**
 * Clase principal
 */
public class AreaPrismaJDOC {
    /**
     * Método main, cuya función es crear el vector de clase Prisma y llamar a distintos métodos.
     * @param args Por defecto del método main.
     */
    public static void main(String[] args) {
        Prisma[] prismas= new Prisma[3];

        setPrismaObjects(prismas);

        imprimirValor(getMensajeOrdenado(ordenaPrismas(prismas),prismas));
    }

    /**
     * Crea objetos de clase Prisma con datos aleatorios y los almacena en el mismo vector,
     * al final, imprime los datos introducidos.
     * @param prismas vector de clase Prisma, donde tenemos almacenado nuestras prismas.
     */
    private static void setPrismaObjects(Prisma[] prismas) {
        for(int i = 0; i< prismas.length; i++) {
            int base = (int) getRandom();
            int altura = (int) getRandom();

            prismas[i] = new Prisma(base, altura);
            imprimirValor(getMensajeArea(prismas[i],i));
        }
    }

    /**
     * Ordena el vector que almacena el área total de los objetos prismas.
     * @param prismas vector de clase Prisma, donde tenemos almacenado nuestras prismas.
     * @return Devuelve el vector de áreas totales ordenado de mayor a menor.
     */
    private static Float[] ordenaPrismas(Prisma[] prismas) {

        Float[] areaPrisma = new Float[prismas.length];
        areaPrisma = copyArrayValues(prismas, areaPrisma);

        //ordena el array areaPrisma (por defecto de menor a mayor), y con reverseOrder() de la clase Collections
        //podemos hacer que la ordenación sea de mayor a menor
        Arrays.sort(areaPrisma, Collections.reverseOrder());

        return areaPrisma;
    }

    /**
     * Copia el área total de cada objeto Prisma y lo almacena en el vector areaPrisma
     * @param prismas vector de clase Prisma, donde tenemos almacenado nuestras prismas.
     * @param areaPrisma vector donde almacenamos únicamente las áreas de cada objeto Prisma.
     * @return Devuelve el vector con las áreas copiadas correctamente
     */
    private static Float[] copyArrayValues(Prisma[] prismas, Float[] areaPrisma) {
        for (int i = 0; i< areaPrisma.length; i++) {
            areaPrisma[i] = prismas[i].getAreaTotal();
        }

        return areaPrisma;
    }

    /**
     * Genera un mensaje con los datos de un objeto Prisma
     * @param prismas vector de clase Prisma, donde tenemos almacenado nuestras prismas.
     * @param pos posición del objeto en el vector.
     * @return Devuelve el mensaje generado.
     */
    private static String getMensajeArea(Prisma prismas, int pos) {
        pos +=1;
        String mensaje = "Creado el objeto Prisma "+pos+" con: \n\n" +
                "Base: "+ prismas.getBaseTriangulo()+"\n" +
                "Altura: "+ prismas.getAlturaPrisma()+"\n" +
                "Area Total: "+ prismas.areaTotal();

        return mensaje;
    }

    /**
     * Genera un mensaje con el área total de cada Prisma ordenado, además, contiene su posición.
     * @param areasOrdenados Vector con las áreas ya ordenadas previamente.
     * @param prismas vector de clase Prisma, donde tenemos almacenado nuestras prismas.
     * @return Devuelve el mensaje generado.
     */
    private static String getMensajeOrdenado(Float[] areasOrdenados,Prisma[] prismas) {
        String mensaje="Ordenado de mayor a menor: \n\n";

        for (int i=0;i<areasOrdenados.length;i++) {
            for (int j=0;j<prismas.length;j++) {
                if (areasOrdenados[i]==prismas[j].getAreaTotal()) {
                    mensaje += "Prisma " + (j+1) + ": area total " + areasOrdenados[i] + "\n";
                }
            }
        }

        return mensaje;
    }

    /**
     * Genera un número aleatorio comprendido entre el 1 y el 100
     * @return Devuelve el número generado
     */
    private static double getRandom() {
        return Math.random() * 100+1;
    }

    /**
     * Imprime en un panel el texto que le pasemos.
     * @param texto El texto que queremos que imprima.
     */
    private static void imprimirValor(String texto) {
        JOptionPane.showMessageDialog(null, texto,"Prisma",JOptionPane.DEFAULT_OPTION);
    }
}
