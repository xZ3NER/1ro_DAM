package UML.Actividad2ProyectoJava;

public class Circulo{
    private float radio;
    private Punto centro;

    public Circulo(float r, float x, float y) {
        this.radio = r;
        this.centro = new Punto(x,y);
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public float area() {
        return (float) Math.PI * radio * radio;
    }

    public void imprimir() {
        centro.imprimir();
        System.out.print("r=" + radio + " A=" + area());
    }

}
