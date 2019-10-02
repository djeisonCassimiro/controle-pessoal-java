package com.financeiro.controlepessoal.enumerador;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de mai de 2019
 */
public enum InformativoEnum {

	SEM_REGISTROS(1), SALVO_SUCESSO(2), EDITADO_SUCESSO(3), EXCLUIDO_SUCESSO(4), CAIXA_ABERTO_SUCESSO(
			5), CAIXA_FECHADO_SUCESSO(6), CAIXA_ABERTO(7), CAIXA_FECHADO(8);

	public final int valor;

	/**
	 * Construtor responsável por
	 * 
	 * @author DEV 31 de mai de 2019
	 */
	private InformativoEnum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	/**
	 * Método responsável por retornar o codigo da informação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return codigo
	 */
	public String getCodigo() {
		if (valor == SEM_REGISTROS.getValor())
			return "INF0001";
		else if (valor == SALVO_SUCESSO.getValor())
			return "INF0002";
		else if (valor == SALVO_SUCESSO.getValor())
			return "INF0003";
		else if (valor == EXCLUIDO_SUCESSO.getValor())
			return "INF0004";
		else if (valor == CAIXA_ABERTO_SUCESSO.getValor())
			return "INF0005";
		else if (valor == CAIXA_FECHADO_SUCESSO.getValor())
			return "INF0006";
		else if (valor == CAIXA_ABERTO.getValor())
			return "INF0007";
		else if (valor == CAIXA_FECHADO.getValor())
			return "INF0008";
		return "INF0000";
	}

	/**
	 * Método responsável por retornar o mensagem da informação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return mensagem
	 */
	public String getMensagem(String msg) {
		if (valor == SEM_REGISTROS.getValor())
			return "Nenhum registro encontrado";
		else if (valor == SALVO_SUCESSO.getValor())
			return msg + " salvo(a) com sucesso!";
		else if (valor == SALVO_SUCESSO.getValor())
			return msg + " editado(a) com sucesso!";
		else if (valor == EXCLUIDO_SUCESSO.getValor())
			return msg + " excluido(a) com sucesso!";
		else if (valor == CAIXA_ABERTO_SUCESSO.getValor())
			return "Caixa aberto com sucesso!";
		else if (valor == CAIXA_FECHADO_SUCESSO.getValor())
			return "Caixa fechado com sucesso!";
		else if (valor == CAIXA_ABERTO.getValor())
			return "Caixa aberto!";
		else if (valor == CAIXA_FECHADO.getValor())
			return "Caixa fechado!";
		return "INF0000";
	}
}
