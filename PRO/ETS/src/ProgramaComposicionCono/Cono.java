package ProgramaComposicionCono;

/**
 * Clase Cono, con los atributos y métodos necesarios para la creación de esta.
 */
public class Cono {

    private Circulo base;
    private float altura;
    private String color;

    /**
     * Constructor de Cono, que define los valores de nuestros atributos.
     * @param cX Longitud del eje 'X' de la base del círculo.
     * @param cY Longitud del eje 'Y' de la base del círculo.
     * @param r  Radio de la base del círculo.
     * @param h  Altura del cono.
     * @param color Color del cono.
     */
    public Cono (float cX, float cY, float r, float h, String color) { // constructor
        this.base = new Circulo(cX, cY, r);
        this.altura = h;
        this.color = color;
    }

    /**
     * Getter del atributo base (objeto).
     * @return Devuelve la base del círculo.
     */
    public Circulo getBase() {
        return base;
    }

    /**
     * Setter del atributo base (objeto).
     * @param base La nueva base del círculo (new).
     */
    public void setBase(Circulo base) {
        this.base = base;
    }

    /**
     * Getter del atributo altura.
     * @return Devuelve el valor de dicho atributo.
     */
    public float getAltura() {
        return altura;
    }

    /**
     * Setter del atributo altura.
     * @param altura Nueva altura del cono.
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * Getter del atributo color.
     * @return Devuelve el valor de dicho atributo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter del atributo color.
     * @param color Nuevo color a asignar al cono.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Primero imprime la base circular del cono, luego imprime los atributos de nuestro cono.
     */
    public void imprimir () {
        base.imprimir();
        System.out.println(" h=" + altura + " c=" + color);
    }
}

