package alfaroviquez.david.bl.entidades;

import alfaroviquez.david.bl.interfaces.SerializacionCSV;

import java.util.ArrayList;

public class Cliente implements SerializacionCSV {
    private String nombre;
    private int identificacion;
    private String direccion;
    private ArrayList<Cuenta> cuentas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Cliente() {
    }

    public Cliente(String nombre, int identificacion, String direccion, ArrayList<Cuenta> cuentas) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.cuentas = cuentas;
    }


    public Cliente(String sourceLines){
        String[] datos = sourceLines.split(",");
        this.nombre = datos[0];
        this.identificacion=Integer.parseInt(datos[1]);
        this.direccion = datos[2];

    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion=" + identificacion +
                ", direccion='" + direccion + '\'' +
                ", cuentas=" + cuentas +
                '}';
    }
    @Override
    public String toCSVLine(){
        return this.nombre+","+this.identificacion+","+this.direccion;
    }
}
