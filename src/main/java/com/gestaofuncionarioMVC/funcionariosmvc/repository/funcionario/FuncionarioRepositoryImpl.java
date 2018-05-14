package com.gestaofuncionarioMVC.funcionariosmvc.repository.funcionario;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Funcionario;
import com.gestaofuncionarioMVC.funcionariosmvc.repository.FuncionarioRepository;

public class FuncionarioRepositoryImpl implements FuncionarioRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	/*@SuppressWarnings("unchecked")
	private final Class<Funcionario> entityClass = 
			(Class<Funcionario>) ( (ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	
	@Override
	public List<Funcionario> createQuery(String jpql, Object... params) {
		TypedQuery<Funcionario> query = entityManager.createQuery(jpql, entityClass);
		for (int i = 0; i < params.length; i++) {
		    query.setParameter(i+1, params[i]);
        }
    	return query.getResultList();
	}*/

	@Override
	@Transactional
	public Funcionario salvarOuAtualizar(Funcionario entity) {
		return funcionarioRepository.save(entity);
	}

	@Override
	@Transactional
	public void deletar(Serializable id) {
		funcionarioRepository.delete((Long) id);
	}


}
