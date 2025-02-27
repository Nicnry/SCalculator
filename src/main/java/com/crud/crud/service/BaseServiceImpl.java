package com.crud.crud.service;

import com.crud.crud.entity.BaseEntity;
import com.crud.crud.repository.BaseRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseService<T, ID> {
    
    private final BaseRepository<T, ID> repository;

    public BaseServiceImpl(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<T> save(T entity) {
        return Optional.of(repository.save(entity));
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
