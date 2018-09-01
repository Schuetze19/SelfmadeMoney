package com.example.dennis.selfmademoney.dao;

import java.util.List;

public interface IRepository<T> {

    T save(T model);
    T update(T model);
    T delete(T model);
    T findById(long id);
    List<T> findAll();
}
