package com.financeiro.controlepessoal.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe responsável por manipular os dados de usuários
 * 
 * @author Djeison 17 de mai de 2019
 */
@Entity
@Table(name = "tb_usuario")
public class Usuario extends AuditoriaEdicao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4549655290584359817L;
	@Column(name = "login", length = 70, nullable = true)
	private String login;
	@Column(name = "senha", length = 70, nullable = true)
	private String senha;
	@Column(nullable = false)
	private String desativado;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
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
