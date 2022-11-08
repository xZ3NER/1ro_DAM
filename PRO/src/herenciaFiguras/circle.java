package herenciaFiguras;

public class circle extends figuras{

    private float radio;
    final private float pi = (float) 3.14159265359;

    public circle(float radio) {
        super("Círculo"); //super para iniciar el constructor de la clase padre
        this.radio=radio;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    @Override //texto que indica sobre la sobreescritura del método existente en la clase padre (polimorfismo)
    public float area() {
        return (float) (this.pi*Math.pow(this.radio,2));
    }

    @Override
    public float perimetro() {
        return 2*this.pi*this.radio;
    }
}
