package io.swagger.customizacao.repository;

import org.springframework.data.repository.CrudRepository;

import io.swagger.customizacao.entity.TransacaoEntity;

public interface Transacoes extends CrudRepository<TransacaoEntity, Long> {
 
}
