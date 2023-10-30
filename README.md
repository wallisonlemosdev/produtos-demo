#Projeto ProdutosDemo

Este é um projeto de demonstração que ilustra a criação de um sistema de gerenciamento de produtos com as seguintes funcionalidades:

- Busca de produtos em uma API externa.
- Salvar produtos no banco de dados.
- Edição de produtos.
- Exclusão de produtos.
- Busca de produtos por nome.
- Listagem de todos os produtos.

O projeto foi desenvolvido em Java com o uso do framework Spring Boot e integração com o Spring Cloud Feign para acessar a API externa. O banco de dados utilizado é o PostgreSQL. Além disso, o projeto utiliza o Docker Compose para facilitar a configuração do banco de dados.

#Pré-requisitos
Antes de iniciar a instalação do projeto, verifique se você tem os seguintes requisitos instalados:

Docker
JDK (Java Development Kit) 17 ou superior

#Instalação
Siga as etapas abaixo para instalar e executar o projeto:

- Clone este repositório para o seu sistema local
- Na raiz execute o comando "docker compose up -d
- Importe o projeto em sua IDE de desenvolvimento (por exemplo, IntelliJ IDEA ou Eclipse)
- Execute, o aplicativo estará disponível em http://localhost:8181.

#Uso:
Acesse a API de produtos com as seguintes rotas:

POST /produtos/api: Realiza uma busca de produtos na API externa e salva novos produtos no banco de dados.

POST /produtos/: Salva um novo produto no banco de dados.

PUT /produtos/: Edita um produto existente com base no ID.

DELETE /produtos/: Deleta um produto com base no ID.

GET /produtos/: Lista todos os produtos no banco de dados.

GET /produtos/{nome}: Busca um produto pelo nome.

Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo LICENSE para obter mais detalhes.
