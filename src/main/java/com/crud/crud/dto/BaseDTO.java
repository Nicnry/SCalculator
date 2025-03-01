package com.crud.crud.dto;

import java.io.Serializable;

public abstract class BaseDTO<T extends Serializable> {
    private T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
