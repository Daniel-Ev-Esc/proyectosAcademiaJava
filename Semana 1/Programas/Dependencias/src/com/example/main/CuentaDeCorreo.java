package com.example.main;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class CuentaDeCorreo {
	
	String direccion;	
	ArrayList<String> bandejaDeEntrada = new ArrayList<String>();
	
	public CuentaDeCorreo(String nombre) {
		this.direccion = nombre;
	}
	
	abstract void setDireccion();	
	abstract void enviar(CuentaDeCorreo cc, String s);
	
	void recibir(String s) {
		this.bandejaDeEntrada.add(s);
	}
	
	void verCorreo() {
		
		System.out.println("---------------- Bandeja de entrada de: " + direccion +" ----------------");
		for (Iterator<String> iterator = bandejaDeEntrada.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		System.out.println("----------------------------------");
	}
}
