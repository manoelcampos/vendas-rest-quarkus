package com.manoelcampos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Classe modelo que implementa o padrão Active Record usando
 * a biblioteca quarkus-hibernate-orm-panache.
 *
 * @see Cliente
 */
@Entity
public class Produto extends AbstractEntity {
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
