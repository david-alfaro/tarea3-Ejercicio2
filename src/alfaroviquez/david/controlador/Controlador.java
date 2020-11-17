package alfaroviquez.david.controlador;

import alfaroviquez.david.bl.logica.Gestor;
import alfaroviquez.david.ui.IU;

import java.time.LocalDate;


public class Controlador {
    private IU interfaz = new IU();
    private Gestor gestor = new Gestor();

    public void ejecutar(){
        int opcion=0;
        do {
            interfaz.mostrarMenu();
            opcion=interfaz.leerNumero();
            procesarOpcion(opcion);
        }while (opcion!=5);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion){
            case 1:
                registrarCliente();
                break;
            case 2:
                break;
            case 3:
                registrarCuentaCorriente();
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                interfaz.imprimirMensaje("Opcion desconocida");
        }
    }

    private void registrarCliente() {
        interfaz.imprimirMensaje("REGISTRO DE CLIENTES-->");
        interfaz.imprimirMensaje("Nombre completo: ");
        String nombre = interfaz.leerMensaje();
        interfaz.imprimirMensaje("Idendtifacion: ");
        int indentificacion = interfaz.leerNumero();
        interfaz.imprimirMensaje("Direccion: ");
        String direccion = interfaz.leerMensaje();
        gestor.guardarCliente(nombre,indentificacion,direccion);
        interfaz.imprimirMensaje("Cliente registrado");
    }
    private void registrarCuentaCorriente(){
        interfaz.imprimirMensaje("REGISTRAR CUENTA CORRIENTE-->");
        interfaz.imprimirMensaje("Ingrese el monto del deposito: ");
        double monto = interfaz.leerNumero();
        if(monto<50000){
            interfaz.imprimirMensaje("Para abrir una cuenta corriente el monto minimo son 50 mil colones");

        }else{
            interfaz.imprimirMensaje("Ingrese fecha de apertura (yyyy-MM-dd): ");
            String fecha = interfaz.leerMensaje();
            LocalDate fechaApertura = obtenerFecha(fecha);
            gestor.guardarCuentaCorriente(monto,fechaApertura);
            interfaz.imprimirMensaje("Cuenta creada exitosamente");
        }




    }
     private LocalDate obtenerFecha(String fecha){
        return LocalDate.parse(fecha);
     }
}
