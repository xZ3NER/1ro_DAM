package UML.Actividad2ProyectoJava;

public class Cono {
    private Circulo base; // composición
    private float altura;
    private String color;

    public Cono (float r, float h, String color,float x, float y) {
        this.base = new Circulo(r,x,y);
        this.altura = h;
        this.color = color;
    }
    public Circulo getBase() { return base; }

    public void setBase(Circulo base) { this.base = base; }

    public float getAltura() { return altura; }

    public void setAltura(float altura) { this.altura = altura; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public void imprimir () {
        base.imprimir();
        System.out.println(" h=" + altura + " c=" + color);
    }
}

