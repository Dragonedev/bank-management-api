# Bank Management API

API REST desenvolvida com Spring Boot para gerenciamento de contas bancárias, titulares e informações de contato.

## Objetivo

Este projeto tem como objetivo praticar conceitos de desenvolvimento Back-End utilizando Java e Spring Boot, aplicando:

* Arquitetura em camadas
* APIs REST
* Persistência de dados com JPA/Hibernate
* Relacionamentos entre entidades
* Validações
* Tratamento de exceções
* Boas práticas de desenvolvimento

---

## Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Bean Validation

---

## Modelo de Dados

### Account Holder

Representa o titular da conta bancária.

| Campo | Tipo    |
| ----- | ------- |
| id    | Integer |
| name  | String  |
| cpf   | String  |

### Contact

Informações de contato do titular.

| Campo       | Tipo    |
| ----------- | ------- |
| id          | Integer |
| email       | String  |
| phoneNumber | String  |

### Account

Representa a conta bancária.

| Campo       | Tipo       |
| ----------- | ---------- |
| id          | Integer    |
| balance     | BigDecimal |
| accountType | Enum       |

---

## Relacionamentos

* Um titular possui um contato (**1:1**)
* Um titular pode possuir várias contas (**1:N**)
* Cada conta pertence a um único titular (**N:1**)

```text
AccountHolder
 ├── Contact (1:1)
 └── Account (1:N)
```

---

## Funcionalidades Implementadas

### Titulares

* Criar titular
* Buscar titular por ID
* Listar titulares
* Atualizar titular
* Remover titular

### Contatos

* Cadastro de informações de contato vinculadas ao titular

### Contas

* Criar conta bancária
* Buscar conta por ID
* Listar contas
* Atualizar conta
* Remover conta

---

## Validações

A aplicação realiza validações para garantir a integridade dos dados:

* CPF obrigatório
* Nome obrigatório
* Titular deve existir antes da criação da conta
* Dados de contato obrigatórios
* Tratamento de erros através de exceções personalizadas

---

## Estrutura do Projeto

```text
src
├── controller
├── service
├── repository
├── dto
├── database
│   └── model
├── exception
├── handler
└── enums
```

---

## Aprendizados

Durante o desenvolvimento deste projeto foram praticados conceitos importantes como:

* Mapeamento de entidades com JPA
* Relacionamentos OneToOne e OneToMany
* Injeção de dependência
* DTOs
* Transações com @Transactional
* Tratamento global de exceções
* Desenvolvimento de APIs REST utilizando Spring Boot

---

## Autor

Projeto desenvolvido para fins de estudo e prática de Java, Spring Boot e desenvolvimento Back-End.
