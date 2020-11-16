package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public CuentaAhorro() {
    }

    public CuentaAhorro(String numeroCuenta, double saldo, LocalDate fechaApertura, double tasaInteres) {
        super(numeroCuenta, saldo, fechaApertura);
        this.tasaInteres = tasaInteres;
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
    public void retiros() {

    }

    @Override
    public void depositos() {

    }
}
