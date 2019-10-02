package com.financeiro.controlepessoal.entidade;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe responsável por
 * 
 * @author Djeison 17 de mai de 2019
 */
public class AuditoriaEdicao extends Auditoria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4482030216239333521L;
	@ManyToOne
	@JoinColumn(name = "usuario_edicao_id", nullable = true)
	private Usuario usuarioEdicao;
	@Column(name = "data_edicao", nullable = true)
	private Long dataEdicao;

	/**
	 * @return the usuarioEdicao
	 */
	public Usuario getUsuarioEdicao() {
		return usuarioEdicao;
	}

	/**
	 * @param usuarioEdicao
	 *            the usuarioEdicao to set
	 */
	public void setUsuarioEdicao(Usuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

	/**
	 * @return the dataEdicao
	 */
	public Long getDataEdicao() {
		return dataEdicao;
	}

	/**
	 * @param dataEdicao
	 *            the dataEdicao to set
	 */
	public void setDataEdicao(Long dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

}
