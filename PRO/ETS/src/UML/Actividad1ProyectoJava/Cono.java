package UML.Actividad1ProyectoJava;

/**
 * Clase Cono que hereda de Circulo (base)
 */
public class Cono extends Circulo {
    /**
     * Altura del Cono
     */
    private float altura;
    /**
     * Color del Cono
     */
    private String color;

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Imprime el valor de todos los atributos de Cono, incluido los de sus hijos
     */
    public void imprimir() {
        System.out.println(
                "Altura: "+altura+"\n" +
                        "Color: "+color +"\n" +
                        "Radio: "+radio+"\n" +
                        "Centro X: "+centroX+"\n" +
                        "Centro Y: "+centroY
        );
    }
}
