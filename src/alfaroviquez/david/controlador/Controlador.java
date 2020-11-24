package alfaroviquez.david.controlador;

import alfaroviquez.david.bl.entidades.AhorroProgramado;
import alfaroviquez.david.bl.entidades.Cliente;
import alfaroviquez.david.bl.entidades.Cuenta;
import alfaroviquez.david.bl.entidades.CuentaCorriente;
import alfaroviquez.david.bl.logica.Gestor;
import alfaroviquez.david.ui.IU;

import java.time.LocalDate;
import java.util.List;


public class Controlador {
    private IU interfaz = new IU();
    private Gestor gestor = new Gestor();

    public void ejecutar() {
        int opcion = 0;
        do {
            interfaz.mostrarMenu();
            opcion = interfaz.leerNumero();
            procesarOpcion(opcion);
        } while (opcion != 7);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarCliente();
                break;
            case 2:
                listarClientesBanco();
                break;
            case 3:
                registroCuentas();
                break;
            case 4:
                listarCuentas();
                break;
            case 5:
                depositos();
                break;
            case 6:
                retiros();
                break;
            case 7:
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
        gestor.guardarCliente(nombre, indentificacion, direccion);
        interfaz.imprimirMensaje("Cliente registrado");


    }


    private void registrarCuentaCorriente() {
        interfaz.imprimirMensaje("REGISTRAR CUENTA CORRIENTE-->");
        interfaz.imprimirMensaje("Ingrese el monto del deposito: ");
        double monto = interfaz.leerNumero();
        if (monto < 50000) {
            interfaz.imprimirMensaje("Para abrir una cuenta corriente el monto minimo son 50 mil colones");

        } else {
            interfaz.imprimirMensaje("Ingrese fecha de apertura (yyyy-MM-dd): ");
            String fecha = interfaz.leerMensaje();
            LocalDate fechaApertura = obtenerFecha(fecha);
            gestor.guardarCuentaCorriente(monto, fechaApertura);
            interfaz.imprimirMensaje("Cuenta creada exitosamente");
        }

    }

    private void registrarCuentaAhorro() {
        interfaz.imprimirMensaje("REGISTRAR CUENTA DE AHORRO-->");
        interfaz.imprimirMensaje("Ingrese el monto a depositar: ");
        double monto = interfaz.leerNumero();
        interfaz.imprimirMensaje("Ingrese la fecha de apertura(yyyy-MM-dd): ");
        String fecha = interfaz.leerMensaje();
        LocalDate fechaApertura = obtenerFecha(fecha);
        double tasaInteres = 0.05;
        gestor.guardarCuentaAhorro(monto, fechaApertura, tasaInteres);
        interfaz.imprimirMensaje("Cuenta creada exitosamente");
    }

    private void registrarAhorroProgramado() {
        interfaz.imprimirMensaje("CREAR AHORRO PROGRAMADO-->");
        double saldo = 0;
        interfaz.imprimirMensaje("Fecha de apertura (yyyy-MM-dd): ");
        String fecha = interfaz.leerMensaje();
        LocalDate fechaApertura = obtenerFecha(fecha);
        interfaz.imprimirMensaje("Ingrese el monto a ahorrar: ");
        double montoAhorro = interfaz.leerNumero();
        gestor.guardarAhorroProgramado(saldo, fechaApertura, montoAhorro);
        interfaz.imprimirMensaje("Ahorro programado registrado");
    }


    private void listarClientesBanco() {
        for (Cliente cliente : gestor.findClientes()
        ) {
            interfaz.imprimirMensaje(cliente.toCSVLine());
        }
    }

    private void asginarCuentaCorrienteACliente() {
        for (Cliente cliente : gestor.findClientes()
        ) {
            interfaz.imprimirMensaje(cliente.toCSVLine());
        }
        interfaz.imprimirMensaje("Numero de cedula del cliente: ");
        int cedula = interfaz.leerNumero();
        Cliente cliente = gestor.buscarClienteporID(cedula);
        interfaz.imprimirMensaje("Numero de cuenta a asociar: ");
        for (Cuenta cuenta : gestor.findCuentasCorrientes()
        ) {
            interfaz.imprimirMensaje(cuenta.toCSVLine());
        }
        interfaz.imprimirMensaje("Ingrese el numero de cuenta a asignar");

        int numeroCuenta = interfaz.leerNumero();
        Cuenta cuentaCorriente = gestor.buscarCuentaCC(numeroCuenta);
        cliente.getCuentas().add(cuentaCorriente);
        interfaz.imprimirMensaje("Cuenta " + numeroCuenta + " ligada al cliente " + cedula);
    }

