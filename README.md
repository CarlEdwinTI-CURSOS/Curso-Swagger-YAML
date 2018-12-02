# Swagger II - aula 3 - Chamando as operações com POSTMAN

## Video 3.1 -Cadastrando o cliente via POSTMAN

No dia a dia as APIs são consumidas através de clients REST nos vamos usar o POSTMAN para isso.

1-Start a API em modo debug através da classe Swagger2Springboot.java.

2-Coloque breakpoint na operação cadastraCliente() na classe ClienteApiController.java.

3-Abra o POSTMAN.

Caso você não tenha ele instalado vá no goolge e digite postman e acesse o link:  
[Chrome Web Store - POSTMAN](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=pt-BR)

Selecione o botão Abrir aplicativo para iniciar o POSTMAN.

4-Abra uma nova request no POSTMAN.

- Selecione o tipo de operação que será POST
- Preencha a URL
- Preencha o HEADER com 
- Preencha o body com os dados de cadastro do cliente do novo cliente
- Pressione o botão SEND.

**REQUEST**

|Operação|METHOD|URL|QUERY PARAMS|HEADERS|BODY|
|--|--|--|--|--|--|
|cadastraCliente | POST | http://localhost:8085/bytebank-api/v1/cliente|N/A|Content-Type|{"cpf": "01234567830", "id": 234, "senha": "senha123", "titular": "Ertheni Rockma"} |
| | | | | | |


O retorno **201** cliente cadastrado com sucesso.

```
{
    "id": 4,
    "titular": "Ertheni Rockma",
    "cpf": "01234567830",
    "senha": null,
    "contas": [
        {
            "agencia": 8756,
            "numero": 4,
            "digito": 0,
            "saldo": 0,
            "cliente": null,
            "transacoes": null
        }
    ]
}
```

5-Copie o conteúdo retornado.

**Vamos guardar o conteúdo da resposta de retorno do cliente cadastrado para podermos depois usar nas operações de consulta saldo, extrato ah sem esquecer a o CPF e SENHA que vamos usar para ter acesso a essas operações, pois o usuário precisará ter acesso para poder usar-las.**
