package alfaroviquez.david.bl.logica;

import alfaroviquez.david.bl.entidades.Cliente;
import alfaroviquez.david.bl.entidades.Cuenta;
import alfaroviquez.david.bl.entidades.CuentaCorriente;
import alfaroviquez.david.persistencia.ClienteDAO;
import alfaroviquez.david.persistencia.CuentaCorrienteDAO;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gestor {

    private ClienteDAO clienteRepo = new ClienteDAO();
    private CuentaCorrienteDAO cuentaCorrienteRepo = new CuentaCorrienteDAO();

    public void guardarCliente(String nombre, int identificacion, String direccion) {
        Cliente nuevoCliente = new Cliente(nombre, identificacion, direccion, new ArrayList<>());
        clienteRepo.save(nuevoCliente);
    }

    public void guardarCuentaCorriente(double saldo, LocalDate fechaApertura) {
        CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente(saldo,fechaApertura);
        cuentaCorrienteRepo.save(nuevaCuentaCorriente);
    }

}
