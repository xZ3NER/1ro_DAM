public class Cuentas {

    Clientes titular;
    String numeroCuenta;
    double saldo=0,limiteNumerosRojos;

    public Cuentas(Clientes titular, String numeroCuenta, double limiteNumerosRojos) {
        this.titular = titular;
        this.numeroCuenta=numeroCuenta;
        this.limiteNumerosRojos=limiteNumerosRojos;
    }

    public Clientes getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteNumerosRojos() {
        return limiteNumerosRojos;
    }

    public void setLimiteNumerosRojos(double limiteNumerosRojos) {
        this.limiteNumerosRojos = limiteNumerosRojos;
    }

    public void ingresar(double saldo) {
        this.saldo+=saldo;
    }

    public void retirar(double saldo) {
        this.saldo-=saldo;
    }

}
