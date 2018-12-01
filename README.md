# Swagger II - aula 2 - Configurando a API

## Video 2.3 - Conhecendo as classes de customização do Cliente

Injeção do ClienteService(cria a comunição entre controller, camada de negócios e banco de dados) e do RespostasUtil(cria as mensagens de resposta 200, 201, 204, 400, 401 e 500).

```
    @Autowired
	private ClienteService clienteService;
	
	@Autowired
	private RespostasUtil respostasUtil;
```

Camada de Controller chama o método salva() do clienteService para salvar o cliente.

```
	public ResponseEntity<Cliente> cadastraCliente(@ApiParam(value = ""  )  @Valid @RequestBody Cliente cliente_) {
        
    	try {
            return clienteService.salva(cliente_);
         } catch (Exception e) {
          return respostasUtil.getErroInternoCliente(ClienteService.FALHA_AO_TENTAR_CADASTRAR_UM_CLIENTE);
         }
    }

```

Injeta o repository Clientes para se comunicar com o banco de dados e salvar o cliente efetivamente.

```
@Autowired
    private Clientes repository;
```

Valida o cliente para salvar e chama o método dadastraNovoCliente().

```
	public ResponseEntity<Cliente> salva(Cliente cliente_) {

		if (ehClienteValidoParaCadastro(cliente_)) {
			return respostasUtil.getRequisicaoInvalidaCliente(MENSAGEM_DADOS_INVALIDOS);
		}

		return new ResponseEntity<Cliente>(cadastraNovoCliente(cliente_), HttpStatus.CREATED);
	}
```	

Chama o repository para salvar o cliente no banco de dados.
```    
	public Cliente cadastraNovoCliente(Cliente cliente_) {
		
		String tokenBasicAuth = AuthUtil.getBasicAuth(cliente_.getCpf(), cliente_.getSenha());
		
		ClienteEntity clienteEntity = ClienteConverter.toClienteEntity(cliente_, tokenBasicAuth);
		
		clienteEntity = repository.save(clienteEntity);
			
		return ClienteConverter.toCliente(clienteEntity);
	}
```

Recupera o cliente
```	
	public ClienteEntity getClienteByAuthorization(String authorization) {
		String[] basicAuth = AuthUtil.getBasicAuth(authorization);
		String cpf = basicAuth[0];
		String password = basicAuth[1];
		
		ClienteEntity clienteEntity = repository.findByCpfAndPassword(cpf, password);
		return clienteEntity;
	}
```

Verica se os dados são válidos para o cadastro
```	
	public boolean ehClienteValidoParaCadastro(Cliente cliente_) {
		return StringUtils.isEmpty(cliente_.getTitular()) || StringUtils.isEmpty(cliente_.getCpf()) || StringUtils.isEmpty(cliente_.getSenha());
	}
```


Classe que se comunica com a tabela Cliente no banco de dados e executa as operações de CRUD
```

public interface Clientes extends CrudRepository<ClienteEntity, Long> {

	ClienteEntity findByCpfAndPassword(String cpf, String password); 
}
```
