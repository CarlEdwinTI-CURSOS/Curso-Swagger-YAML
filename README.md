# Swagger II - aula 1 - Iniciando a customização da API

Para customizar essa operação precisaremos de um Service para cadastrar o Cliente e precisaremos também enviar uma mensagem de erro caso algo dê errado.
Vamos pensar que aqui precisaremos injetar então um ClienteService e para facilitar uma classe que trate mensagens de resposta da API.

## Video 1.3 - Customizando a operação cadastraCliente
- Remover as variáveis, construtor e imports desnecessários
- Injetar o service **ClienteService.java** para salvar o cliente
- Injetar o útil **RespostasUtil.java** para tratar **respostas com mensagens no header**
```
        @Autowired
	private ClienteService clienteService;
	
	@Autowired
	private RespostasUtil respostasUtil;
```
- Alterar o conteúdo do método cadastraCliente pelo customizado
```
try {
            return clienteService.salva(cliente_);
         } catch (Exception e) {
          return respostasUtil.getErroInternoCliente(ClienteService.FALHA_AO_TENTAR_CADASTRAR_UM_CLIENTE);
         }
```
**Para a customização precisamos criar:**

- um banco de dados
- uma conexão com o banco de dados
- regras de negócio
- entre outras coisas

## Para fazer tudo isso levariamos muito tempo, não? ##

**Tudo isso já está criado**
O nosso foco aqui é customizar as operações para testar a API gerada automaticamente pelo **Generate Server do Swagger**.

Nos temos aqui um pacote de customização que já contempla todas essas configurações de banco, conexão e as regras de negócio.

Vamos baixar no exercício desta aula e utilizar na nossa operação de cadastro.
