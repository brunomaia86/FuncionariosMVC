package com.gestaofuncionarioMVC.funcionariosmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;
import com.gestaofuncionarioMVC.funcionariosmvc.repository.DepartamentoRepository;

public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	@Transactional(readOnly = false)
	public void save(Departamento departamento) {
		departamentoRepository.save(departamento);
	}

	@Override
	@Transactional(readOnly = false)
	public void update(Departamento departamento) {
		departamentoRepository.save(departamento);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		departamentoRepository.delete(id);
	}

	@Override
	public Departamento findById(Long id) {
		return departamentoRepository.findOne(id);
	}

	@Override
	public List<Departamento> findAll() {
		return departamentoRepository.findAll();
	}

}
