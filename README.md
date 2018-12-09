# Swagger II - aula 7 - Customizando a operação excluiTransacao com POSTMAN

## Video 7.2 - Customizando a operação excluiTransacao


**Customizar a operação excluiTransacao na classe TransacaoApiController.java**
```try {
	  return transacaoService.exclui(authorization, codigo);		
	} catch (Exception e) {
	 return respostasUtil.getErroInterno(RespostasUtil.MENSAGEM_FALHA_AO_TENTAR_CONSULTAR_EXTRATO);
    }
```

**Iniciar a API**
Startar a API em modo debug.

**Chamar novamente a operação excluiTransacao via POSTMAN**

- Método: PUT
- URL: http://localhost:8085/bytebank-api/v1/transacao/2
- HEADERS:
```
Content-Type: application/json
 Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Pressionar SEND.

**Resposta da requisição**

Retornou o esperado 204 No Content (Exclusão efetuada com sucesso).

**Consultar novamente o extrato via POSTMAN para que a transação foi excluída**

```
Método: GET
URL: http://localhost:8085/bytebank-api/v1/extrato/8756/2/0 
HEADERS:
 - Content-Type: application/json
 - Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=
```

Pressionar SEND.

Maravilha! A transação foi excluida com sucesso!
