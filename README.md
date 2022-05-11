# Projeto de API REST Vendas usando o framework Quarkus [![maven](https://github.com/manoelcampos/vendas-rest-quarkus/actions/workflows/maven.yml/badge.svg)](https://github.com/manoelcampos/vendas-rest-quarkus/actions/workflows/maven.yml)

Este projeto usa o Quarkus, o _**Supersonic Subatomic Java Framework**_. A estrutura inicial deste projeto foi gerada em https://code.quarkus.io. Mas se você usa o IntelliJ IDEA Ultimate, ele já tem suporte nativo criar e executar projetos Quarkus. No IntelliJ Community, você pode instalar o [plugin do Quarkus](https://plugins.jetbrains.com/plugin/13234-quarkus-tools). O Visual Studio Code possui uma [extensão para Quarkus](https://marketplace.visualstudio.com/items?itemName=redhat.vscode-quarkus) também.  

Se você quer aprender mais sobre Quarkus, visite https://quarkus.io.

## Configurando a aplicação para execução

Antes de rodar a aplicação você deve abrir o arquivo e verificar
se as configurações no arquivo [application.properties](src/main/resources/application.properties) estão corretas para o seu ambiente de desenvolvimento (como o tipo de BD usado).

Informações sensíveis como nome de usuário e senha (do servidor de BD, por exemplo), devem ser informadas em um arquivo `.env`. Para isto, faça uma cópia do arquivo [.env.dist](.env.dist), renomeando para `.env` e edite tais informações neste arquivo.

## Executando a aplicação no mode de desenvolvimento

Você pode rodar sua aplicação no mode dev, que habilita o _live coding_ usando os scripts `mvnw` na raiz do projeto, de acordo com o seu SO.

O _live coding_ é também conhecido como _hot reload_. Normalmente basta salvar as alterações no seu projeto e o Quarkus irá detectar as alterações, compilar e recarregar à aplicação. Tudo isso normalmente em uma fração de segundo.

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Linux/macOS

```shell script
./mvnw compile quarkus:dev
```

Se der problema de permissão para execução do script, atribua tal permissão com: 

```shell script
chmod +x ./mvnw
```

## Windows

```shell script
mvnw.cmd compile quarkus:dev
```

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
- [Getting Started on Heroku with Java](https://devcenter.heroku.com/articles/getting-started-with-java).

## Hospedando a aplicação no Heroku

O Heroku permite integração com o GitHub para quando um push foi feito para tal repositório e a aplicação for compilada com sucesso, ele ser implantada/atualizada automaticamente no Heroku. Para isto funcionar, é preciso habilitar a integração com o GitHub na sua aplicação no Heroku.

Se a configuração não for feita para a implantação ser feita automaticamente, você pode ver [como fazer isto manualmente aqui](https://devcenter.heroku.com/articles/git). Depois de configurar seu repositório como indicado acima, para fazer a implentação (deploy) do app, basta executar:

```shell script
git push heroku main
```

Onde `main` é o nome do branch com a versão do app que deseja implantar. Este nome pode ser `main` dependendo de como criou o repositório git.