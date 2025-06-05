# 💰 Sistema Financeiro - CRUD em Spring Boot

Projeto desenvolvido como parte de atividade acadêmica para a faculdade, com o objetivo de praticar e consolidar conhecimentos em **desenvolvimento de APIs REST** utilizando **Spring Boot**. O sistema simula uma aplicação de controle financeiro, permitindo o cadastro, consulta, atualização e exclusão de lançamentos financeiros, categorias e pessoas.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database (ou outro, conforme configurado)
- Maven
- Lombok
- Bean Validation (Jakarta Validation)

---

## 📝 Funcionalidades

✅ CRUD de Categorias  
✅ CRUD de Pessoas  
✅ CRUD de Lançamentos (Entradas e Saídas financeiras)  
✅ Tratamento de exceções com retorno adequado de erros  
✅ Validações de dados com annotations do Bean Validation  
✅ Uso de DTOs (Data Transfer Object)  
✅ Separação de responsabilidades: Controller, Service e Repository  

---


---

## 🛠️ Como executar o projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/joaolira-dev/sistema-financeiro.git
cd sistema-financeiro
Abra o projeto em sua IDE (IntelliJ, Eclipse, VS Code com extensões Java).
````
Configure o banco de dados:
Por padrão o projeto pode usar H2 (em memória).
Altere application.properties caso deseje usar outro banco (MySQL, PostgreSQL etc).
Execute a aplicação "Api.java"

Para Testar a API:
Use ferramentas como Postman ou Insomnia para realizar requisições HTTP para as rotas:

