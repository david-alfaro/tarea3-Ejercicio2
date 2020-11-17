package alfaroviquez.david.controlador;

import alfaroviquez.david.bl.logica.Gestor;
import alfaroviquez.david.ui.IU;

import java.util.ArrayList;

public class Controlador {
    private IU interfaz = new IU();
    private Gestor gestor = new Gestor();

    public void ejecutar(){
        int opcion=0;
        do {
            interfaz.mostrarMenu();
            opcion=interfaz.leerNumero();
            procesarOpcion(opcion);
        }while (opcion!=3);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion){
            case 1:
                registrarCliente();
                break;
            case 2:
                break;
            case 3:
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
}
