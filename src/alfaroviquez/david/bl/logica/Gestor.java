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
        CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente(saldo,fechaApertura);
        cuentaCorrienteRepo.save(nuevaCuentaCorriente);
    }

    public void guardarCuentaAhorro(double saldo, LocalDate fechaApertura, double tasaInteres){
        CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro(saldo,fechaApertura,tasaInteres);
        cuentaAhorroRepo.save(nuevaCuentaAhorro);
    }

    public void guardarAhorroProgramado(double saldo, LocalDate fechaApertura, double montoAhorro){
        AhorroProgramado nuevoAhorroProgramado = new AhorroProgramado(saldo,fechaApertura,new CuentaCorriente(),montoAhorro);
        ahorroProgramadoRepo.save(nuevoAhorroProgramado);
    }

    public List<Cuenta>findCuentasCorrientes(){
        return cuentaCorrienteRepo.findAll();
    }

    public List<Cuenta>findCuentasAhorros(){
        return cuentaAhorroRepo.findAll();
    }

    public List<Cuenta >findSAhorrosProgramados(){
        return ahorroProgramadoRepo.findAll();
    }
    public List<Cliente> findClientes(){
        return clienteRepo.getAll();
    }


}
