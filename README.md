# Swagger II - aula 3 - Chamando as operações com POSTMAN

## Video 3.2 -Chamando a operação cadastraCliente via documentação interativa


1-Start a API em modo debug através da classe Swagger2Springboot.java.

2-Coloque breakpoint na operação consultaSaldo() na classe ContaApiController.java.

3-Abra o POSTMAN.

4-Abra uma nova request no POSTMAN.

Agora com o cliente cadastrado já podemos testar a operação de consulta saldo para vermos o saldo inicial do cliente.

Mas, qual é a URL e informações que devemos passar para a API para chamar esta operação? 

Como podemos descobrir isso?

**Documentação Interativa**
1-Acessar documentação interativa para descobrir as informações necessárias para preencher a requisição da operação consultaSaldo
-URL: http://localhost:8085/bytebank-api/v1/swagger-ui.html 
-Abrir a trag Conta
-Abrir a operação GET - consultaSaldo

**POSTMAN 1ª REQUEST**
URL padrão da operação consultaSaldo
http://localhost:8085/bytebank-api/v1/conta/{agencia}/{numero}/{digito}/saldo

1-Preencher a request
-URL: http://localhost:8085/bytebank-api/v1/conta/8756/4/0/saldo

2-Pressionar SEND

Resposta 415 Unsupported Media Type 
Content-Type não informado


**POSTMAN 2ª REQUEST**
1-Preencher a request
-URL: http://localhost:8085/bytebank-api/v1/conta/8756/4/0/saldo
-Header: Content-Type: application/json

3-Pressionar SEND

Resposta 400 Bad Request 
Authorization obrigatório no HEADER

Mas, o que é o Authorization?

São o CPF e Senha do cliente que precisamos passar na requisição, afinal somente ele poderá ter acesso a essas informações de sua conta.

**POSTMAN 3ª REQUEST**
1-Preencher Authorization na aba Authorization
-Type: Basic Auth
-Username: 01234567830, Password: senha123

2-Pressionar Update Request

3-Preencher a request
-URL: http://localhost:8085/bytebank-api/v1/conta/8756/4/0/saldo
-Authorization: Username: 01234567830, Password: senha123
-Header: Content-Type: application/json
-Header: Authorization: Basic MDEyMzQ1Njc4MzA6c2VuaGExMjM=

4-Pressionar SEND

Resposta 501 Not Implemented 
A requisição chamou a operação e retornou uma resposta padão.

Repare que agora a operação consultaSaldo foi chamada, caiu no breakpoint e retornou a mensagem padrão de 501 Not Implemented.

Tudo normal, já era esperado.

A diante vamos customizar esta operação.

Até lá!