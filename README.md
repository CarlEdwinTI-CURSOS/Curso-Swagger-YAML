# Swagger II - aula 8 - Documentando um projeto existente com Swagger

## Video 8.3 - Criando a documentação inicial da API


**Alterar o @Bean Docket do método api()**

```
Incluir o método .apiInfo(getApiInfo())  com o  logo após o método build(). 
@Bean
public Docket api() {
 return new Docket(DocumentationType.SWAGGER_2)
	.select()
            .apis(RequestHandlerSelectors.basePackage("br.com.alura.funcionarios.api"))
	.build()
	.apiInfo(getApiInfo());
}
```

**Criar o método getApiInfo() para configurar a seção info**

```
private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
       .title("Funcionarios API")
       .description("API responsável por Cadastrar, Consultar, Alterar e Excluir funcionários")
       .contact(new Contact("Contato Alura", "http://alura.com.br", "contato@alura.com.br"))
       .version("1.0.0")
       .build();
}
```

**Iniciar a API e chamar na URL**
http://localhost:8085/funcionarios-api/swagger-ui.html para ver o que foi gerado.

