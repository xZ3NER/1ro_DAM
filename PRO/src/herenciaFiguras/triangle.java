package herenciaFiguras;

public class triangle extends figuras{

    private float base;
    private float altura;

    public triangle(float base, float altura) {
        super("Triángulo");
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public float area() {
        return this.base*this.altura/2;
    }

    @Override
    public float perimetro() {
        return 3*this.base;
    }
}
