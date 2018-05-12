package com.gestaofuncionarioMVC.funcionariosmvc.service;

import java.util.List;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Cargo;

public interface CargoService {

    void save(Cargo cargo );

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> buscarTodos();
}
