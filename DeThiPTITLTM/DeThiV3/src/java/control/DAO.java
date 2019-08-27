package control;

import java.util.List;

public interface DAO<T> {

    T findById(String id);

    List<T> findAll();

    void save(T hh);

    void update(T hh);

    void delete(T id);

}
