public class Moneda {

    static double cambio;
    static double trasCambio;

    public Moneda() { //constructor, es decir, se inicia cuando se crea un objeto de esta clase
        cambio =1.09;
    }

    public Moneda(double valor) { //constructor, es decir, se inicia cuando se crea un objeto de esta clase, pero admite parametros
        cambio=valor;
    }

    public static double getCambio() { //devuelve el cambio, getter
        return cambio;
    }

    public void eurosAdolares(double valorEuros) { //realiza operacion
        trasCambio=valorEuros*cambio;
    }

    public void dolaresAeuros(double valorDolares) {
        trasCambio=valorDolares/cambio;
    } //realiza operacion

    public double getTrasCambio() {
        return trasCambio;
    } //getter, devuelve el valor tras el cambio
}
