## Especificação da API
Especificação do swagger que está neste projeto.

    beer-house
    |
    |docs
    |    |___beerhouse-spec

Copie e cole o conteúdo do arquivo acima no [Swagger Editor](https://editor.swagger.io/) para visualizar a documentação da API.

## Rodando beer-house local
beer-house é uma aplicação [Spring Boot](https://spring.io/guides/gs/spring-boot) usando [Maven](https://spring.io/guides/gs/maven/). Você pode fazer um build de um jar file e rodar da linha de comando:

```
git clone https://github.com/augustoneto/beer-house.git
cd beer-house
./mvnw package
java -jar target/*.jar
```

Ou você pode rodar diretamente usanso o Spring Boot Maven plugin. 

```
./mvnw spring-boot:run
```

## Rodando beer-house local com Docker

```
git clone https://github.com/augustoneto/beer-house.git
cd beer-house
docker build --tag beerhouse-docker .
docker run -p 8080:8080 beerhouse-docker
```

Você pode acessar beer-house aqui: http://localhost:8080/beers

Dentro do repositório existe uma collection do Postman para executar alguns testes: https://github.com/augustoneto/beer-house/tree/master/postman

## Configuração da Base de Dados

A configuração default usa uma base de dados in-memory (H2) que é populada com dados no startup da aplicação.

## A aplicação contém testes unitários e testes de integração

## Trabalhando com beer-house em sua IDE

### Pré-requisito
Os sequintes itens devem estar instalados em seu sistema:
* Java 8
* git (https://help.github.com/articles/set-up-git)
* Sua IDE preferida
  * Eclipse com m2e plugin. https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

