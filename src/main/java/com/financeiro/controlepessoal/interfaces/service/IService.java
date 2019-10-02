package com.financeiro.controlepessoal.interfaces.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.financeiro.controlepessoal.entidade.RespostaControle;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;

/**
* Classe responsável por
* 
* @author DEV 31 de mai de 2019
*/
public interface IService<T extends Serializable> {

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param id
	 * @param mensagem
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(Long id, String mensagem)
			throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param status
	 * @param codigo
	 * @param mensagem
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> getRespostaControle(boolean status, String codigo,
			String mensagem);

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 27 de jun de 2019
	 * @param status
	 * @param codigo
	 * @param mensagem
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public ResponseEntity<Map<String, Object>> getRespostaControleInfo(boolean status, String codigo, String mensagem)
			throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(T entidade)
			throws TransacoesBancoException, NegocioException;
	
	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(Optional<T> entidade)
			throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidades
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(List<T> entidades)
			throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param codigo
	 * @param mensagem
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> getRespostaControle(String codigo, String mensagem);

	/**
	 * Método responsável por retornar o nome da entidade de manipulação
	 * 
	 * @author DEV 3 de jul de 2019
	 * @return nomeEntidade
	 */
	public abstract String getNomeEntidade();

	/**
	 * Método responsável por validar se o caixa está aberto ou não
	 * 
	 * @author DEV 3 de jul de 2019
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean caixaIsAberto() throws NegocioException, TransacoesBancoException;
	
	/**
	 * Método responsável por validar se o caixa está aberto
	 * 
	 * @author Djeison 26 de jun de 2019
	 * @return boolean
	 * @throws NegocioException
	 * @throws TransacoesBancoException
	 */
	public abstract boolean validarCaixaAberto() throws NegocioException, TransacoesBancoException;
}
