package com.gestaofuncionarioMVC.funcionariosmvc.repository.departamento;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;
import com.gestaofuncionarioMVC.funcionariosmvc.repository.DepartamentoRepository;

public class DepartamentoRepositoryImpl implements DepartamentoRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	/*@SuppressWarnings("unchecked")
	private final Class<Departamento> entityClass = 
			(Class<Departamento>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	*/
	
	@Override
	public List<Departamento> createQuery(String jpql, Object... params) {
		TypedQuery<Departamento> query = entityManager.createQuery(jpql, Departamento.class);
		for (int i = 0; i < params.length; i++) {
		    query.setParameter(i+1, params[i]);
        }
    	return query.getResultList();
	}
	
	@Override
	@Transactional
	public Departamento salvarOuAtualizar(Departamento entity) {
		return departamentoRepository.save(entity);
	}

	@Override
	@Transactional
	public void deletar(Serializable id) {
		departamentoRepository.delete((Long) id);
	}

}
