package com.gestaofuncionarioMVC.funcionariosmvc.converters;

import org.springframework.core.convert.converter.Converter;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.SituacaoJuridica;

public class StringToSituacaoJuridicaConverter implements Converter<String, SituacaoJuridica> {

	@Override
	public SituacaoJuridica convert(String text) {
		return null;
	}

}
