package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Administradores;

public class AdministradoresFacade implements IFacade<Administradores> {

    private final IBaseDAO<Administradores> dao;

    public AdministradoresFacade(IBaseDAO<Administradores> dao) {
        this.dao = dao;
    }

    @Override
    public boolean crearEntidad(Administradores admin) {
        return dao.create(admin);
    }

    @Override
    public Administradores verEntidad(int id) {
        return dao.read(id);
    }

    @Override
    public List<Administradores> listarEntidades() {
        return dao.readall();
    }

    @Override
    public boolean actualizarEntidad(Administradores admin) {
        return dao.update(admin);
    }

    @Override
    public boolean eliminarEntidad(int id) {
        return dao.delete(id);
    }
}
