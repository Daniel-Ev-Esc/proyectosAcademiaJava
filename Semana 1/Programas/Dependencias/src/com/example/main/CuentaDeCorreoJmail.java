package com.example.main;

import java.util.Date;

public class CuentaDeCorreoJmail extends CuentaDeCorreo{
	
	// Al crear la cuenta se define la dirección según el tipo de cuenta
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
