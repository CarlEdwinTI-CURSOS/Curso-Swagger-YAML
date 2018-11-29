# Swagger II - aula 1 - xxxxx

## Video 1.2 - Chamando a operaçao cadastraCliente
- Chamar a operação de cadastro de cliente via Swagger UI

alterar nome da pasta  do projeto

***swagger-spring*** **>>>** ***alura-bytebank-api*** 

.pom
```
<artifactId>alura-bytebank-api</artifactId>
<name>alura-bytebank-api</name>
```
Iniciar a API
Startar a API em modo debug.

Acessar a operação POST cadastraCliente

[http://localhost:8085/bytebank-api/v1/swagger-ui.html#!/Cliente/cadastraCliente](http://localhost:8085/bytebank-api/v1/swagger-ui.html#!/Cliente/cadastraCliente)

Acessar a classe **ClienteApiController.java**
Colocar um breakpoint na operação cadastraCliente
Analisar a operação quando estiver sendo chamada

Chamar a operação de cadastro a partir da documentação interativa
Preencher as informações de cliente no **body**.
```
{
  "cpf": "01234567890",
  "senha": "senha123",
  "titular": "Janete Silva"
}
```

Chamar a operação pressionando o botão **TRY IT OUT**
debugar e explicar o retorno 

*Não queremos uma resposta padrão, na verdade queremos realmente cadastrar um cliente e como fazemos isso?*
