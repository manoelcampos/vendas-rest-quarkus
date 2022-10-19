package com.manoelcampos.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Classe modelo que implementa o padrão Active Record usando
 * a biblioteca quarkus-hibernate-orm-panache.
 *
 * <p>Perceba que os atributos foram estranhamento definidos como públicos.
 * Tal biblioteca faz manipulação de bytecode, adicionando mágica
 * que faz com que, ao acessar/alterar um atributo, o respectivo getter/setter
 * seja chamado automaticamente.</p>
 */
@Entity
public class Cliente extends AbstractEntity {
    @NotNull @NotBlank
    public String nome;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    public String email;

    @NotBlank
    @CPF
    @Column(unique = true, nullable = false)
    public String cpf;
}
