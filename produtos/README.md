# PRODUTOS

## Sobre

Este projeto é o microsserviço  responsável por fornecer a persistência de informações de um produto.

Foi construído usando **Maven**, **Spring Boot**, **Spring Data*
O banco de dados é **MySql**.

### Documentação de Referência

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.2/maven-plugin/reference/html/)

O projeto foi criado em uma estrutura em MVC (Model,View,Controller), onde temos uma requisição POST
para persistência das informações e retorno em forma de JSON.

Informações para criação da tabela no banco de dados se encontra na pasta -> /resources/db.migration

Os testes Unitários da aplicação se encontram no diretório especificado dentro do projeto.

Foi Disponibilizado uma collection POSTMAN para executação do projeto -> /resources/collection
