package com.example.dennis.selfmademoney.dao;

import java.util.List;

public interface IRepository<T> {

    T save(T model);
    T update(T model);
    T delete(T model);

    /**
     * @param id id des Models
     * @return Genau 10 Models
     */
    T findById(long id);

    /**
     * @return Genau 10 Models
     */
    List<T> findAll();
}
