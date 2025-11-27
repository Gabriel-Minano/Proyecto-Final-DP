package patterns.Strategy;

import controller.AulasController;
import dao.AulasDAO;
import dao.IBaseDAO;
import model.Aulas;
import patterns.Facade.AulasFacade;
import patterns.Facade.IFacade;
import patterns.Proxy.SecureDAOProxy;
import view.AulasView;

public class ModuloAulasStrategy implements IModuloStrategy {

    @Override
    public void iniciar() {
        IBaseDAO<Aulas> daoSeguro = new SecureDAOProxy<>(new AulasDAO());
        IFacade<Aulas> facade = new AulasFacade(daoSeguro);
        AulasView view = new AulasView();
        AulasController controller = new AulasController(view, facade);
        controller.iniciar();
    }

}
