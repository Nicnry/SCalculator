package com.crud.crud.service;

import com.crud.crud.entity.BaseEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {
    List<T> findAll();
    Optional<T> findById(ID id);
    Optional<T> save(T entity);
    void deleteById(ID id);
}
