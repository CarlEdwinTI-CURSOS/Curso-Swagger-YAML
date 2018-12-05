# Swagger II - aula 5 - Customizando a operação consultaExtrato com POSTMAN

## Video 5.2 - Customizando a operação consultaExtrato


**Customizar a operação consultaSaldo**

Injetar as classes: 
```
    @Autowired
	private ContaService contaService;

	@Autowired
	private RespostasUtil respostasUtil;
```

Alterar o conteúdo da operação consultaSaldo pelo customizado
```
     try {
			return contaService.consultaExtrato(authorization, agencia, numero, digito);
		} catch (Exception e) {
			return respostasUtil.getErroInternoExtrato(RespostasUtil.MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_EXTRATO);
		}
```

**Iniciar a API**

Startar a API em modo debug.

**Acessar a classe ExtratoApiController.java**

Colocar um breakpoint na operação consultaExtrato


**Chamar a operação consultaExtrato via POSTMAN**
```
- Método: GET
- URL: http://localhost:8085/bytebank-api/v1/extrato/8756/4/0 

```
- HEADERS:
```
 Content-Type: application/json
 Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Lembrando que as informações sobre a conta são aqueles que guardamos após o cadastro do cliente.

Pressionar SEND.

**Resposta da requisição**

Retornou 200 - Consulta realizada com sucesso!

Agora tem um detalhe, identificamos que existe uma transação que foi cadastrada, mas queremos alterar o valor da transação.

Como podemos fazer isso?

Chamando a operação que altera o valor da transação!

Vamos lá!
