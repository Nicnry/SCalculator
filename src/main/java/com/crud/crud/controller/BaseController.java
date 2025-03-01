package com.crud.crud.controller;

import com.crud.crud.dto.BaseDTO;
import com.crud.crud.entity.BaseEntity;
import com.crud.crud.service.BaseServiceImpl;
import com.crud.crud.mapper.BaseMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController<T extends BaseEntity<ID>, D extends BaseDTO<ID>, ID extends Serializable> {

    protected final BaseServiceImpl<T, D, ID> service;
    protected final BaseMapper<T, D, ID> baseMapper;

    public BaseController(BaseServiceImpl<T, D, ID> service, BaseMapper<T, D, ID> baseMapper) {
        this.service = service;
        this.baseMapper = baseMapper;
    }

    @GetMapping
    public List<D> findAll() {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable ID id) {
        return service.findById(id)
                .map(ResponseEntity::ok)  // Pas besoin de convertir en DTO
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<D> save(@RequestBody T entity) {
        D savedDto = service.save(entity);
        return ResponseEntity.ok(savedDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<D> update(@PathVariable ID id, @RequestBody T entity) {
        return service.findById(id)
                .map(existingEntity -> {
                    entity.setId(id);
                    D updatedDto = service.save(entity);
                    return ResponseEntity.ok(updatedDto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
