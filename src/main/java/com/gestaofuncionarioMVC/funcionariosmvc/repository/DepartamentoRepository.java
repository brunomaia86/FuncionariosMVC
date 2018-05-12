package com.gestaofuncionarioMVC.funcionariosmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}
