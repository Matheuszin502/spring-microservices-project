## 📖 Descrição
Este projeto se trata de uma API para uma livraria fictícia. Esta API foi projetada em microsserviços e o intuito do projeto é educativo.

### 💻 Tecnologias
- Java
- Spring Boot
- MySQL
- Swagger UI
- Docker
- Github Actions

### ⚙️ Quais operações a API suporta
A API permite acessar informações sobre livros na livraria, como título e etc, e também acessar o preço de um determinado livro em diferentes
moedas correntes.

### 🚀 Como testar a API
Clone o projeto em uma pasta de sua escolha e rode docker compose up na pasta raiz do projeto. Passo a passo mais detalhado a seguir:
Abra um terminal em alguma pasta de sua escolha e execute os seguintes comandos:

git clone https://github.com/Matheuszin502/spring-microservices-project.git

cd spring-microservices-project

docker compose up -d

Agora espere um pouco até todos os serviços iniciarem e então pode acessar os seguintes endpoints no navegador:

Eureka Server - localhost:8761 - verificar se os serviços estão online

Swagger UI - localhost:8765/swagger-ui/index.html - documentação

Book Service - localhost:8765/book-service/{id do livro, Ex: 1}/{alguma moeda corrente, Ex: BRL ou USD} - acessar dados de livros

Exchange Service - localhost:8765/exchange-service/{valor à converter, Ex: 5}/{uma moeda corrente}/{outra moeda corrente} - taxas de conversão de moedas correntes
