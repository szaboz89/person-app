package com.szabodev.person.dao;

import java.util.List;

interface AbstractDAO<T> {

    Integer save(final T o);

    void delete(final Object object);

    T get(final Integer id);

    T merge(T o);

    void saveOrUpdate(T o);

    List<T> getAll();
}
