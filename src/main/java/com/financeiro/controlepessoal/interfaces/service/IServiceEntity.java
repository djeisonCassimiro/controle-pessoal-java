package com.financeiro.controlepessoal.interfaces.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.controlepessoal.entidade.Auditoria;
import com.financeiro.controlepessoal.entidade.Usuario;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;

/**
 * Classe responsável por
 * 
 * @author DEV 27 de mai de 2019
 */
public interface IServiceEntity<T extends Auditoria> extends IService<T> {

	/**
	 * Método responsável por retornar a instancia de repositorio da classe
	 * manipulada
	 * 
	 * @author DEV 27 de mai de 2019
	 * @return repository
	 */
	public abstract JpaRepository<T, Long> getRepository();

	/**
	 * Método responsável por salvar e validar as regras de negocio da entidade
	 * passada
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract T salvar(T entidade, String token) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por salvar e validar as regras de negocio da entidade
	 * passada
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract List<T> salvar(List<T> entidades, String token) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param id
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract void excluir(Long id) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param emtidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract void excluir(T entidade) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract void excluir(List<T> entidades) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author DEV 27 de mai de 2019
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract void excluir() throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por listar todos os registros da entidade de manipulação
	 * 
	 * @author DEV 27 de mai de 2019
	 * @return List<T>
	 * @throws TransacoesBancoException
	 */
	public abstract List<T> listarTodos() throws TransacoesBancoException;

	/**
	 * Método responsável por consultar a entidade por id
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param id
	 * @return t
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract Optional<T> consultarPorId(Long id) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por validar se os dados obrigatorios para salvar a
	 * entidade estão preenchidos
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean dadosObrigatoriosPreenchidos(T entidade) throws NegocioException;

	/**
	 * Método responsável por montar os dados para salvar a entidade passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T montarDados(T entidade) throws NegocioException;

	/**
	 * Método responsável por montar os dados para salvar a entidades passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> montarDados(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por validar se a entidade que está prestes a ser salva já
	 * não está cadastrada
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteCadastro(T entidade) throws NegocioException;

	/**
	 * Método responsável por validar se a entidade que está prestes a ser salva já
	 * não está cadastrada
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteCadastro(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por validar se não há nenhum conflito na exclusão de uma
	 * entidade
	 * 
	 * @author DEV 27 de mai de 2019
	 * @param id
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteConflitoExclusao(Long id) throws NegocioException;

	/**
	 * Método responsável por validar se os dados obrigatorios de auditoria estão
	 * preenchidos
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean dadosObrigatoriosAuditoria(T entidade) throws NegocioException;

	/**
	 * Método responsável por limpar os dados de auditoria da entidade passada por
	 * pparametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T limparDadosAuditoria(T entidade) throws NegocioException;

	/**
	 * Método responsável por limpar os dados de auditoria da entidade passada por
	 * pparametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> limparDadosAuditoria(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por montar os dados de auditoria da entidade passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T montarDadosAuditoria(T entidade) throws NegocioException;

	/**
	 * Método responsável por montar os dados de auditoria das entidades passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> montarDadosAuditoria(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por montar os dados de auditoria da entidade passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @param usuario
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T montarDadosAuditoria(T entidade, Usuario usuario) throws NegocioException;

	/**
	 * Método responsável por montar os dados de auditoria das entidades passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @param usuario
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> montarDadosAuditoria(List<T> entidades, Usuario usuario) throws NegocioException;
}
