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

Como o nosso foco é customizar as operações para testar a API gerada automaticamente pelo **Generate Server do Swagger**.

Eu já preparei a regra de negócio do backend para ganharmos agilidade na nossa customização.

Tudo isso para que a gente se preocupe somente com a customização.

No backend que preparei foi utilizado o **banco de dados em memória HSQLDB** e **Spring Data**. 

Caso você tenha dúvidas em como criar a camada de negócio de uma API pode ver os cursos de **Spring MVC**,  **Spring Boot** e **Java e JPA**.


**Problema:** 

***E agora já customizamos a operação, mas o ClienteService.java e o RespostasUtil.java não exitem em nossa API.***

Vamos resolver isto já já.
