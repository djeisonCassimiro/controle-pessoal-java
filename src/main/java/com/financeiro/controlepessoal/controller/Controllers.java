package com.financeiro.controlepessoal.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.interfaces.controller.IController;

/**
 * Classe responsável por
 * 
 * @author DEV 31 de mai de 2019
 */
@Controller
@RestController
public abstract class Controllers<T extends Serializable> implements IController<T> {

	/**
	 * Método responsável por montar as respostas da camada de controle
	 * 
	 * @author DEV 14 de jun de 2019
	 * @param entidades
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public ResponseEntity<Map<String, Object>> montarRespostaController(List<T> entidades) {
		try {
			return getService().getRespostaControle(entidades);
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}

	/**
	 * Método responsável por montar as respostas da camada de controle
	 * 
	 * @author DEV 14 de jun de 2019
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 */
	public ResponseEntity<Map<String, Object>> montarRespostaController(T entidade) {
		try {
			return getService().getRespostaControle(entidade);
		} catch (TransacoesBancoException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		} catch (NegocioException e) {
			return getService().getRespostaControle(e.getCodigoException(), e.getMessage());
		}
	}
}
