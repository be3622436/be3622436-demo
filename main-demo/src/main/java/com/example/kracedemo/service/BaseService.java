package com.example.kracedemo.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();

    T findById(Long id);

    Long create(T t);

    void delete(Long... ids);

    void update(T t);
}
