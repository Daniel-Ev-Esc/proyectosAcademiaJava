package com.example.main;

public class Principal {
	
	public static void main(String[] args) {
		
		// Se crean la cuentas de los empleados	
		Empleado jim = Inyector.inyectarCuenta("jim", TipoCorreo.JMAIL);
		Empleado pam = Inyector.inyectarCuenta("pam", TipoCorreo.COLDMAIL);
		Empleado dwigth = Inyector.inyectarCuenta("dwigth", TipoCorreo.INLOOK);
		
		// Se envía un correo 
		jim.enviarCorreo(pam, "Hola Pam, tu vas a llevar los vasos a la fiesta de la oficina ¿Verdad?");
		
		// Se ve la bandeja de entrada
		pam.verCorreo();
		
		pam.enviarCorreo(jim, "Hola Jim, claro yo los llevaré");
		
		jim.verCorreo();
		
		dwigth.enviarCorreo(jim, "Hola compañeros de trabajo, se me ha reportado que han estado usando el correo para cuestiones no laborales, desistan inmediatamente. \nPD: ¿De que fiesta están hablando?");
		dwigth.enviarCorreo(pam, "Hola compañeros de trabajo, se me ha reportado que han estado usando el correo para cuestiones no laborales, desistan inmediatamente. \nPD: ¿De que fiesta están hablando?");

		pam.verCorreo();
		jim.verCorreo();
	}
	
}
