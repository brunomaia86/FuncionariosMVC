package com.gestaofuncionarioMVC.funcionariosmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	@Override
	public List<Funcionario> findByNome(String nome) {
		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Funcionario> findByCargo(Long id) {
		return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
	}

}
