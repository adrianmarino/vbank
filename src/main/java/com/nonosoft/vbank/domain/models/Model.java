package com.nonosoft.vbank.domain.models;

import javax.persistence.*;

@MappedSuperclass
public abstract class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    protected Long id;

    public Long getId() {
        return id;
    }
}