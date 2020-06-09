package com.app.dao;

import java.util.List;

public interface GenericDao<T,K> {

    public List<T> findAll();
    public T findOne(K key);
    public T create(T entity);
    public T update(T entity);
    public void delete(T entity);
    public void deleteById(K key);
}
