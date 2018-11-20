package io.swagger.customizacao.repository;

import org.springframework.data.repository.CrudRepository;

import io.swagger.customizacao.entity.ClienteEntity;

public interface Clientes extends CrudRepository<ClienteEntity, Long> {

	ClienteEntity findByCpfAndPassword(String cpf, String password); 
}