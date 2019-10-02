package com.financeiro.controlepessoal.entidade;

public class ConexaoBanco {

	private String idConexao;
	private String usuario;
	private String senha;
	private String driver;
	private String url;
	private String urlFinal;
	private String porta;
	private String servidor;
	private String dataBase;
	private String tipo;
	
	public String getIdConexao() {
		return idConexao;
	}
	public void setIdConexao(String idConexao) {
		this.idConexao = idConexao;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUrlFinal() {
		return urlFinal;
	}
	public void setUrlFinal(String urlFinal) {
		this.urlFinal = urlFinal;
	}
	public String getPorta() {
		return porta;
	}
	public void setPorta(String porta) {
		this.porta = porta;
	}
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public String getDataBase() {
		return dataBase;
	}
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
