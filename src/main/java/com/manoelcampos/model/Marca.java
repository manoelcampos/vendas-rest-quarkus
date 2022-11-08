package com.manoelcampos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

/**
 * Classe modelo que implementa o padrão Active Record usando
 * a biblioteca quarkus-hibernate-orm-panache.
 *
 * <p>Mostra como criar métodos adicionais para fazer operações CRUD personalizadas,
 * como uma busca por um campo específico.</p>
 *
 * @see Cliente
 */
@Entity
public class Marca extends AbstractEntity {
    @Column(unique = true, nullable = false)
    @NotBlank
    public String nome;

    public static Optional<Marca> findByName(final String nome){
        return Marca.<Marca>find("nome", nome).firstResultOptional();
    }
}
