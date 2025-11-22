package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Aulas;

public class AulasFacade {

    private final IBaseDAO<Aulas> dao;

    public AulasFacade(IBaseDAO<Aulas> dao) {
        this.dao = dao;
    }

    public boolean crearAula(Aulas aula) {
        return dao.create(aula);
    }

    public Aulas verAulas(int id) {
        return dao.read(id);
    }

    public List<Aulas> verListaAulas() {
        return dao.readall();
    }

    public boolean actualizarAulas(Aulas aulas) {
        return dao.update(aulas);
    }

    public boolean eliminarAulas(int id) {
        return dao.delete(id);
    }
}
