package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Aula_profesor;

public class Aula_profesorFacade {

    private final IBaseDAO<Aula_profesor> dao;

    public Aula_profesorFacade(IBaseDAO<Aula_profesor> dao) {
        this.dao = dao;
    }

    public boolean crearAsignacion(Aula_profesor asignacion) {
        return dao.create(asignacion);
    }

    public Aula_profesor verAsignaciones(int id) {
        return dao.read(id);
    }

    public List<Aula_profesor> verListaAsignaciones() {
        return dao.readall();
    }

    public boolean actualizarAsignaciones(Aula_profesor asignacion) {
        return dao.update(asignacion);
    }

    public boolean eliminarAsignacion(int id) {
        return dao.delete(id);
    }
}
