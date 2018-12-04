# Swagger II - aula 4 - Chamando a operação cadastraTransacao com POSTMAN

## Video 4.1 -Testando a operação cadastraTransacao


**Iniciar a API**

Startar a API em modo debug.

**Acessar a classe TransacaoApiController.java**

Colocar um breakpoint na operação cadastraTransacao

**Acessar a documentação interativa**

http://localhost:8085/bytebank-api/v1/swagger-ui.html 

**Expandir a tag e a operação POST**

Ver os parâmetros necessários para chamar a operação

- O Authorization no HEADER
- As informações da transacao no body 
- O tipo de transação como parâmetro de query no path

**Criar nova request no POSTMAN**

- Método: POST
- URL: http://localhost:8085/bytebank-api/v1/transacao?tipo=deposito
- Body:
```
{
	"valor":134.67,
	"conta": {
		"agencia": 8756,
		"numero":4,
		"digito":0
	}
}
```
- HEADERS:
```
 Content-Type: application/json
 Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Lembrando que as informações sobre a conta são aqueles que guardamos após o cadastro do cliente.

Pressionar SEND.

**Resposta da requisição**

Retornou o esperado 501 Not Implemented!

A seguir vamos resolver isso customizando essa transação.
Até já!
