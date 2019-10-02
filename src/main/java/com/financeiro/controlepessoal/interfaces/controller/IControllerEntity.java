package com.financeiro.controlepessoal.interfaces.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.financeiro.controlepessoal.entidade.Auditoria;
import com.financeiro.controlepessoal.entidade.RespostaControle;
import com.financeiro.controlepessoal.service.ServiceEntity;

/**
 * Classe responsável por
 * 
 * @author DEV 31 de mai de 2019
 */
public interface IControllerEntity<T extends Auditoria> extends IController<T> {

	/**
	 * Método responsável por salvar a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> salvar(T entidade, String token);

	/**
	 * Método responsável por salvar as entidades passadas por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> salvar(List<T> entidades, String token);

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param id
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> excluir(Long id, String token);

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> excluir(T entidade, String token);

	/**
	 * Método responsável por excluir as entidades passadas por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> excluir(List<T> entidades, String token);

	/**
	 * Método responsável por excluir todas as entidades cadastradas
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> excluir(String token);

	/**
	 * Método responsável por listar todas as entidades
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> listarTodos();

	/**
	 * Método responsável por realizar a consulta da entidade por id
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param id
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public abstract ResponseEntity<Map<String, Object>> consultarPorId(Long id);

	/**
	 * Método responsável por retornar a classe de serviço responsável por validar a
	 * classe de controle atual
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return service
	 */
	public abstract ServiceEntity<T> getService();
}
