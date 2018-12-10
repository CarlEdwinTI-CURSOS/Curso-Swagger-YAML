package br.com.alura.funcionarios.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.funcionarios.api.entities.FuncionarioEntity;

@Repository
public interface Funcionarios extends JpaRepository<FuncionarioEntity, Long>{

}
