package br.com.alura.funcionarios.api.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.alura.funcionarios.api"))
				.build()
				.apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
	    return new ApiInfoBuilder()
	       .title("Funcionarios API")
	       .description("API responsável por Cadastrar, Consultar, Alterar e Excluir funcionários")
	       .contact(new Contact("Contato Alura", "http://alura.com.br", "contato@alura.com.br"))
	       .version("1.0.0")
	       .build();
	}

}
