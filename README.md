# Requisitos

Java 21.

Maven >= 3.8.5 

Testado com Windows 11 e Docker 29.2.1

## Instalação

Na raiz do projeto

```bash
docker build -t testejoao:1.0 .
docker run -p 8080:8080 testejoao:1.0
```

## Teste

```bash

http://localhost:8080

#Swagger
http://localhost:8080/swagger-ui/index.html
```
