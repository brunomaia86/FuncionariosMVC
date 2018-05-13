package com.gestaofuncionarioMVC.funcionariosmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Funcionario;
import com.gestaofuncionarioMVC.funcionariosmvc.repository.FuncionarioRepository;

public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	@Transactional(readOnly = false)
	public void save(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		funcionarioRepository.delete(id);
	}

	@Override
	public Funcionario findById(Long id) {
		return funcionarioRepository.findOne(id);
	}

	@Override
	public List<Funcionario> findAll() {
		return funcionarioRepository.findAll();
	}

}
