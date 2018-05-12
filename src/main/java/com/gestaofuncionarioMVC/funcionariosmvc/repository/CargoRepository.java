package com.gestaofuncionarioMVC.funcionariosmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, java.lang.Long> {

}
