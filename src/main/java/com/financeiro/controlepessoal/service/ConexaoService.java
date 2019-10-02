package com.financeiro.controlepessoal.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.financeiro.controlepessoal.entidade.Conexao;
import com.financeiro.controlepessoal.entidade.ConexaoBanco;
import com.financeiro.controlepessoal.entidade.RetornoOperacoes;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.interfaces.service.IConexaoBancoService;
import com.financeiro.controlepessoal.util.JsonUtil;
import com.financeiro.controlepessoal.util.UtilObject;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

@Service
public class ConexaoService implements IConexaoBancoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8079007470065210952L;

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param url
	 * @param servidor
	 * @param dataBase
	 * @return
	 */
	@Override
	public String montarUrl(String url, String servidor, String dataBase) {
		if ((UtilObject.isNotEmpty(url)) && (UtilObject.isNotEmpty(servidor)) && (UtilObject.isNotEmpty(dataBase)))
			return url + servidor + dataBase;
		return "";
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param url
	 * @param servidor
	 * @param porta
	 * @param dataBase
	 * @return
	 */
	@Override
	public String montarUrl(String url, String servidor, int porta, String dataBase) {
		if ((UtilObject.isNotEmpty(url)) && (UtilObject.isNotEmpty(servidor)) && (UtilObject.isNotEmpty(dataBase))
				&& (porta > 0))
			return url + servidor + String.valueOf(porta) + dataBase;
		return "";
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param url
	 * @param servidor
	 * @param dataBase
	 * @param urlFinal
	 * @return
	 */
	@Override
	public String montarUrl(String url, String servidor, String dataBase, String urlFinal) {
		if (UtilObject.isNotEmpty(urlFinal))
			return montarUrl(urlFinal, servidor, dataBase) + urlFinal;
		return null;
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param url
	 * @param servidor
	 * @param porta
	 * @param dataBase
	 * @param urlFinal
	 * @return
	 */
	@Override
	public String montarUrl(String url, String servidor, int porta, String dataBase, String urlFinal) {
		if ((UtilObject.isNotEmpty(urlFinal)) && (porta > 0))
			return montarUrl(urlFinal, servidor, porta, dataBase) + urlFinal;
		return null;
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param caminho
	 * @param nome
	 * @param tipo
	 * @return
	 * @throws JsonSyntaxException
	 * @throws FileNotFoundException
	 */
	@Override
	public ConexaoBanco montarObjeto(String caminho, String nome, String tipo)
			throws JsonSyntaxException, FileNotFoundException {
		Conexao conexao = new Conexao();
		ConexaoBanco conexaoBanco = new ConexaoBanco();
		Gson gson = new Gson();
		conexao = gson.fromJson(JsonUtil.lerArquivoJson(caminho, nome), Conexao.class);

		if (tipo.equalsIgnoreCase("D"))
			conexaoBanco = getConexao(conexao, tipo, conexao.getBaseParaDados());
		else if (tipo.equalsIgnoreCase("I"))
			conexaoBanco = getConexao(conexao, tipo, conexao.getBaseParaImagem());
		if (conexao.getBaseParaDados().equalsIgnoreCase("sqlServer"))
			conexaoBanco.setUrl(montarUrl(conexaoBanco.getUrl() + "//", conexaoBanco.getServidor() + ";",
					"databaseName=" + conexaoBanco.getDataBase() + ";", conexaoBanco.getUrlFinal()));
		else if ((conexao.getBaseParaDados().equalsIgnoreCase("postgre"))
				|| (conexao.getBaseParaDados().equalsIgnoreCase("mySql")))
			conexaoBanco.setUrl(montarUrl(conexaoBanco.getUrl() + "//", conexaoBanco.getServidor() + ":",
					Integer.parseInt(conexaoBanco.getPorta()), "/" + conexaoBanco.getDataBase()));
		return conexaoBanco;
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param conexao
	 * @param tipo
	 * @param idConexao
	 * @return
	 */
	@Override
	public ConexaoBanco getConexao(Conexao conexao, String tipo, String idConexao) {
		for (ConexaoBanco conexaoBanco : conexao.getConexoes()) 
			if ((conexaoBanco.getIdConexao().indexOf(idConexao) >= 0)
					&& (tipo.equalsIgnoreCase(conexaoBanco.getTipo())))
				return conexaoBanco;
		return null;
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param caminho
	 * @param nome
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public Conexao getConexao(String caminho, String nome) throws NegocioException {
		try {
			return new Gson().fromJson(JsonUtil.lerArquivoJson(caminho, nome), Conexao.class);
		} catch (JsonSyntaxException e) {
			throw new NegocioException("Erro ao ler arquivo de configuração", "NG001");
		} catch (FileNotFoundException e) {
			throw new NegocioException("Arquivo de configuração não existe", "NG002");			
		}
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param conexao
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public boolean salvar(Conexao conexao) throws NegocioException {
		Gson gson = new Gson();	
		String json = "";
		json = gson.toJson(conexao);
		try {
			if (JsonUtil.gravarArquivoJson(json, "c:/salute/", "configDb.json"))
				return true;
		} catch (IOException e) {
			throw new NegocioException("Erro ao ler arquivo de configuração de banco de dados", "NG004");
		}
		return false;
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param conexao
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public boolean editar(Conexao conexao) throws NegocioException {
		return salvar(conexao);
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param conexao
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public boolean editar(ConexaoBanco conexao) throws NegocioException {
		Conexao conexaoPai = new Conexao();
		conexaoPai = getConexao("c:/salute/", "configDb.json");
		for (ConexaoBanco conexaoBanco : conexaoPai.getConexoes()) {
			if (conexaoBanco.getIdConexao().equalsIgnoreCase(conexao.getIdConexao())) {
				conexaoBanco = conexao;
				break;
			}
		}
		return salvar(conexaoPai);
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param conexoes
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public boolean salvar(List<ConexaoBanco> conexoes) throws NegocioException {
		Conexao conexao = new Conexao();
		conexao = getConexao("c:/salute/", "configDb.json");
		conexao.setConexoes(conexoes);
		return salvar(conexao);
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param caminho
	 * @param nome
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public List<ConexaoBanco> getConexoes(String caminho, String nome) throws NegocioException {
		Conexao conexao = new Conexao();
		conexao = getConexao(caminho, nome);
		return conexao.getConexoes();
	}

	/**
	 * Método responsável por 
	 * @author Djeison
	 * 17 de mai de 2019
	 * @param caminho
	 * @param nome
	 * @param idConexao
	 * @return
	 * @throws NegocioException
	 */
	@Override
	public ConexaoBanco getConexao(String caminho, String nome, String idConexao) throws NegocioException {
		Conexao conexao = new Conexao();
		conexao = getConexao(caminho, nome);
		for (ConexaoBanco conexaoBanco : conexao.getConexoes()) 
			if (conexaoBanco.getIdConexao().equalsIgnoreCase(idConexao))
				return conexaoBanco;
		throw new NegocioException("Dados de conexão inexistente", "NG003");
	}
	
	/**
	 * Método responsável por receber os dados de retorno das operações e validar o
	 * status e retornar o status validado
	 * 
	 * @author djeis 31 de out de 2017
	 * @param t
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public ResponseEntity<Map<String, Object>> getRetornoOperacoes(Conexao t) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("resposta", t);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}
	
	/**
	 * Método responsável por receber os dados de retorno das operações e validar o
	 * status e retornar o status validado
	 * 
	 * @author djeis 31 de out de 2017
	 * @param id
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public ResponseEntity<Map<String, Object>> getRetornoOperacoes(boolean status, String mensagem) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("mensagem", mensagem);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}

	
	/**
	 * Método responsável por receber os dados de retorno das operações e validar o
	 * status e retornar o status validado
	 * 
	 * @author djeis 31 de out de 2017
	 * @param t
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public ResponseEntity<Map<String, Object>> getRetornoOperacoes(ConexaoBanco t) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("resposta", t);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}

	/**
	 * Método responsável por receber os dados de retorno das operações e validar o
	 * status e retornar o status validado
	 * 
	 * @author djeis 31 de out de 2017
	 * @param codigo
	 * @param mensagem
	 * @param status
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public ResponseEntity<Map<String, Object>> getRetornoOperacoes(String codigo, String mensagem) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("resposta",
				new RetornoOperacoes(codigo, mensagem));
		return new ResponseEntity<>(mapa, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Método responsável por receber os dados de retorno das operações e validar o
	 * status e retornar o status validado
	 * 
	 * @author djeis 31 de out de 2017
	 * @param t
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public ResponseEntity<Map<String, Object>> getRetornoOperacoes(List<ConexaoBanco> t) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("resposta", t);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}

}
