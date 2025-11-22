package patterns.Strategy;

import controller.ProfesoresController;
import dao.IBaseDAO;
import dao.ProfesoresDAO;
import model.Profesores;
import patterns.Facade.ProfesoresFacade;
import patterns.Proxy.SecureDAOProxy;
import view.ProfesoresView;

public class ModuloProfesoresStrategy implements IModuloStrategy {

    @Override
    public void iniciar() {
        IBaseDAO<Profesores> daoSeguro = new SecureDAOProxy<>(new ProfesoresDAO());
        ProfesoresFacade facade = new ProfesoresFacade(daoSeguro);
        ProfesoresView view = new ProfesoresView();
        ProfesoresController controller = new ProfesoresController(view, facade);
        controller.iniciar();
    }

}
