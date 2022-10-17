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
    String descricao;

    @NotNull
    @ManyToOne
    Categoria categoria;

    @NotNull
    @Positive
    double preco;
}
