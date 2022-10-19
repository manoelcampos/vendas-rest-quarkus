package com.manoelcampos.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Classe abstrata definindo nossa própria política de geração
 * de valores de chaves primárias para nossas entidades.
 * Se você deseja usar o padrão definido pelo Panache,
 * não precisamos desta classe abstrata.
 * Basta fazer suas entidades extenderem {@link io.quarkus.hibernate.orm.panache.PanacheEntity}.
 */
@MappedSuperclass
public abstract class AbstractEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
}
