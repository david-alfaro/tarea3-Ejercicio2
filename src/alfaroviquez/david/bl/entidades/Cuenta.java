package alfaroviquez.david.bl.entidades;


import alfaroviquez.david.bl.interfaces.Movimientos;

import java.time.LocalDate;

public abstract class Cuenta implements Movimientos {
    protected String numeroCuenta;
    protected double saldo;
    protected LocalDate fechaApertura;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, double saldo, LocalDate fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                '}';
    }
}
