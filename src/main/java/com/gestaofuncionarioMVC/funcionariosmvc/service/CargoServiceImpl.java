package com.gestaofuncionarioMVC.funcionariosmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Cargo;
import com.gestaofuncionarioMVC.funcionariosmvc.repository.CargoRepository;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Override
	@Transactional
	public void save(Cargo cargo) {
		cargoRepository.save(cargo);
	}

	@Override
	@Transactional
	public void update(Cargo cargo) {
		cargoRepository.save(cargo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cargoRepository.delete(id);
	}

	@Override
	public Cargo findById(Long id) {
		return cargoRepository.findOne(id);
	}

	@Override
	public List<Cargo> buscarTodos() {
		return cargoRepository.findAll();
	}

}
