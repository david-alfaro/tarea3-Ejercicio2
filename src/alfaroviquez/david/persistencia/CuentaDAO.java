package alfaroviquez.david.persistencia;

import alfaroviquez.david.bl.entidades.Cuenta;

import java.util.List;

public abstract  class CuentaDAO {
    public abstract void save(Cuenta nuevaCuente);
    public abstract List<Cuenta> findAll();
}
