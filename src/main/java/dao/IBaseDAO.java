package dao;

import java.util.List;

public interface IBaseDAO<T> {

    public boolean create(T input);

    public T read(int id);

    public List<T> readall();

    public boolean update(T input);

    public boolean delete(int id);
}
