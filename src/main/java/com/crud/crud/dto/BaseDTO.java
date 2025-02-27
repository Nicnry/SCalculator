package com.crud.crud.dto;

import java.io.Serializable;

public abstract class BaseDTO<T extends Serializable> implements Serializable {

    private T id;

    public BaseDTO() {}

    public BaseDTO(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
