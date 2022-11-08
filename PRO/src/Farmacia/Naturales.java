package Farmacia;

public class Naturales extends Productos{

    private String distribuidor;

    protected Naturales(String referencia, String nombre, Double precio, Integer stock,String distribuidor) {
        super(referencia, nombre, precio, stock);
        this.setDistribuidor(distribuidor);
    }

    @Override
    protected String CuponDescuento(int cantidadComprada) {
        String cupon ="";

        if (cantidadComprada>=5) {
            cupon="¡Felicidades! Obtuviste un cupón del 3x2 con esta compra :)";
        }

        return cupon;
    }

    @Override
    public Double PrecioFinal(int cantidadComprada) {
        double precioFinal = this.getPrecio()*cantidadComprada;

        precioFinal = precioFinal+(precioFinal*NATURALES_IGIC);

        return precioFinal;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }
}
