# Swagger II - aula 4 - Chamando a operação cadastraTransacao com POSTMAN

## Video 4.2 -Chamando a operação cadastraTransacao customizada


**Customizar a operação consultaSaldo**

Injetar as classes: 
```
    @Autowired
	private TransacaoService transacaoService;

	@Autowired
	private RespostasUtil respostasUtil;
```

Alterar o conteúdo da operação consultaSaldo pelo customizado
```
try {
       return contaService.consultaSaldo(authorization, agencia, numero, digito);
    } catch (Exception e) {
       return respostasUtil.getErroInternoDouble(RespostasUtil.MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_SALDO);
}
```


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


88888888888888888888888888888888888888888888888888888888888888888888888888888888888888

Customizar a classe TransacaoApiController.java
Injetar as classes: 
            @Autowired
	private TransacaoService transacaoService;

	@Autowired
	private RespostasUtil respostasUtil;

Alterar o conteúdo da operação cadastraTransacao pelo customizado
          try {
			return transacaoService.salva(authorization, transacao, tipo);
		} catch (Exception e) {
			return respostasUtil.getErroInternoTransacao(RespostasUtil.MENSAGEM_FALHA_AO_SALVAR_TRANSACAO);
		}


Iniciar a API
Startar a API em modo debug.

Acessar a classe TransacaoApiController.java
Colocar um breakpoint na operação cadastraTransacao

Expandir a tag e a operação POST
Ver os parâmetros necessários para chamar a operação
O Authorization no HEADER
As informações da transacao no body 
O tipo de transação como parâmetro de query no path

**Cadastrar uma transação de DEPOSITO via POSTMAN**

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
 Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Lembrando que as informações sobre a conta são aqueles que guardamos após o cadastro do cliente.

Pressionar SEND.

Resposta da requisição
Transação de DEPOSITO cadastrada com sucesso, retornou 201 created!


**Cadastrar uma transação de DEBITO via POSTMAN**

- Método: POST
- URL: http://localhost:8085/bytebank-api/v1/transacao?tipo=debito
- Body: 
```
{
    "valor":23.50,
     "conta": {
		"agencia": 8756,
		"numero":4,
		"digito":0
	}
}
```
-HEADERS:
 Content-Type: application/json
 Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Pressionar SEND.

Resposta da requisição
Transação de DEBITO cadastrada com sucesso, retornou 201 created!

Agora como fazemos para ver todas as transações que cadastramos para a conta, para acompanhar a movimentação bancária?

Criando uma consulta de extrato da conta.
Veremos a seguir!
