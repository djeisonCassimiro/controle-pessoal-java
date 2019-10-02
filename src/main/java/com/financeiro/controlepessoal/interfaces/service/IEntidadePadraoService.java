package com.financeiro.controlepessoal.interfaces.service;

import java.util.List;

import com.financeiro.controlepessoal.entidade.EntidadePadrao;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.repository.EntidadePadraoRepository;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de jun de 2019
 */
public interface IEntidadePadraoService<T extends EntidadePadrao> extends IServiceEntityFull<T> {

	/**
	 * Método responsável por retornar a instancia de repositorio da entidade
	 * manipulada
	 * 
	 * @author Djeison 27 de jun de 2019
	 * @return repository
	 */
	public abstract EntidadePadraoRepository<T> getRepository();

	/**
	 * Método responsável por consultar entidade por descrição
	 * 
	 * @author DEV 3 de jun de 2019
	 * @param descricao
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract T consultarGrupoPorDescricao(String descricao) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por consultar entidade por descrição e status desativado
	 * 
	 * @author DEV 3 de jun de 2019
	 * @param descricao
	 * @param desativado
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract T consultarGrupoPorDescricao(String descricao, String desativado)
			throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por pesquisar entidades por descrição
	 * 
	 * @author DEV 3 de jun de 2019
	 * @param descricao
	 * @return entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract List<T> pesquisarGruposPorDescricao(String descricao)
			throws TransacoesBancoException, NegocioException;

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
	public abstract List<T> pesquisarGruposPorDescricao(String descricao, String desativado)
			throws TransacoesBancoException, NegocioException;
}