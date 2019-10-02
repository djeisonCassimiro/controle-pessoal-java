package com.financeiro.controlepessoal.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Classe responsável por
 * 
 * @author Djeison 17 de mai de 2019
 */
@MappedSuperclass
public class Auditoria extends AbstractPersistable<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8253189555748446367L;
	private Long id;
	@ManyToOne
	@JoinColumn(name = "usuario_cadastro_id", nullable = true)
	private Usuario usuarioCadastro;
	@Column(name = "data_cadastro", nullable = true)
	private Long dataCadastro;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the usuarioCadastro
	 */
	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	/**
	 * @param usuarioCadastro
	 *            the usuarioCadastro to set
	 */
	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	/**
	 * @return the dataCadastro
	 */
	public Long getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param dataCadastro
	 *            the dataCadastro to set
	 */
	public void setDataCadastro(Long dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
