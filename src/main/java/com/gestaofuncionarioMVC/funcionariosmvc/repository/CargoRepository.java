package com.gestaofuncionarioMVC.funcionariosmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Cargo;

@Transactional(readOnly = true)
public interface CargoRepository extends JpaRepository<Cargo, java.lang.Long> {

}
