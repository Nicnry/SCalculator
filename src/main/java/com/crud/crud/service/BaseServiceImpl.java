package com.crud.crud.service;

import com.crud.crud.dto.BaseDTO;
import com.crud.crud.entity.BaseEntity;
import com.crud.crud.mapper.BaseMapper;
import com.crud.crud.repository.BaseRepository;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

public class BaseServiceImpl<T extends BaseEntity<ID>, D extends BaseDTO<ID>, ID extends Serializable> implements BaseService<T, D, ID> {

    protected final BaseRepository<T, ID> repository;
    protected final BaseMapper<T, D, ID> baseMapper;

    public BaseServiceImpl(BaseRepository<T, ID> repository, BaseMapper<T, D, ID> baseMapper) {
        this.repository = repository;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<D> findAll() {
        List<T> entities = repository.findAll();
        return entities.stream()
                .map(baseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<D> findById(ID id) {
        Optional<T> entity = repository.findById(id);
        return entity.map(baseMapper::toDTO);
    }

    @Override
    public D save(T entity) {
        T savedEntity = repository.save(entity);
        return baseMapper.toDTO(savedEntity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
