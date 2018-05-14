package com.gestaofuncionarioMVC.funcionariosmvc.repository;

import java.io.Serializable;
import java.util.List;

public interface AbstractRepository<T, PK extends Serializable> {

	public T salvarOuAtualizar(T entity); 
	
	public void deletar(PK id); 
	
	List<T> createQuery(String jpql, Object... params);
	
}
