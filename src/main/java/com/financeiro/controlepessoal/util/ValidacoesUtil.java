package com.financeiro.controlepessoal.util;

import java.text.Normalizer;

/**
 * Classe responsável por
 * 
 * @author DEV 29 de mai de 2019
 */
public class ValidacoesUtil {

	/**
	 * Método responsável por receber partes de mensagens a serem concatenadas e
	 * retornar uma mensagem formatada corretamente
	 * 
	 * @author djeis 31 de jul de 2017
	 * @param msgIni
	 * @param msgFim
	 * @return mensagem
	 */
	public static String concatenaStringParaMensagens(String msgIni, String msgFim) {
		if (UtilObject.isEmpty(msgIni))
			return msgFim;
		else
			return msgIni + ", " + msgFim;
	}

	/**
	 * Método responsável por remover os acentos de uma string
	 * 
	 * @author djeis 31 de jul de 2017
	 * @param str
	 * @return str
	 */
	public static String removeAcentos(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return str;
	}
}
