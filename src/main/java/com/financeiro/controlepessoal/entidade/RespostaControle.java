package com.financeiro.controlepessoal.entidade;

import java.io.Serializable;

/**
 * Classe responsável por
 * 
 * @author DEV 31 de mai de 2019
 */
public class RespostaControle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1686912143660285198L;
	private String codigo;
	private String mensagem;

	/**
	 * Construtor responsável por
	 * 
	 * @author DEV 31 de mai de 2019
	 */
	public RespostaControle(String codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	/**
	 * Método responsável por
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((mensagem == null) ? 0 : mensagem.hashCode());
		return result;
	}

	/**
	 * Método responsável por
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaControle other = (RespostaControle) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		return true;
	}

	/**
	 * Método responsável por
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return
	 */
	@Override
	public String toString() {
		return "RespostaControle [codigo=" + codigo + ", mensagem=" + mensagem + "]";
	}

}