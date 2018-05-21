package com.gestaofuncionarioMVC.funcionariosmvc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@OneToMany(mappedBy = "departamento")
	private List<Cargo> cargos;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "situacao_juridica_id")
	private SituacaoJuridica situacaoJuridica;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public SituacaoJuridica getSituacaoJuridica() {
		return situacaoJuridica;
	}

	public void setSituacaoJuridica(SituacaoJuridica situacaoJuridica) {
		this.situacaoJuridica = situacaoJuridica;
	}

}
