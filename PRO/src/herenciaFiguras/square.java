package herenciaFiguras;

public class square extends figuras{

    private float base;

    public square(float base) {
        super("Cuadrado");
        this.base = base;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    @Override
    public float area() {
        return (float) Math.pow(this.base,2);
    }

    @Override
    public float perimetro() {
        return this.base+this.base+this.base+this.base;
    }
}
