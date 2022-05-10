/**
 * Este pacote contém as classes modelo, classes de negócio do sistema.
 * Tais classes usam a biblioteca <a href="https://quarkus.io/guides/hibernate-orm-panache">Panache ORM para Hibernate do Quarkus</a>
 * para implementar o padrão <a href="https://en.wikipedia.org/wiki/Active_record_pattern">Active Record</a>.
 * Com isto, classes modelo como {@link com.manoelcampos.model.Produto} já vão
 * possuir métodos CRUD para fazer persistência dos dados em algum database.
 *
 * <p>Desta forma, não precisamos necessariamente criar classes como DAO/Repository para fazer o acesso aos dados no banco.
 * Esta é uma forma bastante opiniosa para modelar as classes de negócio e fazer a persistência dos dados,
 * mas que é muito comum em <a href="https://guides.rubyonrails.org/active_record_basics.html">frameworks como Ruby on Rails</a>.
 * Se precisarmos criar métodos adicionais para, por exemplo, fazer uma pesquisa personalizada em uma tabela,
 * tal método pode ser implementado dentro da própria classe modelo
 * (assim como os outros métodos CRUD automaticamente fornecidos).
 * Mas se quiser separar estes métodos que você irá criar em uma classe DAO/Respository,
 * também é possível. Desta forma, conseguimos fazer uma maior separação de preocupações
 * entre a classe modelo e DAO/Repository.
 * </p>
 */
package com.manoelcampos.model;