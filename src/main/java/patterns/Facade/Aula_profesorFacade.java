    package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Aula_profesor;

public class Aula_profesorFacade implements IFacade<Aula_profesor> {

    private final IBaseDAO<Aula_profesor> dao;

    public Aula_profesorFacade(IBaseDAO<Aula_profesor> dao) {
        this.dao = dao;
    }

    @Override
    public boolean crearEntidad(Aula_profesor asignacion) {
        return dao.create(asignacion);
    }

    @Override
    public Aula_profesor verEntidad(int id) {
        return dao.read(id);
    }

    @Override
    public List<Aula_profesor> listarEntidades() {
        return dao.readall();
    }

    @Override
    public boolean actualizarEntidad(Aula_profesor asignacion) {
        return dao.update(asignacion);
    }

    @Override
    public boolean eliminarEntidad(int id) {
        return dao.delete(id);
    }
}
