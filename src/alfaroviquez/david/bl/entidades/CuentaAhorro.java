package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;


public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    public static int incremento = 1;
    private int numeroCuenta = 2000000;

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaAhorro() {
    }

    public CuentaAhorro(double saldo, LocalDate fechaApertura, double tasaInteres) {
        super(saldo, fechaApertura);
        this.tasaInteres = tasaInteres;
        this.numeroCuenta = numeroCuenta+incremento;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "tasaInteres=" + tasaInteres +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                "} " + super.toString();
    }


    @Override
    public void retiros(double monto) {

    }

    @Override
    public void depositos(double monto) {

    }

    @Override
    public String toCSVLine() {
        return null;
    }
}
