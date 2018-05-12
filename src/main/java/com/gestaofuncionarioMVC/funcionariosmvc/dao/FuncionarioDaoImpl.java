package com.gestaofuncionarioMVC.funcionariosmvc.dao;

import org.springframework.stereotype.Repository;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
