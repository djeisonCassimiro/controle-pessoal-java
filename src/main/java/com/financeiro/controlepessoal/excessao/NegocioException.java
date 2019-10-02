package com.financeiro.controlepessoal.excessao;

/**
 * 
 * @author DJEISON
 * 9 de abr de 2017
 * Classe responsável por encapsular as exções da camada de negócio(service)
 */
public class NegocioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 682584863626642214L;
	private String codigoException;
	/**
	 * @author DJEISON
	 * 9 de abr de 2017
	 * Método construtor responsável por receber a mensagem de erro e o codigo da exceção 
	 * @param message
	 * @param codigoException
	 */
	public NegocioException(String codigoException, String message) {
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
