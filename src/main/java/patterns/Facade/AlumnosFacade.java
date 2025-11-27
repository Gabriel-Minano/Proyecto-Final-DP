package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Alumnos;

public class AlumnosFacade implements IFacade<Alumnos> {

    private final IBaseDAO<Alumnos> dao;

    public AlumnosFacade(IBaseDAO<Alumnos> dao) {
        this.dao = dao;
    }

    @Override
    public boolean crearEntidad(Alumnos alumno) {
        return dao.create(alumno);
    }

    @Override
    public Alumnos verEntidad(int id) {
        return dao.read(id);
    }

    @Override
    public List<Alumnos> listarEntidades() {
        return dao.readall();
    }

    @Override
    public boolean actualizarEntidad(Alumnos alumno) {
        return dao.update(alumno);
    }

    @Override
    public boolean eliminarEntidad(int id) {
        return dao.delete(id);
    }
}
