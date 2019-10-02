package com.financeiro.controlepessoal.entidade;

import java.util.List;

public class Conexao {

	private String baseParaDados;
	private String baseParaImagem;
	private List<ConexaoBanco> conexoes;

	public String getBaseParaDados() {
		return baseParaDados;
	}

	public void setBaseParaDados(String baseParaDados) {
		this.baseParaDados = baseParaDados;
	}

	public String getBaseParaImagem() {
		return baseParaImagem;
	}

	public void setBaseParaImagem(String baseParaImagem) {
		this.baseParaImagem = baseParaImagem;
	}

	public List<ConexaoBanco> getConexoes() {
		return conexoes;
	}

	public void setConexoes(List<ConexaoBanco> conexoes) {
		this.conexoes = conexoes;
	}

}
