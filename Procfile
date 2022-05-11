release: ./mvnw package -Dquarkus.package.type=uber-jar
web: pwd; find target/*.jar; export QUARKUS_DATASOURCE_JDBC_URL=$DATABASE_URL; java -jar target/vendas-rest-quarkus*-runner.jar
