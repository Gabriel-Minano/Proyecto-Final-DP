package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Profesores;

public class ProfesoresFacade {

    private final IBaseDAO<Profesores> dao;

    public ProfesoresFacade(IBaseDAO<Profesores> dao) {
        this.dao = dao;
    }

    public boolean crearProfesor(Profesores profesor) {
        return dao.create(profesor);
    }

    public Profesores verProfesores(int id) {
        return dao.read(id);
    }

    public List<Profesores> verListaProfesores() {
        return dao.readall();
    }

    public boolean actualizarProfesores(Profesores profesor) {
        return dao.update(profesor);
    }

    public boolean eliminarProfesor(int id) {
        return dao.delete(id);
    }
}
