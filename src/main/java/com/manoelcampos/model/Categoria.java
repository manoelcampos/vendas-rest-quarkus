package com.manoelcampos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

/**
 * Classe modelo que implementa o padrão Active Record usando
 * a biblioteca quarkus-hibernate-orm-panache.
 *
 * @see Cliente
 */
@Entity
public class Categoria extends AbstractEntity {
    @Column(unique = true, nullable = false)
    @NotBlank
    public String titulo;

    @Column(nullable = false)
    @NotBlank
    public String descricao;
}
