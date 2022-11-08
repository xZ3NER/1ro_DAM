package Farmacia;

import javax.swing.*;

public abstract class Productos implements PVP{

    private String referencia;
    private String nombre;
    private Double precio;
    private Integer stock;

    protected Productos(String referencia,String nombre,Double precio, Integer stock) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean Vender(int cantidad) {
        if (stock>0 && cantidad<=stock) {
            stock -= cantidad;

            JOptionPane.showMessageDialog(null,"Precio final: "+PrecioFinal(cantidad)+
                    "\nCupón: "+CuponDescuento(cantidad),"Total",JOptionPane.PLAIN_MESSAGE);

            return true;
        }else {
            return false;
        }
    }

    protected abstract String CuponDescuento(int cantidadComprada);
}
