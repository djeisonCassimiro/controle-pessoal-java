package com.financeiro.controlepessoal.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de jun de 2019
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EntidadePadrao extends AuditoriaEdicao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3509474729288243998L;
	@Column(length = 100)
	private String descricao;
	@Column(length = 1)
	private String desativado;

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the desativado
	 */
	public String getDesativado() {
		return desativado;
	}

	/**
	 * @param desativado the desativado to set
	 */
	public void setDesativado(String desativado) {
		this.desativado = desativado;
	}
}