    private void asignarCuentaAhorrosACliente() {
        for (Cliente cliente : gestor.findClientes()
        ) {
            interfaz.imprimirMensaje(cliente.toCSVLine());
        }
        interfaz.imprimirMensaje("Numero de cedula del cliente: ");
        int cedula = interfaz.leerNumero();
        Cliente cliente = gestor.buscarClienteporID(cedula);
        for (Cuenta cuenta : gestor.findCuentasAhorros()
        ) {
            interfaz.imprimirMensaje(cuenta.toCSVLine());
        }
        interfaz.imprimirMensaje("Ingrese el numero de cuenta a asignar");
        int numeroCuenta = interfaz.leerNumero();
        Cuenta cuentaAhorro = gestor.buscarCuentasAhorro(numeroCuenta);
        cliente.getCuentas().add(cuentaAhorro);
        interfaz.imprimirMensaje("Cuenta " + numeroCuenta + " ligada al cliente " + cedula);
    }

    private void asignarAhorroProgrmadoACuentaCorriente() {
        for (Cuenta cuenta : gestor.findCuentasCorrientes()
        ) {
            interfaz.imprimirMensaje(cuenta.toCSVLine());
        }
        int numeroCuenta = interfaz.leerNumero();
        Cuenta cuentaCorriente = gestor.buscarCuentaCC(numeroCuenta);
        for (Cuenta cuenta : gestor.findSAhorrosProgramados()
        ) {
            interfaz.imprimirMensaje(cuenta.toCSVLine());
        }
        int ahorroProgramado = interfaz.leerNumero();
        AhorroProgramado cuentaAhorroProgramado = (AhorroProgramado) gestor.buscarAhorroProgramado(ahorroProgramado);
        cuentaAhorroProgramado.setCuenta((CuentaCorriente) cuentaCorriente);
    }


    private void listarCuentas() {
        int opcion2 = 0;
        do {
            interfaz.subMenu();
            opcion2 = interfaz.leerNumero();
            procesarSubMenu(opcion2);
        } while (opcion2 != 4);
    }

    private void procesarSubMenu(int opcion2) {
        switch (opcion2) {
            case 1:
                for (Cuenta cuentaCorriente : gestor.findCuentasCorrientes()
                ) {
                    interfaz.imprimirMensaje(cuentaCorriente.toCSVLine());
                }
                break;
            case 2:
                for (Cuenta cuentaAhorro : gestor.findCuentasAhorros()
                ) {
                    interfaz.imprimirMensaje(cuentaAhorro.toCSVLine());
                }
                break;
            case 3:
                for (Cuenta ahorroProgramado : gestor.findSAhorrosProgramados()
                ) {
                    interfaz.imprimirMensaje(ahorroProgramado.toCSVLine());
                }
                break;
            case 4:
                break;
            default:
                interfaz.imprimirMensaje("Opcion desconocida");

        }
    }

    private void registroCuentas() {
        int opcion3 = 0;
        do {
            interfaz.subMenu2();
            opcion3 = interfaz.leerNumero();
            procesarSubMenu2(opcion3);

        } while (opcion3 != 7);
    }

    private void procesarSubMenu2(int opcion3) {
        switch (opcion3) {
            case 1:
                registrarCuentaCorriente();
                break;
            case 2:
                registrarCuentaAhorro();
                break;
            case 3:
                registrarAhorroProgramado();
                break;
            case 4:
                asginarCuentaCorrienteACliente();
                break;
            case 5:
                asignarCuentaAhorrosACliente();
                break;
            case 6:
                asignarAhorroProgrmadoACuentaCorriente();
                break;
            case 7:
                break;
            default:
                interfaz.imprimirMensaje("Opcion desconocida");
        }
    }

    private void depositos() {
        int opcion = 0;
        do {
            interfaz.subMenu3();
            opcion = interfaz.leerNumero();
            procesarSubMenu3(opcion);
        } while (opcion != 3);
    }

    private void procesarSubMenu3(int opcion) {
        switch (opcion) {
            case 1:
                depositarEnCuentaCorriente();
                break;
            case 2:
                depositarEnCuentaAhorro();
                break;
            case 3:
                break;
            default:
                interfaz.imprimirMensaje("Opcion no valida");
        }
    }

