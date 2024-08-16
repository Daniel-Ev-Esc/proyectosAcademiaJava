package com.example.main;

import java.util.Date;

public class CuentaDeCorreoColdmail extends CuentaDeCorreo{
	
	// Al crear la cuenta se define la dirección según el tipo de cuenta
	public CuentaDeCorreoColdmail(String nombre) {
		super(nombre);
		setDireccion();

	}
	
	@Override
	void setDireccion() {
		this.direccion = direccion + "@Inlook.com";
	}
	
	@Override
	void enviar(CuentaDeCorreo cc, String s) {
		
		String correo = "Mensaje de una cuenta Inlook " + direccion + "\n" + s + "\nRecibido:  " + new Date().toString();
		
		cc.recibir(correo);
	}
	

}
