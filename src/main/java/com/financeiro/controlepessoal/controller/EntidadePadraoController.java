package com.financeiro.controlepessoal.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.financeiro.controlepessoal.entidade.EntidadePadrao;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.interfaces.controller.IEntidadePadraoController;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de jun de 2019
 */
public abstract class EntidadePadraoController<T extends EntidadePadrao> extends ControllerEntityFull<T>
		implements IEntidadePadraoController<T> {

	/**
	 * Método responsável por pesquisar entidades por descrição
	 * 
	 * @author DEV 28 de jun de 2019
	 * @param descricao
	 * @return entidades
	 */
	@Override
	public ResponseEntity<Map<String, Object>> pesquisarGruposPorDescricao(String descricao) {
		try {
			return getService().getRespostaControle(getService().pesquisarGruposPorDescricao(descricao));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por pesquisar entidades por descrição e status desativado
	 * 
	 * @author DEV 28 de jun de 2019
	 * @param descricao
	 * @param desativado
	 * @return entidades
	 */
	@Override
	public ResponseEntity<Map<String, Object>> pesquisarGruposPorDescricao(String descricao, String desativado) {
		try {
			return getService().getRespostaControle(getService().pesquisarGruposPorDescricao(descricao, desativado));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
