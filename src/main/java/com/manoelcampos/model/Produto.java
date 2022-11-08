package com.manoelcampos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
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
    /**
     * Adiciona uma coluna version para criar um Lock Otimista e tentar
     * evitar alterações simultâneas de um mesmo registro.
     * Isto pode fazer um usuário sobrescrever dados de outro usuário.
     * Define default 0 pois em modo dev, estamos usando um script para inserir
     * dados no banco, que não possui a coluna version.
     */
    @Version
    @Column(columnDefinition = "int default 0")
    public Long version = 0L;

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
