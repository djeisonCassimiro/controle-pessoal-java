package com.financeiro.controlepessoal.util;

/**
 * Classe responsável por
 * 
 * @author Djeison 17 de mai de 2019
 */
public class UtilObject {

	public static boolean isNull(Object object) {
		try {
			return object == null;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static boolean isNotNull(Object object) {
		try {
			return !isNull(object);
		} catch (NullPointerException e) {
			return false;
		}

	}

	public static boolean isEmpty(String valor) {

		return (isNull(valor) || valor.trim().isEmpty());

	}

	public static boolean isNotEmpty(String valor) {

		return !(isNull(valor) || valor.trim().isEmpty());

	}

}