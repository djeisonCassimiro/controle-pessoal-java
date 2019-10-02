package com.financeiro.controlepessoal.enumerador;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de mai de 2019
 */
public enum NegocioExceptionEnum {

	EXISTE_CADASTRO(1), EXISTE_CONFLITO_EXCLUSAO(2), DADOS_OBRIGATORIOS_NAO_PREENCHIDOS(3), CFOP_INCORRETO(4),
	NCM_INCORRETO(5), CEST_INCORRETO(6), CST_INCORRETO(7), EXISTE_CADASTRO_EDICAO(8), SESSAO_CAIXA_FECHADO(9),
	ERRO_FECHAMENTO_CAIXA(10), ERRO_ABERTURA_CAIXA(11), ERRO_EDICAO_NAO_EXITE_CADASTRO(12), EXISTE_CAIXA_ABERTO(13), MULTIPLUS_CAIXAS_ABERTOS(14);

	private final int valor;

	/**
	 * Construtor responsável por receber o valor do enum que está sendo tratado
	 * 
	 * @author DEV 28 de mai de 2019
	 */
	NegocioExceptionEnum(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	/**
	 * Método responsável por retornar a mensagem descritiva da excessão
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param msg
	 * @return mensagem
	 */
	public String getMensagem(String msg) {
		if (valor == EXISTE_CADASTRO.getValor())
			return "Cadastro já realizado anteriormente";
		else if (valor == EXISTE_CONFLITO_EXCLUSAO.getValor())
			return "Não é possivel excluir e entidade " + msg + " pois exite movimentação da mesma";
		else if (valor == DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getValor())
			return "Por favor, preencha todos os campos obrigatórios os valores a seguir devem ser preenchidos " + msg;
		else if (valor == CFOP_INCORRETO.getValor())
			return "CFOP incorreto para e operação";
		else if (valor == NCM_INCORRETO.getValor())
			return "NCM incorreto para e operação";
		else if (valor == CEST_INCORRETO.getValor())
			return "CEST incorreto para e operação";
		else if (valor == CST_INCORRETO.getValor())
			return "CST incorreto para e operação";
		else if (valor == EXISTE_CADASTRO_EDICAO.getValor())
			return "Atenção: Operação não concluida. " + EXISTE_CADASTRO.getMensagem("");
		else if (valor == SESSAO_CAIXA_FECHADO.getValor())
			return "O caixa está fechado! Favor abrir uma nova sessção antes de continuar";
		else if (valor == ERRO_FECHAMENTO_CAIXA.getValor())
			return "Erro ao fechar o caixa, favor entrar em contato com suporte!";
		else if (valor == ERRO_ABERTURA_CAIXA.getValor())
			return "Erro ao abrir o caixa, favor entrar em contato com suporte!";
		else if (valor == ERRO_EDICAO_NAO_EXITE_CADASTRO.getValor())
			return "Não é possível editar a entidade " + msg + " poís não ha cadastro da mesma";
		else if (valor == EXISTE_CAIXA_ABERTO.getValor())
			return "Existe um caixa em aberto, por favor feche o caixa anterior antes de prosseguir";
		else if (valor == MULTIPLUS_CAIXAS_ABERTOS.getValor())
			return "Existe varias sessões de caixa em aberto, por favor feche todas as sessões antes de prosseguir";
		return "Falha na execução";
	}

	/**
	 * Método responsável por retornar o codigo da excessão
	 * 
	 * @author DEV 28 de mai de 2019
	 * @return codigo
	 */
	public String getCodigo() {
		if (valor == EXISTE_CADASTRO.getValor())
			return "NG001";
		else if (valor == EXISTE_CONFLITO_EXCLUSAO.getValor())
			return "NG002";
		else if (valor == DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getValor())
			return "NG003";
		else if (valor == NCM_INCORRETO.getValor())
			return "NG005";
		else if (valor == CEST_INCORRETO.getValor())
			return "NG006";
		else if (valor == CST_INCORRETO.getValor())
			return "NG007";
		else if (valor == EXISTE_CADASTRO_EDICAO.getValor())
			return "NG008";
		else if (valor == SESSAO_CAIXA_FECHADO.getValor())
			return "NG009";
		else if (valor == ERRO_FECHAMENTO_CAIXA.getValor())
			return "NG010";
		else if (valor == ERRO_ABERTURA_CAIXA.getValor())
			return "NG011";
		else if (valor == ERRO_EDICAO_NAO_EXITE_CADASTRO.getValor())
			return "NG012";
		else if (valor == EXISTE_CAIXA_ABERTO.getValor())
			return "NG013";
		else if (valor == MULTIPLUS_CAIXAS_ABERTOS.getValor())
			return "NG014";
		return "NG0000";
	}
}
