package com.example.main;

import java.util.Date;

public class CuentaDeCorreoJmail extends CuentaDeCorreo{
	
	public CuentaDeCorreoJmail(String nombre) {
		super(nombre);
		setDireccion();

	}
	
	@Override
	void setDireccion() {
		this.direccion = direccion + "@Jmail.com";
	}
	
	@Override
	void enviar(CuentaDeCorreo cc, String s) {
		
		String correo = "Mensaje de una cuenta Jmail " + direccion + "\n" + s + "\nRecibido:  " + new Date().toString();
		
		cc.recibir(correo);
	}

}
