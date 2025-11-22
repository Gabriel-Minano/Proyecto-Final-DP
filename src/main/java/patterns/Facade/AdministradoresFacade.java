package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Administradores;

public class AdministradoresFacade {

    private final IBaseDAO<Administradores> dao;

    public AdministradoresFacade(IBaseDAO<Administradores> dao) {
        this.dao = dao;
    }

    public boolean crearAdministrador(Administradores admin) {
        return dao.create(admin);
    }

    public Administradores verAdministradores(int id) {
        return dao.read(id);
    }

    public List<Administradores> verListaAdministradores() {
        return dao.readall();
    }

    public boolean actualizarAdministradores(Administradores admin) {
        return dao.update(admin);
    }

    public boolean eliminarAdministrador(int id) {
        return dao.delete(id);
    }
}
