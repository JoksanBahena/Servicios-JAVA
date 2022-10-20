package mx.edu.utez.personaljbp.model;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findOne(Long id);
    boolean save(T object);
    boolean update(T object);
    boolean remove(Long id);
}
