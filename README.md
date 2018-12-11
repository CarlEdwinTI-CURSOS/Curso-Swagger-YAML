# Swagger II - aula 8 - Documentando um projeto existente com Swagger

## Video 8.2 - Criando a documentação inicial da API
Criar o pacote de configuração
br.com.alura.funcionarios.api.swagger.configuration

**Criar a classe de configuração e anotar Configuration e EnableSwagger2**

```
@Configuration
@EnableSwagger2
SwaggerConfiguration.java .
```

**Tentar importar as @Anotações**
Dá Erro

**Incluir no .pom as dependências springfox-swagger2 e springfox-swagger-ui.**
```
<!--SpringFox dependencies -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.7.0</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.7.0</version>
        </dependency>
```

**Tentar importar novamente as @Anotações**
```
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
```

**Criar o @Bean de configuração para o Swagger**
```
@Bean
public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
	.select()
	.apis(RequestHandlerSelectors.basePackage("br.com.alura.funcionarios.api"))
	.build();
}
```

**Iniciar a API e chamar na URL**
http://localhost:8080/funcionarios-api/swagger-ui.html para ver o que foi gerado.

Maravilha! Já está gerando a documentação interativa do Swagger, inclusive mostrando as operações disponíveis!

E como fazemos para configurar o bloco info da API, para colocar um título, descrição, versão e informações de contato?

Veremos isso a seguir!

Até já!
