# Swagger II - aula 6 - Customizando a operação alteraValorTransacao com POSTMAN

## Video 6.2 - Customizando a operação alteraValorTransacao


**Customizar a operação alteraValorTransacao na classe TransacaoApiController.java**
```
try {
			return transacaoService.atualiza(authorization, codigo, valor);
		} catch (Exception e) {
			return respostasUtil.getErroInterno(RespostasUtil.MENSAGEM_FALHA_AO_TENTAR_ATUALIZAR_TRANSACAO);
		}
```

**Iniciar a API**
Startar a API em modo debug.

**Chamar novamente a operação alteraValorTransacao via POSTMAN**

- Método: PUT
- URL: http://localhost:8085/bytebank-api/v1/transacao/4?valor=130.01
- HEADERS:
```
Content-Type: application/json
 Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Pressionar SEND.

**Resposta da requisição**

Retornou o esperado 204 No Content (Alteração efetuada com sucesso).

**Consultar novamente o extrato via POSTMAN para ver se o valor da transacao foi realmente alterado**

```
Método: GET
URL: http://localhost:8085/bytebank-api/v1/extrato/8756/4/0 
HEADERS:
 - Content-Type: application/json
 - Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Pressionar SEND.

Maravilha! O valor da transação foi realmente alterado.

Agora tem um detalhe, identificamos que existe uma transação que precisa ser excluída.

Como podemos fazer isso?

Chamando a operação que exclui a transação!

Vamos lá!
