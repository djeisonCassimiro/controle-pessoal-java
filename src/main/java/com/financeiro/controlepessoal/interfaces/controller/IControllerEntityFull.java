package com.financeiro.controlepessoal.interfaces.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.financeiro.controlepessoal.entidade.AuditoriaEdicao;
import com.financeiro.controlepessoal.entidade.RespostaControle;
import com.financeiro.controlepessoal.service.ServiceEntityFull;

/**
 * Classe responsável por
 * 
 * @author DEV 31 de mai de 2019
 */
public interface IControllerEntityFull<T extends AuditoriaEdicao> extends IControllerEntity<T> {
	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> editar(T entidade, String token);

	/**
	 * Método responsável por editar as entidades passadas por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	public abstract ResponseEntity<RespostaControle> editar(List<T> entidades, String token);

	/**
	 * Método responsável por retornar a classe de serviço responsável por validar a
	 * classe de controle atual
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return service
	 */
	public abstract ServiceEntityFull<T> getService();
}
