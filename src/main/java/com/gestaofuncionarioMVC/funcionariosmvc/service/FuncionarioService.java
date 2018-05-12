package com.gestaofuncionarioMVC.funcionariosmvc.service;

import java.util.List;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Funcionario;

public interface FuncionarioService {
    
	void save(Funcionario funcionario);

    void update(Funcionario funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();
}
