package ProgramaComposicionCono;

//Commit Test

/**
 * Clase donde se encuentra el Main.
 */
public class ProgramaComposicionCono {

    /**
     * Imprime en consola los datos del objeto que pasemos por parámetro.
     * @param datos Datos de un objeto.
     */
    private static void imprimir (Object datos) {
        System.out.println(datos);
    }

    /**
     * Crea 5 objetos Cono, con un radio aleatorio comprendido y una altura incremental (i).
     * Al final, imprime el contenido del cono.
     * @param args Parámetro por defecto del método Main
     */
    public static void main (String[] args) {
        java.util.Random aleatorio = new java.util.Random();
        for (int i=1; i<=5; i++) {
            int radio = aleatorio.nextInt(9)+1;
            Cono cono = new Cono(0, 0, radio, i, "Azul");
            cono.imprimir();
        }
    }
}

