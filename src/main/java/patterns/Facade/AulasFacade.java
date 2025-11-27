package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Aulas;

public class AulasFacade implements IFacade<Aulas> {

    private final IBaseDAO<Aulas> dao;

    public AulasFacade(IBaseDAO<Aulas> dao) {
        this.dao = dao;
    }

    @Override
    public boolean crearEntidad(Aulas aula) {
        return dao.create(aula);
    }

    @Override
    public Aulas verEntidad(int id) {
        return dao.read(id);
    }

    @Override
    public List<Aulas> listarEntidades() {
        return dao.readall();
    }

    @Override
    public boolean actualizarEntidad(Aulas aula) {
        return dao.update(aula);
    }

    @Override
    public boolean eliminarEntidad(int id) {
        return dao.delete(id);
    }
}
