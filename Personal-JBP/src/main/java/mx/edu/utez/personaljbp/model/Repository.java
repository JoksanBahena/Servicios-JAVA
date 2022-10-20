package mx.edu.utez.personaljbp.model;

import mx.edu.utez.personaljbp.utils.Response;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    T findOne(Long id);
    Response<T> save(T object);
    Response<T> update(T object);
    Response<T> remove(Long id);
}
