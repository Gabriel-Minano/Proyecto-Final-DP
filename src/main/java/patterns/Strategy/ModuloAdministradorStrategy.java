package patterns.Strategy;

import controller.AdministradoresController;
import dao.AdministradoresDAO;
import dao.IBaseDAO;
import model.Administradores;
import patterns.Facade.AdministradoresFacade;
import patterns.Facade.IFacade;
import patterns.Proxy.SecureDAOProxy;
import view.AdministradoresView;

public class ModuloAdministradorStrategy implements IModuloStrategy{

    @Override
    public void iniciar() {
        IBaseDAO<Administradores> daoSeguro = new SecureDAOProxy<>(new AdministradoresDAO());
        IFacade<Administradores> facade = new AdministradoresFacade(daoSeguro);
        AdministradoresView view = new AdministradoresView();
        AdministradoresController controller = new AdministradoresController(view, facade);
        controller.iniciar();
    }
    
}
