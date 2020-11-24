package alfaroviquez.david.bl.entidades;


import alfaroviquez.david.bl.interfaces.Movimientos;
import alfaroviquez.david.bl.interfaces.SerializacionCSV;

import java.time.LocalDate;


public abstract class Cuenta implements Movimientos, SerializacionCSV {

    protected int numCuenta=1000000;
    protected double saldo;
    protected LocalDate fechaApertura;


    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
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

    public Cuenta( double saldo, LocalDate fechaApertura) {

        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
    }
    public  Cuenta(String sourceLines){
        String[] datos = sourceLines.split(",");

        this.saldo= Double.parseDouble(datos[1]);
        this.fechaApertura= LocalDate.parse(datos[2]);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                ", saldo=" + saldo +
                ", fechaApertura=" + fechaApertura +
                '}';
    }

}
