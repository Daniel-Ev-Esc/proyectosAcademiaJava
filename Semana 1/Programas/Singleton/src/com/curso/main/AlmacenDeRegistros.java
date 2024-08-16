package com.curso.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class AlmacenDeRegistros {
	
	// Clase singleton, contiene una instancia de si misma 
	static private AlmacenDeRegistros rg;
	private ArrayList<String> registrosDeUsuarios;
	
	// Constructor privado, inicia la lista de registros
	private AlmacenDeRegistros() {
		registrosDeUsuarios = new ArrayList<String>();
		registrosDeUsuarios.add("Registro de sistema:");
	};
	
	// Se obtiene la instancia del registro, si no existe se crea	
	static public AlmacenDeRegistros getRegistro() {
		
		if(rg == null)
			rg = new AlmacenDeRegistros();
		return 	rg;
	}
	
	// Se se guarda un registro de texto con su fecha de insersión
	public void addRegistro(String s) {
		registrosDeUsuarios.add("--" + new Date().toString() + ":");
		registrosDeUsuarios.add(s);
	}
	
	// Se despliega todo el historial del registro
	public void verRegistros() {
		for (Iterator<String> iterator = registrosDeUsuarios.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	}

}
