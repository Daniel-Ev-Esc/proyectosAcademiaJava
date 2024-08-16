package com.curso.main;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		// Simulación de 3 sesiones de clientes, 2 clientes normales y un administrador
		
		Scanner scanner = new Scanner(System.in);
		
		Cliente cli1 = new Cliente("Carlos", AlmacenDeRegistros.getRegistro());
		
		sesionDeCliente(cli1, scanner);
		
		Cliente cli2 = new Cliente("Clara", AlmacenDeRegistros.getRegistro());
		
		sesionDeCliente(cli2, scanner);
		
		Cliente admin = new Administrator("Jose", AlmacenDeRegistros.getRegistro());
				
		sesionDeCliente(admin, scanner);
		
		scanner.close();

	}
	
	static void sesionDeCliente(Cliente cl, Scanner scanner) {
		
		// El cliente inicia sesión
		cl.iniciarSesión();
		
		
        int choice = 0;
        
        // Ciclo del menú hasta que el cliente cierre sesión
        while (choice != 4) {
        	
        	System.out.println("Hola " + cl.getNombre() + " ¿Qué vas a hacer?");
            System.out.println("1. Crear mi archivo");
            System.out.println("2. Borrar mi archivo");
            System.out.println("3. Consultar registros (Admin)");
            System.out.println("4. Cerrar sesión");
			
        	if (scanner.hasNextInt()) {
		        choice = scanner.nextInt();
		        
		        switch (choice) {
				case 1: 
					System.out.println("Generando archivo personal...");
					cl.añadirArchivo();
					break;
				case 2: 
					System.out.println("Borrando archivo personal...");
					cl.borrarArchivo();
					break;
				case 3: // Aquí se ve el registro singleton si el usuario es administrador
					System.out.println("Accediendo a registro del sistema...");
					cl.verRegistro();
					break;
				case 4:
					System.out.println("Cerrando sesión...");
					cl.cerrarSesion();
					break;
				default:
					System.out.println("Entrada no válida");
		        }
        	}
        	else {
        		System.out.println("Entrada no válida");
        		scanner.next();
        	}
        }
        
        
    }
}
