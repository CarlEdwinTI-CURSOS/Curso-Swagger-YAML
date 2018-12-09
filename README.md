# Swagger II - aula 2 - Configurando a API

## Video 2.1 - Importando arquivos de customização

***OBS.***

**Pessoal essa camadas de customização que contemplam os Services, Repository e persistência de dados no geral foi desenvolvida paralelamente por um outro time enquanto desenvolvia-mos a camada o script swagger.***

***Agora é só importar essa camada e usar.***


**Baixar o arquivo .txt, a pasta de customização e descompactar**
```
properties_pom.txt
customizacao.zip
```

**Copiar a pasta customizado e colar na pasta swagger do projeto pelo Windows Explorer**
```
alura-bytebank-api/src/main/java/io/swagger
```

**Copiar as configurações de properties do arquivo properties_pom.txt e colar no application.properties**
```
**application.properties**
#################### datasource ########################
spring.datasource.username=bytebank_admin
spring.datasource.data-password=bytebank_password
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update

#################### configuracoes do HSQLDB ########################
spring.datasource.url=jdbc:hsqldb:file:./database_in_memory/bytebank_db
spring.datasource.driver-class-name=org.hsqldb.jdbcDriver
```

**Copiar as dependências do arquivo properties_pom.txt e colar no .pom**
```
    <dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
		
    <dependency>
	<groupId>org.hsqldb</groupId>
	<artifactId>hsqldb</artifactId>
   </dependency>
```

***Acessar a classe ClienteApiController.java***
```
import io.swagger.customizacao.service.ClienteService;
import io.swagger.customizacao.util.RespostasUtil;
```
***Iniciar a API***
Startar a API em modo debug.

***Acessar a documentação da API***
http://localhost:8085/bytebank-api/v1/

Já já vamos chamar novamente a operação de cadastraCliente para ver se está funcionando o cadastro com a customização.
