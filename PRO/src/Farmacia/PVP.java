package Farmacia;

public interface PVP {

    Double MEDICINA_IGIC = 0.04; //4%
    Double DECREMENTO_SEG_SOCIAL = 0.6; //60%
    Double NATURALES_IGIC = 0.16; //16%

    Double PrecioFinal(int cantidadComprada);
}
