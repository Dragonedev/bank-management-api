# Bank Management API

API REST desenvolvida com Spring Boot para gerenciamento de contas bancárias, titulares e informações de contato.

## Objetivo

Este projeto tem como objetivo praticar conceitos de desenvolvimento Back-End utilizando Java e Spring Boot, aplicando:

- Arquitetura em camadas
- APIs REST
- Persistência de dados com JPA/Hibernate
- Relacionamentos entre entidades
- Validações
- Boas práticas de desenvolvimento

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Bean Validation

---

## Modelo de Dados

### Account Holder

Representa o titular da conta bancária.

| Campo | Tipo |
|---------|---------|
| id | Integer |
| name | String |
| cpf | String |

### Contact

Informações de contato do titular.

| Campo | Tipo |
|---------|---------|
| id | Integer |
| email | String |
| phoneNumber | String |

### Account

Representa a conta bancária.

| Campo | Tipo |
|---------|---------|
| id | Integer |
| balance | BigDecimal |
| accountType | Enum |

---

## Relacionamentos

- Um titular possui uma conta (1:1)
- Um titular possui um contato (1:1)

```text
AccountHolder
 ├── Contact
 └── Account
