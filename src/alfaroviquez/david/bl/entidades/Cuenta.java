package alfaroviquez.david.bl.entidades;


import alfaroviquez.david.bl.interfaces.Movimientos;
import alfaroviquez.david.bl.interfaces.SerializacionCSV;

import java.time.LocalDate;

public abstract class Cuenta implements Movimientos, SerializacionCSV {
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
    public  Cuenta(String sourceLines){
        String[] datos = sourceLines.split(",");
        this.numeroCuenta=datos[0];
        this.saldo= Double.parseDouble(datos[1]);
        this.fechaApertura= LocalDate.parse(datos[2]);
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
