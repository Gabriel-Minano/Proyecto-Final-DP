package patterns.Facade;

import dao.IBaseDAO;
import java.util.List;
import model.Alumnos;

public class AlumnosFacade {

    private final IBaseDAO<Alumnos> dao;

    public AlumnosFacade(IBaseDAO<Alumnos> dao) {
        this.dao = dao;
    }

    public boolean crearAlumno(Alumnos alumno) {
        return dao.create(alumno);
    }

    public Alumnos verAlumno(int id) {
        return dao.read(id);
    }

    public List<Alumnos> verListaAlumnos() {
        return dao.readall();
    }

    public boolean actualizarAlumno(Alumnos alumno) {
        return dao.update(alumno);
    }

    public boolean eliminarAlumno(int id) {
        return dao.delete(id);
    }
}
