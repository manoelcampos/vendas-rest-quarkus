package com.manoelcampos.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria extends PanacheEntity {
    @Column(unique = true, nullable = false)
    @NotBlank
    public String descricao;
}
