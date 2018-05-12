package com.gestaofuncionarioMVC.funcionariosmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Funcionario;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
