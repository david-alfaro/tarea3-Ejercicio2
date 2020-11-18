package alfaroviquez.david.bl.entidades;

import java.time.LocalDate;


public class CuentaCorriente extends Cuenta {

    public static int incremento = 1;
    private int numeroCuenta = 1000000;

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo, LocalDate fechaApertura) {
        super(saldo, fechaApertura);
        this.numeroCuenta = numeroCuenta+incremento;
    }

    public CuentaCorriente(String sourceLines) {
        String[] datos = sourceLines.split(",");
        this.numeroCuenta = Integer.parseInt(datos[0]);
        this.saldo = Double.parseDouble(datos[1]);
        this.fechaApertura = LocalDate.parse(datos[2]);
    }


    @Override
    public void retiros(double monto) {
        saldo = saldo - monto;
    }

    @Override
    public void depositos(double monto) {
        saldo = saldo + monto;
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
        return this.numeroCuenta + "," + this.saldo + "," + this.fechaApertura;
    }


}
