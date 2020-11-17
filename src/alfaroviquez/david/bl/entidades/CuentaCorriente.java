package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;

public class CuentaCorriente extends Cuenta {
    public CuentaCorriente() {
    }

    public CuentaCorriente(String numeroCuenta, double saldo, LocalDate fechaApertura) {
        super(numeroCuenta, saldo, fechaApertura);
    }


    @Override
    public void retiros() {

    }

    @Override
    public void depositos() {

    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                "} " + super.toString();
    }

    @Override
    public String toCSVLine() {
        return null;
    }
}
