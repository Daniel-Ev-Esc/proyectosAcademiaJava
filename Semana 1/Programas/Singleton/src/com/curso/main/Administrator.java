package com.curso.main;

public class Administrator extends Cliente{
	
	public Administrator(String nombre, AlmacenDeRegistros reg) {
		super(nombre, reg);
	}
	
	// Si el usuario es administrador llama a la muestra de registros del Almacen
	@Override
	public void verRegistro() {
		System.out.println("---------------------------------------------------------");
		reg.addRegistro(nombre + " Consultó los registros");
		reg.verRegistros();
	}
}
