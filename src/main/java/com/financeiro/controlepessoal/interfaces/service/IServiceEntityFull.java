package com.financeiro.controlepessoal.interfaces.service;

import java.util.List;

import com.financeiro.controlepessoal.entidade.AuditoriaEdicao;
import com.financeiro.controlepessoal.entidade.Usuario;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;

/**
 * Classe responsável por
 * 
 * @author DEV 27 de mai de 2019
 */
public interface IServiceEntityFull<T extends AuditoriaEdicao> extends IServiceEntity<T> {

	/**
	 * Método responsável por editar e entidade passada por parametro
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract T editar(T entidade, String token) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por editar e entidade passada por parametro
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	public abstract List<T> editar(List<T> entidades, String token) throws TransacoesBancoException, NegocioException;

	/**
	 * Método responsável por se os dados obrigatorios para editar a entidade estão
	 * preenchidos
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean dadosObrigatoriosEdicaoPreenchidos(T entidade) throws NegocioException;

	/**
	 * Método responsável por verificar se a edição da entidade irá gerar uma
	 * duplicidade no banco
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteDuplicidadeCadastro(T entidade) throws NegocioException;

	/**
	 * Método responsável por verificar se a edição da entidade irá gerar uma
	 * duplicidade no banco
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteDuplicidadeCadastro(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por validar se a entidade não está sendo editada para uma
	 * outra ja existente
	 * 
	 * @author DEV 6 de jun de 2019
	 * @param entidadeBanco
	 * @param entidade
	 * @param nomeEntidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean naoExisteDuplicidadeCadastro(T entidadeBanco, T entidade, String nomeEntidade)
			throws NegocioException;

	/**
	 * Método responsável por validar se os dados obrigatorios de auditoria estão
	 * preenchidos
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public abstract boolean dadosObrigatoriosAuditoriaEdicao(T entidade) throws NegocioException;

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
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> limparDadosAuditoria(List<T> entidades) throws NegocioException;

	/**
	 * Método responsável por montar os dados de auditoria da entidade passada por
	 * parametro que será editada
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T montarDadosAuditoriaEdicao(T entidade) throws NegocioException;

	/**
	 * Método responsável por montar os dados da entidade passada por parametro que
	 * será editada
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public abstract T montarDadosEdicao(T entidade) throws NegocioException;

	/**
	 * Método responsável por montar os dados de auditoria das entidades passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public abstract List<T> montarDadosAuditoriaEdicao(List<T> entidades) throws NegocioException;

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
	public abstract T montarDadosAuditoriaEdicao(T entidade, Usuario usuario) throws NegocioException;

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
	public abstract List<T> montarDadosAuditoriaEdicao(List<T> entidades, Usuario usuario) throws NegocioException;
}
