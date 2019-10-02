package com.financeiro.controlepessoal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.controlepessoal.entidade.AuditoriaEdicao;
import com.financeiro.controlepessoal.entidade.RespostaControle;
import com.financeiro.controlepessoal.enumerador.InformativoEnum;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.interfaces.controller.IControllerEntityFull;

/**
 * Classe responsável por
 * 
 * @author DEV 31 de mai de 2019
 */
@Controller
@RestController
public abstract class ControllerEntityFull<T extends AuditoriaEdicao> extends ControllerEntity<T>
		implements IControllerEntityFull<T> {

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> editar(T entidade, String token) {
		try {
			getService().editar(entidade, token);
			return getService().getRespostaControle(true, InformativoEnum.EDITADO_SUCESSO.getCodigo(),
					InformativoEnum.EDITADO_SUCESSO.getMensagem(""));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por editar a entidade passada por parametro
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidades
	 * @param token
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> editar(List<T> entidades, String token) {
		try {
			getService().editar(entidades, token);
			return getService().getRespostaControle(true, InformativoEnum.EDITADO_SUCESSO.getCodigo(),
					InformativoEnum.EDITADO_SUCESSO.getMensagem(""));
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(false, e.getCodigoException(), e.getMessage());
		}
	}

}
