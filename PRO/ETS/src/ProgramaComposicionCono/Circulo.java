package ProgramaComposicionCono;

/**
 * Clase Circulo con los atributos y métodos necesarios para la base circular de un Cono.
 */
public class Circulo {

    private float x, y;
    private float radio;

    /**
     * Constructor de Circulo, que define los valores de nuestros atributos.
     * @param cX Longitud del eje 'X'.
     * @param cY Longitud del eje 'Y'.
     * @param r Radio.
     */
    public Circulo (float cX, float cY, float r) { // constructor
        this.x = cX;
        this.y = cY;
        this.radio = r;
    }

    /**
     *Getter del valor del eje X.
     * @return Devuelve dicho valor.
     */
    public float getX() {
        return x;
    }

    /**
     * Setter del valor del eje X.
     * @param x Nuevo valor de dicho eje.
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     *Getter del valor del eje Y.
     * @return Devuelve dicho valor.
     */
    public float getY() {
        return y;
    }

    /**
     * Setter del valor del eje Y.
     * @param y Nuevo valor de dicho eje.
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     *Getter del valor del radio.
     * @return Devuelve dicho valor.
     */
    public float getRadio() {
        return radio;
    }

    /**
     * Setter del valor del radio.
     * @param radio Nuevo valor de dicho eje.
     */
    public void setRadio(float radio) {
        this.radio = radio;
    }

    /**
     * Calcula el área del Círculo.
     * @return Devuelve el valor de dicha área.
     */
    public float area() {
        return (float)Math.PI*radio*radio;
    }

    /**
     * Imprime cada uno de los atributos de la clase.
     */
    public void imprimir () {
        System.out.print(" x=" + x);
        System.out.print(" y=" + y);
        System.out.print(" r=" + radio);
        System.out.print(" A=" + area());
    }
}