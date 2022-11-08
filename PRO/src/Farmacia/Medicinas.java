package Farmacia;

public class Medicinas extends Productos{

    private Boolean segSocial;
    private Boolean receta;

    protected Medicinas(String referencia, String nombre, Double precio, Integer stock,Boolean segSocial, Boolean receta) {
        super(referencia, nombre, precio, stock);
        this.segSocial = segSocial;
        this.receta = receta;
    }

    @Override
    protected String CuponDescuento(int cantidadComprada) {
        String cupon ="";

        if (cantidadComprada>=5) {
            cupon="¡Felicidades! Obtuviste un cupón del 10% con esta compra :)";
        }

        return cupon;
    }

    public Boolean getSegSocial() {
        return segSocial;
    }

    public Boolean getReceta() {
        return receta;
    }

    @Override
    public Double PrecioFinal(int cantidadComprada) {
        double precioFinal = this.getPrecio()*cantidadComprada;

        if (this.segSocial) {
            precioFinal = precioFinal-(precioFinal*DECREMENTO_SEG_SOCIAL);
        }

        precioFinal = precioFinal+(precioFinal*MEDICINA_IGIC);

        return precioFinal;
    }
}
