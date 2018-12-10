package br.com.alura.funcionarios.api.restcontrollers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.funcionarios.api.entities.FuncionarioEntity;
import br.com.alura.funcionarios.api.models.Funcionario;
import br.com.alura.funcionarios.api.repositories.Funcionarios;

@RestController
@RequestMapping("funcionario")
public class FuncionarioRestController {

	@Autowired
	private Funcionarios funcionarios;
	
	@GetMapping(value = "/todos", consumes = "application/json", produces="application/json")
	public ResponseEntity<List<Funcionario>> todos(){
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		
		try {
			
			List<FuncionarioEntity> funcionariosEntity = funcionarios.findAll();
			
			if(funcionariosEntity == null || funcionariosEntity.isEmpty()) {
				headers.add("Erro: ", "Não existem funcionários.");
				return new ResponseEntity<List<Funcionario>>(headers, HttpStatus.NOT_FOUND);
			}

			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			for(FuncionarioEntity funcionarioEntity : funcionariosEntity) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(funcionarioEntity.getId());
				funcionario.setNome(funcionarioEntity.getNome());
				funcionario.setSalario(funcionarioEntity.getSalario());
				funcionario.setDataNascimento(funcionarioEntity.getDataNascimento());
				funcionario.setDataContratacao(funcionarioEntity.getDataContratacao());
				funcionarios.add(funcionario);
			}
			
			return new ResponseEntity<List<Funcionario>>(funcionarios , HttpStatus.OK);
		} catch (Exception e) {
			headers.add("Erro: ", "Erro ao tentar consultar funcionários.");
			return new ResponseEntity<List<Funcionario>>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = "application/json", produces="application/json")
	public ResponseEntity<Funcionario> cadastra(@RequestBody(required=true) Funcionario funcionario){

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		
		try {
			
			FuncionarioEntity funcionarioEntity = funcionarios.save(new FuncionarioEntity(funcionario.getNome(), funcionario.getDataNascimento(), funcionario.getSalario(), new Date()));
			
			if(funcionarioEntity == null) {
				headers.add("Erro: ", "Não foi possível cadastrar o novo funcionario.");
				return new ResponseEntity<Funcionario>(headers, HttpStatus.BAD_REQUEST);
			}
			
			funcionario.setId(funcionarioEntity.getId());
			funcionario.setNome(funcionarioEntity.getNome());
			funcionario.setSalario(funcionarioEntity.getSalario());
			funcionario.setDataNascimento(funcionarioEntity.getDataNascimento());
			funcionario.setDataContratacao(funcionarioEntity.getDataContratacao());
			
			return new ResponseEntity<Funcionario>(funcionario , HttpStatus.OK);
		} catch (Exception e) {
			headers.add("Erro: ", "Erro ao tentar cadastrar funcionário.");
			return new ResponseEntity<Funcionario>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json", produces="application/json")
	public ResponseEntity<Void> altera(@PathVariable Long id, @RequestBody(required=true) Funcionario funcionario){

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		
		try {
			
			FuncionarioEntity funcionarioEntity = funcionarios.findOne(id);
			
			if(funcionarioEntity == null) {
				headers.add("Erro: ", "Funcionário não encontrado.");
				return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
			}
			
			funcionarioEntity.setNome(funcionario.getNome());
			funcionarioEntity.setSalario(funcionario.getSalario());
			funcionarioEntity.setDataNascimento(funcionario.getDataNascimento());
			funcionarioEntity.setDataContratacao(funcionario.getDataContratacao());
			
			funcionarioEntity = funcionarios.save(funcionarioEntity);
			
			if(funcionarioEntity == null) {
				headers.add("Erro: ", "Não foi possível alterar funcionário.");
				return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
			}
			
			headers.add("Mensagem:", "Funcionário alterado com sucesso!");
			return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			headers.add("Erro: ", "Erro ao tentar alterar o funcionário.");
			return new ResponseEntity<Void>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}", produces="application/json")
	public ResponseEntity<Void> remove(@PathVariable Long id){

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		
		try {
			
			FuncionarioEntity funcionarioEntity = funcionarios.findOne(id);
			
			if(funcionarioEntity == null) {
				headers.add("Erro: ", "Funcionário não encontrado.");
				return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
			}
			
			funcionarios.delete(id);
			
			if(funcionarios.exists(id)) {
				headers.add("Erro: ", "Não foi possível excluir o funcionário.");
				return new ResponseEntity<Void>(headers, HttpStatus.BAD_REQUEST);
			}
			
			headers.add("Mensagem:", "Funcionário excluído com sucesso!");
			return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			headers.add("Erro: ", "Erro ao tentar excluir o funcionário.");
			return new ResponseEntity<Void>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
