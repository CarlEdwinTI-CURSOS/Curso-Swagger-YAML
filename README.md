# Swagger II - aula 7 - Customizando a operação excluiTransacao com POSTMAN

## Video 7.1 - Testando a operação excluiTransacao
 
**Iniciar a API**

Startar a API em modo debug.

**Acessar a classe TransacaoApiController.java**

Colocar um breakpoint na operação excluiTransacao

**Acessar a documentação interativa**

http://localhost:8085/bytebank-api/v1/swagger-ui.html 

**Expandir a tag e a operação DELETE**

Ver os parâmetros necessários para chamar a operação

- O código da Transação no path
- O Authorization no HEADER

**Consultar extrato para pegar o codigo de alguma transação existente no POSTMAN**

```
Método: GET
URL: http://localhost:8085/bytebank-api/v1/extrato/8756/4/0 
HEADERS:
 - Content-Type: application/json
 - Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Pressionar SEND.

**Criar nova request no POSTMAN**

- Método: DELETE
- URL: http://localhost:8085/bytebank-api/v1/transacao/2

- HEADERS:
```
Content-Type: application/json
 Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Pressionar SEND.

**Resposta da requisição**

Retornou o esperado 501 Not Implemented!

A seguir vamos resolver isso customizando essa operação.
Até já!
