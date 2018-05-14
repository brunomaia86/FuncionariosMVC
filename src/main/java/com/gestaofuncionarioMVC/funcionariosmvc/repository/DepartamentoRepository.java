package com.gestaofuncionarioMVC.funcionariosmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;
import com.gestaofuncionarioMVC.funcionariosmvc.repository.departamento.DepartamentoRepositoryQuery;

@Transactional(readOnly = true)
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>, DepartamentoRepositoryQuery {

}
