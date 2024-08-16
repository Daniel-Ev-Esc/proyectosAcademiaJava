package com.example.main;

import java.util.Date;

public class CuentaDeCorreoInlook extends CuentaDeCorreo{
	
	public CuentaDeCorreoInlook(String nombre) {
		super(nombre);
		setDireccion();

	}
	
	@Override
	void setDireccion() {
		this.direccion = direccion + "@Coldmail.com";
	}
	
	@Override
	void enviar(CuentaDeCorreo cc, String s) {
		
		String correo = "Mensaje de una cuenta Coldmail " + direccion + "\n" + s + "\nRecibido:  " + new Date().toString();
		
		cc.recibir(correo);
	}
	

}
