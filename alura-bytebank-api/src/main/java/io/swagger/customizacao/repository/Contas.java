package io.swagger.customizacao.repository;

import org.springframework.data.repository.CrudRepository;

import io.swagger.customizacao.entity.ClienteEntity;
import io.swagger.customizacao.entity.ContaEntity;

public interface Contas extends CrudRepository<ContaEntity, Long>{

	ContaEntity findByAgenciaAndNumeroAndDigitoAndCliente(Integer agencia, Long numero, Integer digito, ClienteEntity cliente); 
}