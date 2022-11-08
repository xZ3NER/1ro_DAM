public class Clientes {

    String nombre,nif,telefono;

    public Clientes(String nombre, String telefono, String nif) {
        this.nombre=nombre;
        this.telefono=telefono;
        this.nif= nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public String getTelefono() {
        return telefono;
    }
}
