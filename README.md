# Projeto ProdutosDemo

Este é um projeto de demonstração que ilustra a criação de um sistema de gerenciamento de produtos com as seguintes funcionalidades:

- Busca de produtos em uma API externa.
- Salvamento de produtos no banco de dados.
- Edição de produtos.
- Exclusão de produtos.
- Busca de produtos por nome.
- Listagem de todos os produtos.

O projeto foi desenvolvido em **Java** com o uso do framework **Spring Boot** e integração com **Spring Cloud Feign** para acessar a API externa. O banco de dados utilizado é o **PostgreSQL**. Além disso, o projeto utiliza **Docker Compose** para facilitar a configuração do banco de dados.

## Pré-requisitos

Antes de iniciar a instalação do projeto, verifique se você tem os seguintes requisitos instalados:

- **Docker**
- **JDK (Java Development Kit) 17 ou superior**

## Instalação

Siga as etapas abaixo para instalar e executar o projeto:

1. Clone este repositório para o seu sistema local:
   ```sh
   git clone https://github.com/seu-repositorio/produtos-demo.git
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd produtos-demo
   ```
3. Execute o seguinte comando para iniciar o banco de dados via Docker:
   ```sh
   docker compose up -d
   ```
4. Importe o projeto em sua IDE de desenvolvimento (por exemplo, **IntelliJ IDEA** ou **Eclipse**).
5. Execute o projeto.
6. O aplicativo estará disponível em: [http://localhost:8181](http://localhost:8181).

## Uso

Acesse a API de produtos com as seguintes rotas:

### Criar e buscar produtos
- **`POST /produtos/api`**: Realiza uma busca de produtos na API externa e salva novos produtos no banco de dados.
- **`POST /produtos/`**: Salva um novo produto no banco de dados.

### Editar e excluir produtos
- **`PUT /produtos/{id}`**: Edita um produto existente com base no ID.
- **`DELETE /produtos/{id}`**: Deleta um produto com base no ID.

### Listagem e busca
- **`GET /produtos/`**: Lista todos os produtos no banco de dados.
- **`GET /produtos/{nome}`**: Busca um produto pelo nome.
