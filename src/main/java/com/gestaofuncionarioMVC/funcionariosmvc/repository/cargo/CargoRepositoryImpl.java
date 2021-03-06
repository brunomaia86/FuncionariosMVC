package com.gestaofuncionarioMVC.funcionariosmvc.repository.cargo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Cargo;
import com.gestaofuncionarioMVC.funcionariosmvc.repository.CargoRepository;

public class CargoRepositoryImpl implements CargoRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private CargoRepository cargoRepository;

	@Override
	public List<Cargo> createQuery(String jpql, Object... params) {
		TypedQuery<Cargo> query = entityManager.createQuery(jpql, Cargo.class);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}
		return query.getResultList();
	}

	@Override
	@Transactional
	public void deletar(Serializable id) {
		cargoRepository.deleteById((Long) id);
	}

	@Override
	@Transactional
	public Cargo salvarOuAtualizar(Cargo entity) {
		return cargoRepository.save(entity);
	}

}
