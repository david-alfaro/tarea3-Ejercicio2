package alfaroviquez.david.bl.logica;

import alfaroviquez.david.bl.entidades.Cliente;
import alfaroviquez.david.bl.entidades.Cuenta;
import alfaroviquez.david.persistencia.ClienteDAO;

import java.util.ArrayList;

public class Gestor {

    private ClienteDAO clienteRepo = new ClienteDAO();

    public void guardarCliente(String nombre, int identificacion, String direccion){
        Cliente nuevoCliente = new Cliente(nombre,identificacion,direccion,new ArrayList<>());
        clienteRepo.save(nuevoCliente);
    }

}
