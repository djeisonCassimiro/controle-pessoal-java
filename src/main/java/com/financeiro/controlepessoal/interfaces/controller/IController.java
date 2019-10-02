package com.financeiro.controlepessoal.interfaces.controller;

import java.io.Serializable;

import com.financeiro.controlepessoal.service.Services;

/**
 * Classe responsável por
 * 
 * @author DEV 31 de mai de 2019
 */
public interface IController<T extends Serializable> {

	/**
	 * Método responsável por retornar a classe de serviço responsável por validar a
	 * classe de controle atual
	 * 
	 * @author DEV 31 de mai de 2019
	 * @return service
	 */
	public abstract Services<T> getService();

}
