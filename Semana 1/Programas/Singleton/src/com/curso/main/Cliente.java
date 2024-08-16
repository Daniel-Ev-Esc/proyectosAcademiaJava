package com.curso.main;

public class Cliente {
	
	// Cada cliente tiene un nombre, un registro y una variable que simula un archivo
	protected String nombre;
	protected AlmacenDeRegistros reg;
	private Boolean archivo = false;
	
	public String getNombre() {
		return nombre;
	}
	
	public Cliente(String nombre, AlmacenDeRegistros reg) {
		this.nombre = nombre;
		this.reg = reg;
	}

	// En cada función registramos la acción en el Almacen
	public void iniciarSesión() {
		reg.addRegistro(nombre + " Accedió a la terminal");
	}
	
	public void añadirArchivo() {
		if(!archivo) {
			reg.addRegistro(nombre + " Creó su archivo: " + nombre + ".txt");
			archivo = true;
			}
		else
			System.out.println("Archivo ya en memoria");
	}
	
	public void borrarArchivo() {
		if(archivo) {
			reg.addRegistro(nombre + " Borró su archivo: " + nombre + ".txt");
			archivo = false;
			}
		else
			System.out.println("Archivo no existente");
	}
	
	public void cerrarSesion() {
		reg.addRegistro(nombre + " cerró sesión en la terminal");
	}
	
	// Si esta función no la llama un administrador solo envía un mensaje de permisos
	public void verRegistro() {
		System.out.println("No tiene los permisos para ver el registro");
	}
}
