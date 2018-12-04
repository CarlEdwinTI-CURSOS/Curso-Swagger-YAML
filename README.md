# Swagger II - aula 3 - Chamando as operações com POSTMAN

## Video 3.3 -Customizando a operação consultaSaldo

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
                      return contaService.consultaSaldo(authorization, agencia, numero, digito);
              } catch (Exception e) {
return respostasUtil.getErroInternoDouble(RespostasUtil.MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_SALDO);
}
```

**Iniciar a API**
Startar a API em modo debug.

**Acessar a classe ContaApiController.java**
Colocar um breakpoint na operação consultaSaldo

**POSTMAN REQUEST**
1- Preencher Authorization na aba Authorization
```
Type: Basic Auth
Username: 01234567830, Password: senha123
```

2- Pressionar Update Request

3- Preencher a request
```
URL: http://localhost:8085/bytebank-api/v1/conta/8756/4/0/saldo
Authorization: Username: 01234567830, Password: senha123
Header: Content-Type: application/json
Header: Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

4- Pressionar SEND

**Resposta 200 OK **
A requisição chamou a operação e retornou o saldo da conta real do cliente, que por enquanto é 0.

Agora precisamos conseguir fazer um depósito na conta do cliente para que ele fique com saldo em conta. 
Para isso vamos usar a operação cadastraTransacao para criar um depósito.

Até lá!
