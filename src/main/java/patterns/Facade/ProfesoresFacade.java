package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Profesores;

public class ProfesoresFacade implements IFacade<Profesores> {

    private final IBaseDAO<Profesores> dao;

    public ProfesoresFacade(IBaseDAO<Profesores> dao) {
        this.dao = dao;
    }

    @Override
    public boolean crearEntidad(Profesores profesor) {
        return dao.create(profesor);
    }

    @Override
    public Profesores verEntidad(int id) {
        return dao.read(id);
    }

    @Override
    public List<Profesores> listarEntidades() {
        return dao.readall();
    }

    @Override
    public boolean actualizarEntidad(Profesores profesor) {
        return dao.update(profesor);
    }

    @Override
    public boolean eliminarEntidad(int id) {
        return dao.delete(id);
    }
}
