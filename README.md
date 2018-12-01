# Swagger II - aula 2 - Configurando a API

## Video 2.2 - Testando a operação cadastraCliente customizada

***Iniciar a API***
Startar a API em modo debug.

***Acessar a documentação da API***
http://localhost:8085/bytebank-api/v1/

***Acessar a operação POST cadastraCliente***

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

*Show de bola agora sim, cliente cadastrado com sucesso!*

***Guardar as informações de cadastro do cliente***
Precisamos agora guardar as informações de retorno do cadastro do cliente onde teremos as informações do id, números de agencia, conta e dígito, necessários para as próximas operações.

```
{
  "id": 1,
  "titular": "Janete Silva",
  "cpf": "01234567890",
  "senha": null,
  "contas": [
    {
      "agencia": 8756,
      "numero": 1,
      "digito": 0,
      "saldo": 0,
      "cliente": null,
      "transacoes": null
    }
  ]
}
```