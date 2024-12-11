# Make4Us - Backend

Bem-vindo ao repositório do backend do **Make4Us**, a plataforma inovadora que conecta modelos e maquiadoras, facilitando a marcação de trabalhos de forma simples, rápida e eficiente.

## Sobre o Make4Us
O Make4Us é uma startup que visa revolucionar a forma como profissionais de moda e beleza se conectam. Nosso objetivo é criar um ambiente prático onde:

- **Modelos** possam encontrar maquiadoras disponíveis e agendar serviços facilmente.
- **Maquiadoras** possam gerenciar sua agenda e expandir sua rede de clientes.

Este repositório contém o código-fonte do backend que sustenta a aplicação, garantindo segurança, escalabilidade e desempenho.

## Tecnologias Utilizadas

- **Linguagem de Programação:** Java com Spring Boot
- **Banco de Dados:** MySQL
- **Gerenciamento de Dependências:** Gradle
- **APIs:** RESTful
- **Autenticação e Autorização:** Spring Security com JWT
- **Hospedagem:** Docker para ambiente de desenvolvimento

## Funcionalidades

- Gerenciamento de usuários (cadastro e login de modelos e maquiadoras)
- Criação e gerenciamento de agendas de maquiadoras
- Busca e filtragem de profissionais por localização e disponibilidade
- Sistema de notificações para marcações e confirmações

## Como Rodar Localmente

### Pré-requisitos
Certifique-se de ter instalado:

- JDK 23
- Docker e Docker Compose
- MySQL ou outra solução compatível para banco de dados

### Passos para Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/suarepositorio/make4us-backend.git
   cd make4us-backend
   ```

2. Configure o arquivo `application.properties` ou `application.yml` com as credenciais do banco de dados:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/make4us
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Inicie o ambiente com Docker:
   ```bash
   docker-compose up
   ```

4. Rode a aplicação:
   ```bash
   mvn spring-boot:run
   ```

A aplicação estará disponível em `http://localhost:8080`.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir _issues_ ou enviar _pull requests_. Consulte o arquivo [CONTRIBUTING.md](CONTRIBUTING.md) para mais detalhes.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais informações.

---

Esperamos que o Make4Us ajude a conectar pessoas e oportunidades! 🚀
