package com.gestaofuncionarioMVC.funcionariosmvc.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;
import com.gestaofuncionarioMVC.funcionariosmvc.service.DepartamentoService;

@Component
public class StringToDepartamantoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService departamentoService;
	
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) 
			return null;	
		
		return departamentoService.buscarPorId(Long.valueOf(text));
	}

}
