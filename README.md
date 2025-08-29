EventList App
Este é um projeto full-stack para gerenciar eventos pessoais, permitindo que usuários criem, visualizem, editem e excluam eventos em uma interface simples e amigável. A aplicação é composta por um backend robusto em Java com Spring Boot e um frontend interativo em HTML, CSS (Tailwind CSS) e JavaScript.

🚀 Funcionalidades
Cadastro de Usuário: Crie uma nova conta com nome de usuário e senha.

Login: Autentique-se com suas credenciais para acessar a aplicação.

Criação de Evento: Crie um novo evento com um nome e uma data final.

Listagem de Eventos: Visualize todos os seus eventos em uma lista.

Contagem Regressiva: Acompanhe em tempo real quantos dias, horas e minutos faltam para cada evento.

Edição de Evento: Altere o nome ou a data de um evento existente.

Exclusão de Evento: Remova um evento da sua lista.

Navegação Segura: As rotas são protegidas por um filtro de autenticação JWT, garantindo que apenas usuários logados possam gerenciar seus eventos.

💻 Tecnologias Utilizadas
Backend
Java 17: Linguagem de programação.

Spring Boot: Framework para criação da API REST.

Spring Security: Gerenciamento de segurança e autenticação.

JWT (JSON Web Token): Criação de tokens de acesso stateless.

JPA (Java Persistence API): Mapeamento Objeto-Relacional para interagir com o banco de dados.

H2 Database (ou MySQL/PostgreSQL): Banco de dados em memória para desenvolvimento (pode ser configurado para outros).

Maven: Gerenciamento de dependências.

Frontend
HTML5: Estrutura da página.

JavaScript: Lógica de interação com a API e manipulação da DOM.

Tailwind CSS: Framework utilitário para estilização rápida e responsiva.

🏗️ Arquitetura
O projeto segue uma arquitetura modular com o backend e o frontend separados.

Backend: Uma API REST que expõe endpoints para autenticação e manipulação de eventos. A segurança é gerenciada por um filtro JWT que valida o token em cada requisição.

Frontend: Uma Single Page Application (SPA) que se comunica com o backend via requisições assíncronas (fetch API) para criar, ler, atualizar e deletar eventos. A navegação entre as páginas é feita diretamente no JavaScript.

⚙️ Como Executar o Projeto
Siga os passos abaixo para rodar a aplicação em sua máquina local.

Pré-requisitos
Java Development Kit (JDK) 17 ou superior.

Maven.

Um editor de código (como VS Code ou IntelliJ IDEA).

1. Clonar o Repositório
Clone este repositório para a sua máquina:

git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
cd seu-repositorio

2. Configurar e Executar o Backend
Abra o projeto no seu editor de código preferido.

Navegue até o arquivo application.properties (ou application.yml) e configure a conexão com seu banco de dados, se não for usar o H2 embutido.

Abra o terminal na pasta raiz do projeto backend e execute o comando Maven para rodar a aplicação:

mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080.

3. Executar o Frontend
O frontend é composto por arquivos HTML, CSS e JavaScript estáticos.

Você pode abrir os arquivos diretamente no seu navegador, mas é recomendado usar uma extensão de servidor local no seu editor (como "Live Server" no VS Code) para evitar erros de CORS.

Abra o arquivo login.html no seu navegador.

4. Usando a Aplicação
Login: http://localhost:8080/login.html

Cadastro: http://localhost:8080/cadastro.html

Após fazer o login, você será redirecionado para a lista de eventos.

🤝 Contribuição
Contribuições são bem-vindas! Se você tiver alguma sugestão de melhoria ou encontrar algum problema, sinta-se à vontade para abrir uma issue ou enviar um pull request.
