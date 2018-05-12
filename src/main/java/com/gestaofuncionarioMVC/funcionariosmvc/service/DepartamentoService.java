package com.gestaofuncionarioMVC.funcionariosmvc.service;

import java.util.List;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;

public interface DepartamentoService {

    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
}
