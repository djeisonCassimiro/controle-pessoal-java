package com.financeiro.controlepessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.controlepessoal.entidade.EntidadePadrao;

/**
 * Classe responsável por
 * 
 * @author DEV 28 de jun de 2019
 */
@Repository
public interface EntidadePadraoRepository<T extends EntidadePadrao> extends JpaRepository<T, Long> {

	/**
	 * Método responsável por pesquisar entidade por descricao
	 * 
	 * @author Djeison 26 de jun de 2019
	 * @param descricao
	 * @return entidades
	 */
	List<T> findByDescricaoIgnoreCaseContainingOrderByDescricaoAsc(String descricao);

	/**
	 * Método responsável por pesquisar entidade por descricao e status desativado
	 * 
	 * @author Djeison 26 de jun de 2019
	 * @param descricao
	 * @param desativado
	 * @return entidades
	 */
	List<T> findByDescricaoIgnoreCaseContainingAndDesativadoIgnoreCaseLikeOrderByDescricaoAsc(String descricao,
			String desativado);

	/**
	 * Método responsável por consultar entidade por descricao
	 * 
	 * @author Djeison 26 de jun de 2019
	 * @param descricao
	 * @return entidade
	 */
	T findByDescricaoIgnoreCaseLikeOrderByDescricaoAsc(String descricao);

	/**
	 * Método responsável por consultar entidade por descricao e status desativado
	 * 
	 * @author Djeison 26 de jun de 2019
	 * @param descricao
	 * @param desativado
	 * @return entidade
	 */
	T findByDescricaoIgnoreCaseLikeAndDesativadoIgnoreCaseLikeOrderByDescricaoAsc(String descricao, String desativado);
}