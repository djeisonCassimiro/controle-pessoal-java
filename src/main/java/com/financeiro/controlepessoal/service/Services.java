package com.financeiro.controlepessoal.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.financeiro.controlepessoal.entidade.RespostaControle;
import com.financeiro.controlepessoal.enumerador.InformativoEnum;
import com.financeiro.controlepessoal.excessao.NegocioException;
import com.financeiro.controlepessoal.excessao.TransacoesBancoException;
import com.financeiro.controlepessoal.interfaces.service.IService;
import com.financeiro.controlepessoal.util.UtilObject;

/**
 * Classe responsável por
 * 
 * @author DEV 31 de mai de 2019
 */
@Service
public abstract class Services<T extends Serializable> implements IService<T> {

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param id
	 * @param mensagem
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
 	public  ResponseEntity<Map<String, Object>> getRespostaControle(Long id, String mensagem)
			throws TransacoesBancoException, NegocioException {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("id", id);
		mapa.put("mensagem", mensagem);
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param status
	 * @param codigo
	 * @param mensagem
	 * @return ResponseEntity<RespostaControle>
	 */
	@Override
	public ResponseEntity<RespostaControle> getRespostaControle(boolean status, String codigo, String mensagem) {
		if (status)
			return new ResponseEntity<>(new RespostaControle(codigo, mensagem), HttpStatus.OK);
		return new ResponseEntity<>(new RespostaControle(codigo, mensagem), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author Djeison 27 de jun de 2019
	 * @param status
	 * @param codigo
	 * @param mensagem
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public ResponseEntity<Map<String, Object>> getRespostaControleInfo(boolean status, String codigo, String mensagem)
			throws TransacoesBancoException, NegocioException {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("codigo", codigo);
		mapa.put("mensagem", mensagem);
		if (status)
			return new ResponseEntity<>(mapa, HttpStatus.OK);
		return new ResponseEntity<>(mapa, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public ResponseEntity<Map<String, Object>> getRespostaControle(T entidade)
			throws TransacoesBancoException, NegocioException {
		Map<String, Object> mapa = new HashMap<>();
		if (UtilObject.isNotNull(entidade)) {
			if (UtilObject.isNotEmpty(getNomeEntidade()))
				mapa.put(getNomeEntidade(), entidade);
			else
				mapa.put(entidade.getClass().getName(), entidade);
		} else
			mapa.put(InformativoEnum.SEM_REGISTROS.getCodigo(), InformativoEnum.SEM_REGISTROS.getMensagem(""));
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}
	
	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidade
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public ResponseEntity<Map<String, Object>> getRespostaControle(Optional<T>  entidade)
			throws TransacoesBancoException, NegocioException {
		Map<String, Object> mapa = new HashMap<>();
		if (UtilObject.isNotNull(entidade)) {
			if (UtilObject.isNotEmpty(getNomeEntidade()))
				mapa.put(getNomeEntidade(), entidade.get());
			else
				mapa.put(entidade.getClass().getName(), entidade);
		} else
			mapa.put(InformativoEnum.SEM_REGISTROS.getCodigo(), InformativoEnum.SEM_REGISTROS.getMensagem(""));
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param entidades
	 * @return ResponseEntity<Map<String, Object>>
	 * @throws TransacoesBancoException
	 * @throws NegocioException
	 */
	@Override
	public ResponseEntity<Map<String, Object>> getRespostaControle(List<T> entidades)
			throws TransacoesBancoException, NegocioException {
		Map<String, Object> mapa = new HashMap<>();
		if (entidades.size() > 0) {
			if (UtilObject.isNotEmpty(getNomeEntidade()))
				mapa.put(getNomeEntidade(), entidades);
			else
				mapa.put(entidades.get(entidades.size() - 1).getClass().getName(), entidades);
		} else
			mapa.put(InformativoEnum.SEM_REGISTROS.getCodigo(), InformativoEnum.SEM_REGISTROS.getMensagem(""));
		return new ResponseEntity<>(mapa, HttpStatus.OK);
	}

	/**
	 * Método responsável por validar os dados de retorno da camada de controlle da
	 * aplicação
	 * 
	 * @author DEV 31 de mai de 2019
	 * @param codigo
	 * @param mensagem
	 * @return ResponseEntity<Map<String, Object>>
	 */
	@Override
	public ResponseEntity<Map<String, Object>> getRespostaControle(String codigo, String mensagem) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("ERRO", new RespostaControle(codigo, mensagem));
		return new ResponseEntity<>(mapa, HttpStatus.BAD_REQUEST);
	}
}
