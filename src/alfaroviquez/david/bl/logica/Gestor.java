package alfaroviquez.david.bl.logica;

import alfaroviquez.david.bl.entidades.*;
import alfaroviquez.david.persistencia.AhorroProgramadoDAO;
import alfaroviquez.david.persistencia.ClienteDAO;
import alfaroviquez.david.persistencia.CuentaAhorroDAO;
import alfaroviquez.david.persistencia.CuentaCorrienteDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gestor {

    private ClienteDAO clienteRepo = new ClienteDAO();
    private CuentaCorrienteDAO cuentaCorrienteRepo = new CuentaCorrienteDAO();
    private CuentaAhorroDAO cuentaAhorroRepo = new CuentaAhorroDAO();
    private AhorroProgramadoDAO ahorroProgramadoRepo = new AhorroProgramadoDAO();

    public void guardarCliente(String nombre, int identificacion, String direccion) {
        Cliente nuevoCliente = new Cliente(nombre, identificacion, direccion, new ArrayList<>());
        clienteRepo.save(nuevoCliente);
    }

    public void guardarCuentaCorriente(double saldo, LocalDate fechaApertura) {
        CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente(saldo, fechaApertura);
        cuentaCorrienteRepo.save(nuevaCuentaCorriente);
    }

    public void guardarCuentaAhorro(double saldo, LocalDate fechaApertura, double tasaInteres) {
        CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro(saldo, fechaApertura, tasaInteres);
        cuentaAhorroRepo.save(nuevaCuentaAhorro);
    }

    public void guardarAhorroProgramado(double saldo, LocalDate fechaApertura, double montoAhorro) {
        AhorroProgramado nuevoAhorroProgramado = new AhorroProgramado(saldo, fechaApertura, new CuentaCorriente(), montoAhorro);
        ahorroProgramadoRepo.save(nuevoAhorroProgramado);
    }

    public List<Cuenta> findCuentasCorrientes() {
        return cuentaCorrienteRepo.findAll();
    }

    public List<Cuenta> findCuentasAhorros() {
        return cuentaAhorroRepo.findAll();
    }

    public List<Cuenta> findSAhorrosProgramados() {
        return ahorroProgramadoRepo.findAll();
    }

    public List<Cliente> findClientes() {
        return clienteRepo.getAll();
    }

    public Cliente buscarClienteporID(int id){
        List<Cliente> listaClientes = findClientes();
        for(int i=0;i<listaClientes.size();i++){
            Cliente clienteActual = listaClientes.get(i);
            if(clienteActual.getIdentificacion()==id){
                return clienteActual;
            }
        }
        return null;
    }

    public Cuenta buscarCuentaCC(int numCuenta){
        List<Cuenta> ListaCuentasCorrientes = findCuentasCorrientes();
        for(int i=0; i<ListaCuentasCorrientes.size();i++){
            Cuenta ccActual = ListaCuentasCorrientes.get(i);
            if(ccActual.getNumCuenta()==numCuenta){
                return ccActual;
            }
        }
        return null;
    }

    public Cuenta buscarCuentasAhorro(int numCuenta){
        List<Cuenta> ListaCuentasAhorro = findCuentasAhorros();
        for(int i=0;i<ListaCuentasAhorro.size();i++){
            Cuenta cuentaActual = ListaCuentasAhorro.get(i);
            if (cuentaActual.getNumCuenta()==numCuenta){
                return cuentaActual;
            }
        }
        return null;
    }

    public Cuenta buscarAhorroProgramado(int numCuenta){
        List<Cuenta> ListaAhorroProgramado = findSAhorrosProgramados();
        for(int i=0;i<ListaAhorroProgramado.size();i++){
            Cuenta cuentaActual = ListaAhorroProgramado.get(i);
            if (cuentaActual.getNumCuenta()==numCuenta){
                return cuentaActual;
            }
        }
        return null;
    }
    public void depositoCuentaCorriente(int numeroCuenta, double monto) {
        CuentaCorriente cc = (CuentaCorriente) buscarCuentaCC(numeroCuenta);
        cc.depositos(monto);

    }

    public void depositoCuentaAhorro(int numeroCuenta, double monto) {
        CuentaAhorro ca = (CuentaAhorro) buscarCuentasAhorro(numeroCuenta);
        ca.depositos(monto);

    }

    public void retiroCC(int numeroCuenta, double monto){
        CuentaCorriente cc = (CuentaCorriente) buscarCuentaCC(numeroCuenta);
        cc.retiros(monto);
    }

    public void retiroCuentaAhorro(int numeroCuenta, double monto){
        CuentaAhorro ca = (CuentaAhorro) buscarCuentasAhorro(numeroCuenta);
        double saldo = ca.getSaldo();
        double saldo50 = ca.getSaldo()/2;
        if(saldo>100000 && monto<saldo50){
            ca.retiros(monto);
        }
    }

    public Double saldoCuentaCorriente(int numCuenta){
        CuentaAhorro ca = (CuentaAhorro) buscarCuentasAhorro(numCuenta);
        double saldo = ca.getSaldo();
        return saldo;
    }

    public Double saldoCuentaAhorro(int numCuenta){
        CuentaCorriente cc = (CuentaCorriente) buscarCuentaCC(numCuenta);
        double saldo = cc.getSaldo();
        return saldo;
    }

}
