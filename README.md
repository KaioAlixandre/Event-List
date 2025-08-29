# 📋 EventList App

Este é um projeto full-stack para gerenciar eventos pessoais, permitindo que usuários criem, visualizem, editem e excluam eventos em uma interface simples e amigável. A aplicação é composta por um backend robusto em Java com Spring Boot e um frontend interativo em HTML, CSS (Tailwind CSS) e JavaScript.

---

## 💻 Tecnologias Utilizadas

### 🖥️ Backend
- [x] Java 17
- [x] Spring Boot
- [x] Spring Security
- [x] JWT (JSON Web Token)
- [x] JPA (Java Persistence API)
- [x] MySQL
- [x] Maven 

### 🎨 Frontend
- [x] HTML5
- [x] TailwindCSS
- [x] JavaScript

### 🏗️ Arquitetura
O projeto segue uma arquitetura modular com o backend e o frontend separados.
- [x] Backend: Uma API REST que expõe endpoints para autenticação e manipulação de eventos. A segurança é gerenciada por um filtro JWT que valida o token em cada requisição.
- [x] Frontend: Uma Single Page Application (SPA) que se comunica com o backend via requisições assíncronas (fetch API) para criar, ler, atualizar e deletar eventos. A navegação entre as páginas é feita diretamente no JavaScript.


---

## ✅ Funcionalidades

- [x] Cadastro de Usuário
- [x] Login
- [x] Criação de Evento
- [x] Listagem de Eventos
- [x] Contagem Regressiva
- [x] Edição de Evento
- [x] Exclusão de Evento
- [x] Navegação Segura

---

### ✅ Pré-requisitos

- [x] Java Development Kit (JDK) 17 ou superior
- [x] Maven
- [x] Um editor de código (como VS Code ou IntelliJ IDEA) 

---

### 💻 Como Executar o Projeto

1. Clone o repositório:

```bash
git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
cd seu-repositorio
```
2. Configurar e Executar o Backend
 1. Abra o projeto no seu editor de código preferido.

 2. Navegue até o arquivo application.properties (ou application.yml) e configure a conexão com seu banco de dados, se não for usar o H2 embutido.

 3. Abra o terminal na pasta raiz do projeto backend e execute o comando Maven para rodar a aplicação:

```bash
mvn spring-boot:run
```
- A aplicação estará disponível em http://localhost:8080.

3. Executar o Frontend

O frontend é composto por arquivos HTML, CSS e JavaScript estáticos.

Você pode abrir os arquivos diretamente no seu navegador, mas é recomendado usar uma extensão de servidor local no seu editor (como "Live Server" no VS Code) para evitar erros de CORS.

Abra o arquivo login.html no seu navegador.

4. Usando a Aplicação

- Login: http://localhost:8080/login.html

- Cadastro: http://localhost:8080/cadastro.html

Após fazer o login, você será redirecionado para a lista de eventos.

---
