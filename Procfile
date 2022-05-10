release: ./mvnw package -Dquarkus.package.type=uber-jar
web: export QUARKUS_DATASOURCE_JDBC_URL=$DATABASE_URL; java -jar target/*-runner.jar
