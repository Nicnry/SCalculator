package com.crud.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dummy_entity")
public class DummyEntity extends BaseEntity<Long> {
    // Necessary for JPA to work
}
