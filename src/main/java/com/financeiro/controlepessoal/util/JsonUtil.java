package com.financeiro.controlepessoal.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Classe responsável por 
 * @author Djeison
 * 17 de mai de 2019
 */
public class JsonUtil {
	
	public static JsonObject lerArquivoJson(String caminho, String nome) throws FileNotFoundException {
		JsonObject jsonObject = new JsonObject();
		Gson gson = new Gson();
		jsonObject = gson.fromJson(new FileReader(caminho + nome), JsonObject.class);		
		return jsonObject;
	}
	
	public static boolean gravarArquivoJson(String jsonObject, String caminho, String nome) throws IOException {
		FileWriter fileWriter = new FileWriter(caminho+nome);
		fileWriter.write(jsonObject);
		fileWriter.close();
		return true;
	}
}
