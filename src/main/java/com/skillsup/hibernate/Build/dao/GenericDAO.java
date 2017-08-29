package com.skillsup.hibernate.Build.dao;

import java.util.List;

public interface GenericDAO<E> {

    public E save(E entity, Long id);
    public void update(E entity, Long id);
    public void delete(E entity, Long id);
    E findById(Class<E> cls, Long id);
    public List<E> findAll(Class<E> cls);


}
