package com.gestaofuncionarioMVC.funcionariosmvc.service;

import java.util.List;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;

public interface DepartamentoService {

    void salvar(Departamento departamento);

    void editar(Departamento departamento);

    void excluir(Long id);

    Departamento buscarPorId(Long id);
    
    List<Departamento> buscarTodos();

	boolean departamentoNaoTemCargos(Long id);
}