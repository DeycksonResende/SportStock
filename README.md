# Projeto Produtos Esportivos - Spring Boot

Este projeto tem como objetivo criar uma aplicação Spring Boot para uma empresa de produtos esportivos. A aplicação realiza as operações CRUD (Create, Read, Update e Delete) em um banco de dados H2, utilizando as dependências **Spring Boot**, **Lombok**, **HATEOAS** e **JPA** com **Hibernate**. 

## Tecnologias Utilizadas
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database (em memória)**
- **Lombok**
- **HATEOAS**
- **Maven**
- **Postman** (para testes de API)

## Descrição

A aplicação permite o gerenciamento de produtos esportivos. Os produtos têm os seguintes atributos:
- **Nome**: Nome do produto
- **Tipo**: Tipo do produto (ex: Roupas, Equipamentos)
- **Classificação**: Classificação do produto (ex: Esportivo, Casual)
- **Tamanho**: Tamanho do produto (ex: M, L, XL)
- **Preço**: Preço do produto

O sistema oferece os seguintes endpoints para realizar operações CRUD:
- **POST** `/produtos` para adicionar um novo produto
- **GET** `/produtos` para listar todos os produtos
- **GET** `/produtos/{id}` para buscar um produto específico pelo ID
- **PUT** `/produtos/{id}` para atualizar um produto existente
- **DELETE** `/produtos/{id}` para excluir um produto

## Como Rodar o Projeto

### Requisitos

- **Java 17 ou superior**
- **Maven**
- **Postman** (para testar as APIs)

### Passos para Executar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seuusuario/produtos-esportivos.git
