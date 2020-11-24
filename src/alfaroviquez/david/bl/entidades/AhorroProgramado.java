package alfaroviquez.david.bl.entidades;


import java.time.LocalDate;


public class AhorroProgramado extends Cuenta {
    private CuentaCorriente cuenta;
    private double montoAhorro;
    public static int incremento = 1;
    private int numeroCuenta =getNumCuenta();

    public CuentaCorriente getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaCorriente cuenta) {
        this.cuenta = cuenta;
    }


    public double getMontoAhorro() {
        return montoAhorro;
    }

    public void setMontoAhorro(double montoAhorro) {
        this.montoAhorro = montoAhorro;
    }

    public AhorroProgramado() {
    }

    public AhorroProgramado(double saldo, LocalDate fechaApertura, CuentaCorriente cuenta, double montoAhorro) {
        super(saldo, fechaApertura);
        this.cuenta = cuenta;
        this.numeroCuenta=getNumCuenta()+incremento++;
    }
    public AhorroProgramado(String sourceLines){
        String[] datos = sourceLines.split(",");
        this.numeroCuenta = Integer.parseInt(datos[0]);
        this.saldo = Double.parseDouble(datos[1]);
        this.fechaApertura = LocalDate.parse(datos[2]);
        this.montoAhorro = Double.parseDouble(datos[3]);
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
        return this.numeroCuenta+","+this.saldo+","+this.fechaApertura+","+this.montoAhorro;
    }
}
