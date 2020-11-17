package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;

public class AhorroProgramado extends Cuenta {
    private CuentaAhorro cuenta;

    public CuentaAhorro getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaAhorro cuenta) {
        this.cuenta = cuenta;
    }

    public AhorroProgramado() {
    }

    public AhorroProgramado(String numeroCuenta, double saldo, LocalDate fechaApertura, CuentaAhorro cuenta) {
        super(numeroCuenta, saldo, fechaApertura);
        this.cuenta = cuenta;
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
    public void retiros() {

    }

    @Override
    public void depositos() {

    }

    @Override
    public String toCSVLine() {
        return null;
    }
}
