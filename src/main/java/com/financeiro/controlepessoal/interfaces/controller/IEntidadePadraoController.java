package com.financeiro.controlepessoal.interfaces.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.financeiro.controlepessoal.entidade.EntidadePadrao;
import com.financeiro.controlepessoal.service.EntidadePadraoService;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de jun de 2019
 */
public interface IEntidadePadraoController<T extends EntidadePadrao> extends IControllerEntityFull<T> {

	/**
	 * Método responsável por pesquisar entidades por descrição
	 * 
	 * @author DEV 3 de jun de 2019
	 * @param descricao
	 * @return entidades
	 */
	public abstract ResponseEntity<Map<String, Object>> pesquisarGruposPorDescricao(String descricao);

	/**
	 * Método responsável por pesquisar entidades por descrição e status desativado
	 * 
	 * @author DEV 3 de jun de 2019
	 * @param descricao
	 * @param desativado
	 * @return entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract ResponseEntity<Map<String, Object>> pesquisarGruposPorDescricao(String descricao,
			String desativado);

	/**
	 * Método responsável por
	 * 
	 * @author DEV 19 de jun de 2019
	 * @return
	 */
	public EntidadePadraoService<T> getService();
}