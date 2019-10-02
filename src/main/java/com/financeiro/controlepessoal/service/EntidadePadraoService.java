package com.financeiro.controlepessoal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.financeiro.controlepessoal.entidade.EntidadePadrao;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.interfaces.service.IEntidadePadraoService;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de jun de 2019
 */
@Service
public abstract class EntidadePadraoService<T extends EntidadePadrao> extends ServiceEntityFull<T>
		implements IEntidadePadraoService<T> {

	/**
	 * Método responsável por consultar entidade por descrição
	 * 
	 * @author Djeison 27 de jun de 2019
	 * @param descricao
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public T consultarGrupoPorDescricao(String descricao) throws TransacoesBancoException, NegocioException {
		return getRepository().findByDescricaoIgnoreCaseLikeOrderByDescricaoAsc(descricao);
	}

	/**
	 * Método responsável por consultar entidade por descrição e status desativado
	 * 
	 * @author Djeison 27 de jun de 2019
	 * @param descricao
	 * @param desativado
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public T consultarGrupoPorDescricao(String descricao, String desativado)
			throws TransacoesBancoException, NegocioException {
		return getRepository().findByDescricaoIgnoreCaseLikeAndDesativadoIgnoreCaseLikeOrderByDescricaoAsc(descricao,
				desativado);
	}

	/**
	 * Método responsável por pesquisar entidades por descrição
	 * 
	 * @author Djeison 27 de jun de 2019
	 * @param descricao
	 * @return entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public List<T> pesquisarGruposPorDescricao(String descricao) throws TransacoesBancoException, NegocioException {
		return getRepository().findByDescricaoIgnoreCaseContainingOrderByDescricaoAsc(descricao);
	}

	/**
	 * Método responsável por pesquisar entidades por descrição e status desativado
	 * 
	 * @author Djeison 27 de jun de 2019
	 * @param descricao
	 * @param desativado
	 * @return entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public List<T> pesquisarGruposPorDescricao(String descricao, String desativado)
			throws TransacoesBancoException, NegocioException {
		return getRepository().findByDescricaoIgnoreCaseContainingAndDesativadoIgnoreCaseLikeOrderByDescricaoAsc(
				descricao, desativado);
	}
}