# Projeto de API REST Vendas usando o framework Quarkus

Este projeto usa o Quarkus, o _**Supersonic Subatomic Java Framework**_. A estrutura inicial deste projeto foi gerada em https://code.quarkus.io. Mas se você usa o IntelliJ IDEA Ultimate, ele já tem suporte nativo criar e executar projetos Quarkus. No IntelliJ Community, você pode instalar o [plugin do Quarkus](https://plugins.jetbrains.com/plugin/13234-quarkus-tools). O Visual Studio Code possui uma [extensão para Quarkus](https://marketplace.visualstudio.com/items?itemName=redhat.vscode-quarkus) também.  

Se você quer aprender mais sobre Quarkus, visite https://quarkus.io.

## Executando a aplicação no mode de desenvolvimento

Você pode rodar sua aplicação no mode dev, que habilita o _live coding_, usando;

```shell script
./mvnw compile quarkus:dev
```

O _live coding_ é também conhecido como _hot reload_. Normalmente basta salvar as alterações no seu projeto e o Quarkus irá detectar as alterações, compilar e recarregar à aplicação. Tudo isso normalmente em uma fração de segundo.

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.


## Testando os serviços REST usando extensões dos navegadores

Você pode utilizar o próprio navegador para testar seus endpoints REST. Assim, você terá uma interface amigável e intuitiva, facilitando muito os testes. A seguir são exibidas opções para Firefox e Chrome.

- Para o Firefox você pode baixar o plugin https://addons.mozilla.org/pt-BR/firefox/addon/restclient/[RESTClient].
- Para o Google Chrome utilizo a excelente extensão https://chrome.google.com/webstore/detail/restlet-client-rest-api-t/aejoelaoggembcahagimdiliamlcdmfm/[Talend API Tester (antigo Restlet Client)].

A extensão _Talend API Tester_ tem um recurso extremamente útil de permitir criar projetos e salvar diferentes requisições HTTP dentro deste projeto. Assim, podemos facilmente reenviar tais requisições sem ter que configurá-las novamente.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/vendas-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- REST resources for Hibernate ORM with Panache ([guide](https://quarkus.io/guides/rest-data-panache)): Generate JAX-RS resources for your Hibernate Panache entities and repositories
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and JPA
- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, JPA)
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A JAX-RS implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- Agroal - Database connection pool ([guide](https://quarkus.io/guides/datasource)): Pool JDBC database connections (included in Hibernate ORM)

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
