package patterns.Facade;

import java.util.List;

public interface IFacade<T> {

    public boolean crearEntidad(T input);

    public T verEntidad(int id);

    public List<T> listarEntidades();

    public boolean actualizarEntidad(T input);

    public boolean eliminarEntidad(int id);
}
