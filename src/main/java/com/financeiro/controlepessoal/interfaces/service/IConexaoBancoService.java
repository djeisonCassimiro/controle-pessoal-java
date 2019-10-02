package com.financeiro.controlepessoal.interfaces.service;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;

import com.financeiro.controlepessoal.entidade.Conexao;
import com.financeiro.controlepessoal.entidade.ConexaoBanco;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.google.gson.JsonSyntaxException;

public interface IConexaoBancoService extends Serializable {

	public abstract String montarUrl(String url, String servidor, String dataBase);

	public abstract String montarUrl(String url, String servidor, int porta, String dataBase);

	public abstract String montarUrl(String url, String servidor, String dataBase, String urlFinal);

	public abstract String montarUrl(String url, String servidor, int porta, String dataBase, String urlFinal);

	public abstract ConexaoBanco montarObjeto(String caminho, String nome, String tipo) throws JsonSyntaxException, FileNotFoundException;
	
	public abstract ConexaoBanco getConexao(Conexao conexao, String tipo, String idConexao);
	
	public abstract Conexao getConexao(String caminho, String nome)  throws NegocioException;
	
	public abstract boolean salvar(Conexao conexao)  throws NegocioException;
	
	public abstract boolean editar(Conexao conexao)  throws NegocioException;
	
	public abstract boolean editar(ConexaoBanco conexao)  throws NegocioException;
	
	public abstract boolean salvar(List<ConexaoBanco> conexoes)  throws NegocioException;
	
	public abstract List<ConexaoBanco> getConexoes(String caminho, String nome)  throws NegocioException;
	
	public abstract ConexaoBanco getConexao(String caminho, String nome, String idConexao)  throws NegocioException;
}
