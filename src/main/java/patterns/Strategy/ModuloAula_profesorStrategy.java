package patterns.Strategy;

import controller.Aula_profesorController;
import dao.Aula_profesorDAO;
import dao.IBaseDAO;
import model.Aula_profesor;
import patterns.Facade.Aula_profesorFacade;
import patterns.Proxy.SecureDAOProxy;
import view.Aula_profesorView;

public class ModuloAula_profesorStrategy implements IModuloStrategy {

    @Override
    public void iniciar() {
        IBaseDAO<Aula_profesor> daoSeguro = new SecureDAOProxy<>(new Aula_profesorDAO());
        Aula_profesorFacade facade = new Aula_profesorFacade(daoSeguro);
        Aula_profesorView view = new Aula_profesorView();
        Aula_profesorController controller = new Aula_profesorController(view, facade);
        controller.iniciar();
    }

}
