package com.example.main;

public class Empleado {
	
	String nombre;
	CuentaDeCorreo cc;
	
	public Empleado(String nombre, CuentaDeCorreo cc) {
		this.nombre = nombre;
		this.cc = cc;
	}
	
	void enviarCorreo(Empleado e, String s) {
		this.cc.enviar(e.cc, s);
	}
	
	void verCorreo() {
		this.cc.verCorreo();
	}
	
	
}
