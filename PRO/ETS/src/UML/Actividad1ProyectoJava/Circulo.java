package UML.Actividad1ProyectoJava;

/**
 * Clase Circulo que hereda de Punto (centro del circulo)
 */
public class Circulo extends Punto {

    /**
     * Radio del Circulo
     */
    protected float radio;

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
}
