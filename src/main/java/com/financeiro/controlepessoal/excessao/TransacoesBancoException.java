package com.financeiro.controlepessoal.excessao;

/**
 * 
 * @author DJEISON 9 de abr de 2017 Classe responsável por encapsular as exções
 *         da camada de dao
 */
public class TransacoesBancoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4248119335314171625L;
	private String codigoException;

	/**
	 * @author DJEISON 9 de abr de 2017 Método construtor responsável por receber a
	 *         mensagem de erro e o codigo da exceção
	 * @param message
	 * @param codigoException
	 */
	public TransacoesBancoException(String codigoException, String message) {
		super(message);
		this.codigoException = codigoException;
	}

	public String getCodigoException() {
		return codigoException;
	}

	public void setCodigoException(String codigoException) {
		this.codigoException = codigoException;
	}
}