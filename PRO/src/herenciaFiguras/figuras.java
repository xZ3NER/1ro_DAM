package herenciaFiguras;

public abstract class figuras { //abstracto para que no se pueda crear objetos de la clase

    private String color; //private = solo accesible en esta clase
    private String name;

    protected figuras(String name) { //protected = solo accesible en este paquete y sus subclases
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected abstract float area(); //si es abstracto el método, obliga a las clases que hereda de este tener este metodo

    protected abstract float perimetro();
}
