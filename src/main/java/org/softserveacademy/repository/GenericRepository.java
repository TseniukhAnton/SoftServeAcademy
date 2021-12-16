package org.softserveacademy.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    T getById(ID id);

    T deleteById(ID id);

    T update(T t);

    T save(T t);

    List<T> getAll();

}
