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
    private String descricao;

    @NotNull
    @ManyToOne
    private Categoria categoria;

    @NotNull
    @Positive
    private double preco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String field) {
        this.descricao = field;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
