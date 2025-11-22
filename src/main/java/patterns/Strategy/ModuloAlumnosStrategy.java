package patterns.Strategy;

import controller.AlumnosController;
import dao.AlumnosDAO;
import dao.IBaseDAO;
import model.Alumnos;
import patterns.Facade.AlumnosFacade;
import patterns.Proxy.SecureDAOProxy;
import view.AlumnosView;

public class ModuloAlumnosStrategy implements IModuloStrategy {

    @Override
    public void iniciar() {
        IBaseDAO<Alumnos> daoSeguro = new SecureDAOProxy<>(new AlumnosDAO());
        AlumnosFacade facade = new AlumnosFacade(daoSeguro);
        AlumnosView view = new AlumnosView();
        AlumnosController controller = new AlumnosController(view, facade);
        controller.iniciar();
    }

}
