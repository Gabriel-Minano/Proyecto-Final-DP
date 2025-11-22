package patterns.Proxy;

import dao.IBaseDAO;
import java.util.List;

public class SecureDAOProxy<T> implements IBaseDAO<T> {

    private final IBaseDAO<T> daoReal;

    public SecureDAOProxy(IBaseDAO<T> daoReal) {
        this.daoReal = daoReal;
    }

    private boolean acceso() {
        if (!SecurityContext.isAutenticado()) {
            System.out.println("Acceso denegado. Debe iniciar sesión como Administrador.");
            return false;
        }
        return true;
    }

    @Override
    public boolean create(T input) {
        return acceso() && daoReal.create(input);
    }

    @Override
    public T read(int id) {
        return acceso() ? daoReal.read(id) : null;
    }

    @Override
    public List<T> readall() {
        return acceso() ? daoReal.readall() : null;
    }

    @Override
    public boolean update(T input) {
        return acceso() && daoReal.update(input);
    }

    @Override
    public boolean delete(int id) {
        return acceso() && daoReal.delete(id);
    }

}
