# Swagger II - aula 1 - XX

## Video 1.3 - Customizando a operação cadastraCliente
- Remover as variáveis, construtor e imports desnecessários
- Injetar o service **ClienteService.java** para salvar o cliente
- Injetar o útil **RespostasUtil.java** para tratar **respostas com mensagens no header**

```
@Controller
public class ClienteApiController implements ClienteApi {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private RespostasUtil respostasUtil;
	
    public ResponseEntity<Cliente> cadastraCliente(@ApiParam(value = ""  )  @Valid @RequestBody Cliente cliente_) {
        
         try {
            return clienteService.salva(cliente_);
         } catch (Exception e) {
          return respostasUtil.getErroInternoCliente(ClienteService.FALHA_AO_TENTAR_CADASTRAR_UM_CLIENTE);
         }
    }
```