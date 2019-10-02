package com.financeiro.controlepessoal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.controlepessoal.entidade.Auditoria;
import com.financeiro.controlepessoal.entidade.RespostaControle;
import com.financeiro.controlepessoal.enumerador.InformativoEnum;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.interfaces.controller.IControllerEntity;

/**
 * Classe responsável por
 * 
 * @author DEV 31 de mai de 2019
 */
@Controller
@RestController
@CrossOrigin(origins = "*")
public abstract class ControllerEntity<T extends Auditoria> extends Controllers<T> implements IControllerEntity<T> {

	/**
	 * Método responsável por salvar a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> salvar(T entidade, String token) {
		try {
			return getService().getRespostaControle(getService().salvar(entidade, token));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por salvar as entidades passadas por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> salvar(List<T> entidades, String token) {
		try {
			return getService().getRespostaControle(getService().salvar(entidades, token));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param id
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> excluir(Long id, String token) {
		try {
			getService().excluir(id);
			return getService().getRespostaControle(true, InformativoEnum.EXCLUIDO_SUCESSO.getCodigo(),
					InformativoEnum.EXCLUIDO_SUCESSO.getMensagem(""));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por excluir a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> excluir(T entidade, String token) {
		try {
			getService().excluir(entidade);
			return getService().getRespostaControle(true, InformativoEnum.EXCLUIDO_SUCESSO.getCodigo(),
					InformativoEnum.EXCLUIDO_SUCESSO.getMensagem(""));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por excluir as entidades passadas por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> excluir(List<T> entidades, String token) {
		try {
			getService().excluir(entidades);
			return getService().getRespostaControle(true, InformativoEnum.EXCLUIDO_SUCESSO.getCodigo(),
					InformativoEnum.EXCLUIDO_SUCESSO.getMensagem(""));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por excluir todas as entidades cadastradas
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> excluir(String token) {
		try {
			getService().excluir();
			return getService().getRespostaControle(true, InformativoEnum.EXCLUIDO_SUCESSO.getCodigo(),
					InformativoEnum.EXCLUIDO_SUCESSO.getMensagem(""));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por listar todas as entidades
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> listarTodos() {
		try {
			return getService().getRespostaControle(getService().listarTodos());
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por realizar a consulta da entidade por id
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param id
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> consultarPorId(Long id) {
		try {
			return getService().getRespostaControle(getService().consultarPorId(id));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
