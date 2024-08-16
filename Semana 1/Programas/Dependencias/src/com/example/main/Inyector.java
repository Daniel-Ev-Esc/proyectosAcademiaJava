package com.example.main;

public class Inyector {

	static Empleado inyectarCuenta(String nombre, TipoCorreo tipo) {
		 
		// Según el tipo de correo se le asigna por constructor al empleado
		switch(tipo) {
		case JMAIL:
			return new Empleado(nombre, new CuentaDeCorreoJmail(nombre));
		case COLDMAIL:
			return new Empleado(nombre, new CuentaDeCorreoColdmail(nombre));
		case INLOOK:
			return new Empleado(nombre,  new CuentaDeCorreoInlook(nombre));
		default:
			throw new UnsupportedOperationException("Tipo de email no existe o no soportado");
		}

		
	}
	
}
