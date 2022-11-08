package UML.Actividad3ProyectoJava;

import java.util.ArrayList;

public class Pedido {
    private java.time.LocalDate fecha;
    private Double precio;
    private Integer cantidad;
    private java.util.ArrayList<Producto> productos = new ArrayList<>();
    private Cliente cliente;

    public void despachar() {
    }

    public void cerrar() {
    }
}
