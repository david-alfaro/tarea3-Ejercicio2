package alfaroviquez.david.bl.entidades;

import java.awt.desktop.AboutEvent;
import java.time.LocalDate;


public class AhorroProgramado extends Cuenta {
    private CuentaAhorro cuenta;
    public static int incremento = 1;
    private int numeroCuenta = 3000000;

    public CuentaAhorro getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaAhorro cuenta) {
        this.cuenta = cuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public AhorroProgramado() {
    }

    public AhorroProgramado(double saldo, LocalDate fechaApertura, CuentaAhorro cuenta) {
        super(saldo, fechaApertura);
        this.cuenta = cuenta;
        this.numeroCuenta = numeroCuenta+incremento;
    }

    @Override
    public String toString() {
        return "AhorroProgramado{" +
                "cuenta=" + cuenta +
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