    private void depositarEnCuentaCorriente() {
        interfaz.imprimirMensaje("Identificacion del cliente: ");
        int id = interfaz.leerNumero();
        Cliente unCliente = gestor.buscarClienteporID(id);
        List<Cuenta> cuentasCliente = unCliente.getCuentas();
        for (Cuenta cuenta : cuentasCliente
        ) {
            interfaz.imprimirMensaje(cuenta.toString());
        }
        interfaz.imprimirMensaje("Ingrese el numero de cuenta: ");
        int numCuenta = interfaz.leerNumero();
        interfaz.imprimirMensaje("Ingrese el monto a depositar: ");
        double monto = interfaz.leerNumero();
        gestor.depositoCuentaCorriente(numCuenta,monto);
        interfaz.imprimirMensaje("Deposito realizado exitosamente");
        double saldoCuenta = gestor.saldoCuentaCorriente(numCuenta);
        interfaz.imprimirMensaje("El saldo de la cuenta es: ");
        interfaz.imprimirNumero(saldoCuenta);
    }
    private void depositarEnCuentaAhorro() {
        interfaz.imprimirMensaje("Identificacion del cliente: ");
        int id = interfaz.leerNumero();
        Cliente unCliente = gestor.buscarClienteporID(id);
        List<Cuenta> cuentasCliente = unCliente.getCuentas();
        for (Cuenta cuenta : cuentasCliente
        ) {
            interfaz.imprimirMensaje(cuenta.toString());
        }
        interfaz.imprimirMensaje("Ingrese el numero de cuenta: ");
        int numCuenta = interfaz.leerNumero();
        interfaz.imprimirMensaje("Ingrese el monto a depositar: ");
        double monto = interfaz.leerNumero();
        gestor.depositoCuentaAhorro(numCuenta,monto);
        interfaz.imprimirMensaje("Deposito realizado exitosamente");
        double saldoCuenta = gestor.saldoCuentaAhorro(numCuenta);
        interfaz.imprimirMensaje("El saldo de la cuenta es: ");
        interfaz.imprimirNumero(saldoCuenta);

    }

    private void retiros(){
        int opcion=0;
        do {
            interfaz.subMenu4();
            opcion = interfaz.leerNumero();
            procesarSubMenu4(opcion);
        }while (opcion!=3);
    }

    private void procesarSubMenu4(int opcion) {
        switch (opcion) {
            case 1:
                retirodeCuentaCorriente();
                break;
            case 2:
                retirodeCuentaAhorro();
                break;
            case 3:
                break;
            default:
                interfaz.imprimirMensaje("Opcion no valida");
        }
    }

    private void retirodeCuentaCorriente(){
        interfaz.imprimirMensaje("Identificacion del cliente: ");
        int id = interfaz.leerNumero();
        Cliente unCliente = gestor.buscarClienteporID(id);
        List<Cuenta> cuentasCliente = unCliente.getCuentas();
        for (Cuenta cuenta : cuentasCliente
        ) {
            interfaz.imprimirMensaje(cuenta.toCSVLine());
        }
        interfaz.imprimirMensaje("Ingrese el numero de cuenta: ");
        int numCuenta = interfaz.leerNumero();
        interfaz.imprimirMensaje("Ingrese el monto a depositar: ");
        double monto = interfaz.leerNumero();
        gestor.retiroCC(numCuenta,monto);
        interfaz.imprimirMensaje("Retiro realizado exitosamente");
        double saldoCuenta = gestor.saldoCuentaCorriente(numCuenta);
        interfaz.imprimirMensaje("El saldo de la cuenta es: ");
        interfaz.imprimirNumero(saldoCuenta);
    }
    private void retirodeCuentaAhorro(){
        interfaz.imprimirMensaje("Identificacion del cliente: ");
        int id = interfaz.leerNumero();
        Cliente unCliente = gestor.buscarClienteporID(id);
        List<Cuenta> cuentasCliente = unCliente.getCuentas();
        for (Cuenta cuenta : cuentasCliente
        ) {
            interfaz.imprimirMensaje(cuenta.toCSVLine());
        }
        interfaz.imprimirMensaje("Ingrese el numero de cuenta: ");
        int numCuenta = interfaz.leerNumero();
        interfaz.imprimirMensaje("Ingrese el monto a depositar: ");
        double monto = interfaz.leerNumero();
        gestor.retiroCuentaAhorro(numCuenta,monto);
        interfaz.imprimirMensaje("Retiro realizado exitosamente");
        double saldoCuenta = gestor.saldoCuentaAhorro(numCuenta);
        interfaz.imprimirMensaje("El saldo de la cuenta es: ");
        interfaz.imprimirNumero(saldoCuenta);
    }

    private LocalDate obtenerFecha(String fecha) {
        return LocalDate.parse(fecha);
    }
}
