package com.crud.crud.service;

import com.crud.crud.entity.BaseEntity;
import com.crud.crud.dto.BaseDTO;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>, D extends BaseDTO<ID>, ID extends Serializable> {
    List<D> findAll();
    Optional<D> findDTOById(ID id);
    Optional<T> findById(ID id);
    D save(T entity);
    void deleteById(ID id);
}
