package com.financeiro.controlepessoal.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.financeiro.controlepessoal.entidade.AuditoriaEdicao;
import com.financeiro.controlepessoal.entidade.Usuario;
import com.financeiro.controlepessoal.enumerador.NegocioExceptionEnum;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.interfaces.service.IServiceEntityFull;
import com.financeiro.controlepessoal.util.UtilObject;
import com.financeiro.controlepessoal.util.ValidacoesUtil;

/**
 * Classe responsável por
 * 
 * @author DEV 29 de mai de 2019
 */
@Service
public abstract class ServiceEntityFull<T extends AuditoriaEdicao> extends ServiceEntity<T>
		implements IServiceEntityFull<T> {

	/**
	 * Método responsável por editar e validar as regras de edição da entidade de
	 * manupulação
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return t
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public T editar(T entidade, String token) throws TransacoesBancoException, NegocioException {
		if (naoExisteDuplicidadeCadastro(entidade))
			return getRepository().save(entidade);
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getMensagem(""));
	}

	/**
	 * Método responsável por editar e validar as regras de edição da entidade de
	 * manupulação
	 * 
	 * @author DEV 29 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return entidades
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public List<T> editar(List<T> entidades, String token) throws TransacoesBancoException, NegocioException {
		if (naoExisteDuplicidadeCadastro(entidades))
			return getRepository().saveAll(entidades);

		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getMensagem(""));

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
	public boolean dadosObrigatoriosAuditoriaEdicao(T entidade) throws NegocioException {
		String campos = "";
		if (super.dadosObrigatoriosAuditoria(entidade)) {
			if (UtilObject.isNull(entidade.getDataEdicao()))
				campos = ValidacoesUtil.concatenaStringParaMensagens(campos, "data de edição");
			if (UtilObject.isNull(entidade.getUsuarioEdicao()))
				campos = ValidacoesUtil.concatenaStringParaMensagens(campos, "usuario de edição");
		}
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
		entidade = super.limparDadosAuditoria(entidade);
		entidade.setDataEdicao(null);
		entidade.setUsuarioEdicao(null);
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
	public T montarDadosAuditoriaEdicao(T entidade) throws NegocioException {
		entidade.setDataEdicao(new Date(System.currentTimeMillis()).getTime());
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
	public List<T> montarDadosAuditoriaEdicao(List<T> entidades) throws NegocioException {
		for (T t : entidades)
			t = montarDadosAuditoriaEdicao(t);
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
	public T montarDadosAuditoriaEdicao(T entidade, Usuario usuario) throws NegocioException {
		entidade = montarDadosAuditoriaEdicao(entidade);
		entidade.setUsuarioEdicao(usuario);
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
	public List<T> montarDadosAuditoriaEdicao(List<T> entidades, Usuario usuario) throws NegocioException {
		for (T t : entidades)
			t = montarDadosAuditoriaEdicao(t);
		return entidades;
	}

	/**
	 * Método responsável por validar se a entidade não está sendo editada para uma
	 * outra ja existente
	 * 
	 * @author DEV 5 de jun de 2019
	 * @param entidade
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteDuplicidadeCadastro(T entidade) throws NegocioException {
		return true;
	}

	/**
	 * Método responsável por validar se a entidade não está sendo editada para uma
	 * outra ja existente
	 * 
	 * @author DEV 5 de jun de 2019
	 * @param entidades
	 * @return boolean
	 * @throws NegocioException
	 */
	@Override
	public boolean naoExisteDuplicidadeCadastro(List<T> entidades) throws NegocioException {
		for (T entidade : entidades)
			naoExisteDuplicidadeCadastro(entidade);
		return true;
	}

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
	@Override
	public boolean naoExisteDuplicidadeCadastro(T entidadeBanco, T entidade, String nomeEntidade)
			throws NegocioException {
		if (UtilObject.isNull(entidadeBanco))
			return true;
		if (entidadeBanco.getId().equals(entidade.getId()))
			return true;
		throw new NegocioException(NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getCodigo(),
				NegocioExceptionEnum.EXISTE_CADASTRO_EDICAO.getMensagem("entidade"));
	}
}