public class jugadores { //apartado 4
    String nombre,equipo,nacionalidad;
    double ficha;

    public jugadores(String nombre, String equipo, String nacionalidad, double ficha) {
        this.nombre=nombre;
        this.equipo=equipo;
        this.nacionalidad=nacionalidad;
        this.ficha=ficha;
    }

    public double calcular_transfe(int transfe) {
        return this.ficha*transfe/100+this.ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public double getFicha() {
        return ficha;
    }
}
