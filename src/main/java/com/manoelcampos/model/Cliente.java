package com.manoelcampos.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

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

    @NotNull @NotBlank
    public String cidade;

    @NotNull @NotBlank
    public char sexo;

    /**
     * A biblioteca Panache inclui getters e setters durante o processo de compilação.
     * No entanto, somos livres para adicionar tais métodos com nossas próprias implementações
     * quando precisarmos. Este é um exemplo disso,
     * que valida o título passado, removendo espaços e convertendo para maiúsculas.
     *
     * <p>Mesmo que os atributos sejam públicos e assim podermos fazer
     * algo como cliente.email = "   MANOEL@EMAIL.COM   ";
     * ao compilar, tal instrução é substituída para cliente.setEmail("   MANOEL@EMAIL.COM   ").
     * Para confirmar isso, basta executar a 1a instrução que verá que os espaços
     * serão removidos e o email convertido para minúsculas, provando que a chamada do setter foi feita
     * automaticamente.
     * </p>
     *
     * @param email
     */
    public void setEmail(final String email) {
        this.email = requireNonNull(email).trim().toLowerCase();
    }

    public void setSexo(char sexo) {
        sexo = Character.toUpperCase(sexo);
        if(sexo != 'M' && sexo != 'F')
            throw new IllegalArgumentException("Sexo deve ser M ou F");

        this.sexo = sexo;
    }

    public static Optional<Cliente> findByName(String name){
        return Cliente.<Cliente>find("name", name)
                      .stream()
                      .findFirst();
    }
}
