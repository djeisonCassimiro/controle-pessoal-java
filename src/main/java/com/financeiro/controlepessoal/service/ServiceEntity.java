package com.financeiro.controlepessoal.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.financeiro.controlepessoal.entidade.Auditoria;
import com.financeiro.controlepessoal.entidade.Usuario;
import com.financeiro.controlepessoal.enumerador.NegocioExceptionEnum;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.interfaces.service.IServiceEntity;
import com.financeiro.controlepessoal.util.UtilObject;
import com.financeiro.controlepessoal.util.ValidacoesUtil;

/**
 * Classe responsável por
 * 
 * @author Djeison 17 de mai de 2019
 */
@Service
public abstract class ServiceEntity<T extends Auditoria> extends Services<T> implements IServiceEntity<T> {

	/**
	 * Método responsável por salvar e validar as regras de gravação da entidade de
	 * manupulação
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public T salvar(T entidade, String token) throws TransacoesBancoException, NegocioException {
		if (naoExisteCadastro(entidade))
			return getRepository().save(entidade);
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO.getMensagem(""));
	}

	/**
	 * Método responsável por salvar e validar as regras de gravação da entidade de
	 * manupulação
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public List<T> salvar(List<T> entidades, String token) throws TransacoesBancoException, NegocioException {
		//entidades = montarDados(entidades);
		if (naoExisteCadastro(entidades))
			return getRepository().saveAll(entidades);
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO.getMensagem(""));
	}

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param id
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public void excluir(Long id) throws TransacoesBancoException, NegocioException {
		if (naoExisteConflitoExclusao(id))
			getRepository().deleteById(id);
		else
			throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO.getCodigo(),
					NegocioExceptionEnum.EXISTE_CADASTRO.getMensagem(""));
	}

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public void excluir(T entidade) throws TransacoesBancoException, NegocioException {
		if (naoExisteConflitoExclusao(entidade.getId()))
			getRepository().delete(entidade);
		else
			throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO.getCodigo(),
					NegocioExceptionEnum.EXISTE_CADASTRO.getMensagem(""));
	}

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public void excluir(List<T> entidades) throws TransacoesBancoException, NegocioException {
		getRepository().deleteAll(entidades);
	}

	/**
	 * Método responsável por excluir e validar as regras de exclusão da entidade de
	 * manupulação
	 * 
	 * @author DEV 28 de mai de 2019
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public void excluir() throws TransacoesBancoException, NegocioException {
		getRepository().deleteAll();
	}

	/**
	 * Método responsável por listar todos os registros da entidade de manipulação
	 * 
	 * @author DEV 28 de mai de 2019
	 * @return entidades
	 * @throws TransacoesBancoException
	 */
	@Override
	public List<T> listarTodos() throws TransacoesBancoException {
		return getRepository().findAll();
	}

	/**
	 * Método responsável por consultar a entidade por id
	 * 
	 * @author DEV 28 de mai de 2019
	 * @param id
	 * @return entidade
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public Optional<T> consultarPorId(Long id) throws TransacoesBancoException, NegocioException {
		return getRepository().findById(id);
	}

	/**
	 * Método responsável por validar se os dados obrigatorios de auditoria estão
	 * preenchidos
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	public boolean dadosObrigatoriosAuditoria(T entidade) throws NegocioException {
		String campos = "";
		if (UtilObject.isNull(entidade.getDataCadastro()))
			campos = ValidacoesUtil.concatenaStringParaMensagens(campos, "data de cadastro");
		if (UtilObject.isNull(entidade.getUsuarioCadastro()))
			campos = ValidacoesUtil.concatenaStringParaMensagens(campos, "usuario de cadastro");
		if (UtilObject.isNotEmpty(campos))
			throw new NegocioException(NegocioExceptionEnum.DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getCodigo(),
					NegocioExceptionEnum.DADOS_OBRIGATORIOS_NAO_PREENCHIDOS.getMensagem(campos));
		return true;
	}

	/**
	 * Método responsável por limpar os dados de auditoria da entidade passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public T limparDadosAuditoria(T entidade) throws NegocioException {
		entidade.setDataCadastro(null);
		entidade.setUsuarioCadastro(null);
		return entidade;
	}

	/**
	 * Método responsável por limpar os dados de auditoria da entidade passada por
	 * pparametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public List<T> limparDadosAuditoria(List<T> entidades) throws NegocioException {
		for (T t : entidades)
			t = limparDadosAuditoria(t);
		return entidades;
	}

	/**
	 * Método responsável por montar os dados de auditoria da entidade passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @return entidade
	 * @throws NegocioException
	 */
	public T montarDadosAuditoria(T entidade) throws NegocioException {
		entidade.setDataCadastro(new Date(System.currentTimeMillis()).getTime());
		return entidade;
	}

	/**
	 * Método responsável por montar os dados de auditoria das entidades passada por
	 * parametro
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	public List<T> montarDadosAuditoria(List<T> entidades) throws NegocioException {
		for (T t : entidades)
			t = montarDadosAuditoria(t);
		return entidades;
	}

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
	public T montarDadosAuditoria(T entidade, Usuario usuario) throws NegocioException {
		entidade = montarDadosAuditoria(entidade);
		entidade.setUsuarioCadastro(usuario);
		return entidade;
	}

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
	public List<T> montarDadosAuditoria(List<T> entidades, Usuario usuario) throws NegocioException {
		for (T entidade : entidades)
			entidade = montarDadosAuditoria(entidade, usuario);
		return entidades;
	}

	/**
	 * Método responsável por validar se não há nenhum conflito na exclusão de uma
	 * entidade
	 * 
	 * @author DEV 4 de jun de 2019
	 * @param id
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteConflitoExclusao(Long id) throws NegocioException {
		return true;
	}

	/**
	 * Método responsável por validar se a entidade que está prestes a ser salva já
	 * não está cadastrada
	 * 
	 * @author DEV 4 de jun de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteCadastro(T entidade) throws NegocioException {
		return true;
	}

	/**
	 * Método responsável por validar se a entidade que está prestes a ser salva já
	 * não está cadastrada
	 * 
	 * @author DEV 4 de jun de 2019
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteCadastro(List<T> entidades) throws NegocioException {
		for (T entidade : entidades) 
			naoExisteCadastro(entidade);		
		return true;
	}
	
	/**
	 * Método responsável por montar os dados para salvar a entidade passada por
	 * parametro
	 * 
	 * @author DEV 4 de jun de 2019
	 * @param entidades
	 * @return entidade
	 * @throws NegocioException
	 */
	@Override
	public T montarDados(T entidade) throws NegocioException {
		return montarDadosAuditoria(entidade);
	}

	/**
	 * Método responsável por montar os dados para salvar a entidade passada por
	 * parametro
	 * 
	 * @author DEV 4 de jun de 2019
	 * @param entidades
	 * @return entidades
	 * @throws NegocioException
	 */
	@Override
	public List<T> montarDados(List<T> entidades) throws NegocioException {
		for (T entidade : entidades)
			entidade = montarDados(entidade);
		return entidades;
	}
	
	/**
	 * Método responsável por validar se os dados obrigatorios para salvar a
	 * entidade estão preenchidos
	 * 
	 * @author DEV 4 de jun de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean dadosObrigatoriosPreenchidos(T entidade) throws NegocioException {
		return dadosObrigatoriosAuditoria(entidade);
	}
}
