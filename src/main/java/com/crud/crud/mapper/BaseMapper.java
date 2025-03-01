package com.crud.crud.mapper;

import java.io.Serializable;

import com.crud.crud.dto.BaseDTO;
import com.crud.crud.entity.BaseEntity;

public abstract class BaseMapper<T extends BaseEntity<ID>, D extends BaseDTO<ID>, ID extends Serializable> {
    
    public D toDTO(T entity) {
        if (entity == null) {
            return null;
        }
        D dto = createDTO();
        dto.setId(entity.getId());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setDeletedAt(entity.getDeletedAt());
        return dto;
    }
    
    public abstract T toEntity(D dto);

    protected abstract D createDTO();
}
