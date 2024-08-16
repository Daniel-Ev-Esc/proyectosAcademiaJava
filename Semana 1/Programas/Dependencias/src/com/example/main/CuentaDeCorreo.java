package com.example.main;

import java.util.ArrayList;
import java.util.Iterator;

// Clase abstracta
public abstract class CuentaDeCorreo {
	
	// Contiene direccion y bandeja de entrada
	protected String direccion;	
	protected ArrayList<String> bandejaDeEntrada = new ArrayList<String>();
	
	// Constructor que toma el nombre
	public CuentaDeCorreo(String nombre) {
		this.direccion = nombre;
	}
	
	// Metodos abstractos que se modifican según la cuenta de correo
	abstract void setDireccion();	
	abstract void enviar(CuentaDeCorreo cc, String s);
	
	// Todas las cuentas añaden el correo recibido a la bandeja de entrada
	void recibir(String s) {
		this.bandejaDeEntrada.add(s);
	}
	
	// Todas las cuentas leen su bandeja de entrada de la misma manera
	void verCorreo() {
		
		System.out.println("---------------- Bandeja de entrada de: " + direccion +" ----------------");
		for (Iterator<String> iterator = bandejaDeEntrada.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		System.out.println("----------------------------------");
	}
}
