package com.financeiro.controlepessoal.enumerador;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de mai de 2019
 */
public enum ExceptionEnum {

	DADOS_NULO(1), FORMATO_DATA_INCORRETO(2);

	private final int valor;

	/**
	 * Construtor responsável por
	 * 
	 * @author DEV 29 de mai de 2019
	 */
	ExceptionEnum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	/**
	 * Método responsável por retornar o codigo da excessão
	 * 
	 * @author DEV 29 de mai de 2019
	 * @return
	 */
	public String getCodigo() {
		if (valor == DADOS_NULO.getValor())
			return "EX001";
		else if (valor == FORMATO_DATA_INCORRETO.getValor())
			return "EX002";
		return "EX000";
	}

	/**
	 * Método responsável por retornar a mensagem descritiva da excessão
	 * 
	 * @author DEV 29 de mai de 2019
	 * @return
	 */
	public String getMensagem() {
		if (valor == DADOS_NULO.getValor())
			return "Os dados solicitados estão nulos";
		else if (valor == FORMATO_DATA_INCORRETO.getValor())
			return "Por favor, verifique se o formado da data está correto";
		return "Falha na execução";
	}
}