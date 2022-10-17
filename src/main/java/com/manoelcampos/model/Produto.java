package com.manoelcampos.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Produto extends PanacheEntity {
    @Column(unique = true, nullable = false)
    @NotBlank
    public String descricao;

    @NotNull
    @ManyToOne
    public Categoria categoria;

    @NotNull
    @Positive
    public double preco;
}
