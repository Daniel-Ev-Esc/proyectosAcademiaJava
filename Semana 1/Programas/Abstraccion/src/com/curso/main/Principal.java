package com.curso.main;


import java.util.Scanner;

import com.curso.movimientos.MovimientoDragon;
import com.curso.movimientos.MovimientoFantasma;
import com.curso.movimientos.MovimientoSlime;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// Se genera el personaje del jugador
		Jugador jugador = new Jugador(20, 10, 5);
		
		// Se crea el enemigo Slime y se inicia el primer combate
		Enemigo slime = new Slime(20, 5, 5);
		slime.me = new MovimientoSlime();
		jugador = combate(jugador, slime, scanner);
		
		// Si el jugador ganó el combate anterior se prepara el enemigo Fantasma y se inicia el segundo combate
		if(jugador.getHp() > 0) {
			Enemigo fantasma = new Fantasma(40, 16, 12);
			fantasma.me = new MovimientoFantasma();
			jugador = combate(jugador, fantasma, scanner);
		}
		
		// Si el jugador ganó el combate anterior se prepara el enemigo Fantasma y se inicia el tercer combate
		if(jugador.getHp() > 0) {
			Enemigo dragon = new Dragon(80, 25, 15);
			dragon.me = new MovimientoDragon();
			jugador = combate(jugador, dragon, scanner);
		}
		
		// Si el jugador ganó el combate se le dá un mensaje de felicitaciones
		if(jugador.getHp() > 0)
			System.out.println("¡Felicidades!, haz llegado al fondo de la mazmorra y encontraste el tesoro");
		
		scanner.close();

	}
	
	
	// Método que maneja toda la lógica de combate, toma cualquier clase de enemigo	
	static Jugador combate(Jugador jugador, Enemigo enemigo, Scanner scanner) {
		
		// Mensaje inicial de ambas entidades
		enemigo.presentacion();
		jugador.presentacion();
		
		// Almacenamos las estadísticas base del jugador para restaurarlas si gana
		int baseHp = jugador.getHp();
		int baseAtk = jugador.getAtk();
		int baseDef = jugador.getDef();
		
		// Variables auxiliares
        int choice = 0; // Elección del movimiento del jugador
        boolean valid = false; // Flag que indica si la opción ingresada es válida
		int resultado; // Cantidad de daño inflijido por ataque
		int siguienteMovimiento; // Elección del movimientos generado por el enemigo
		String enemyName = enemigo.getClass().getSimpleName(); // Nombre del enemigo
		
		// El ciclo del combate se repite hasta que una de las entidades es derrotada
		while (enemigo.getHp() > 0 && jugador.getHp() > 0) {
			
			// Mostrar datos de las entidades
			System.out.println("Jugador: Hp: " + jugador.getHp() + " atk: " + jugador.getAtk() + " def: " + jugador.getDef());
			System.out.println(enemyName +" Hp: " + enemigo.getHp()); // Las estadísticas del enemigo están ocultas
			
			// Genera el movimiento del enemigo
			siguienteMovimiento = enemigo.decirProximoMovimiento();
			
			// Reinicia la elección del menú
			choice = 0;	
			valid = false;

			// Ciclo del menú del jugador
	        while (!valid) {
	            System.out.println("¿Qué vas a hacer?");
	            System.out.println("1. Ataque");
	            System.out.println("2. Defensa");
	            System.out.println("3. Mejorar ataque");
	            System.out.println("4. Mejorar defensa");

	            // Verificar si la entrada es un entero
	            if (scanner.hasNextInt()) {
	                choice = scanner.nextInt();

	                // Verificar si la opción está dentro del rango
	                if (choice >= 1 && choice <= 4) {
	                    valid = true;
	                    switch (choice) {
	                        case 1: // El jugador ataca
	                        	
	                        	// Si el enemigo se está defendiendo se toma el doble de la defensa usando el método calcular defensa
	                        	if(siguienteMovimiento == 2) 
	                        		resultado = jugador.calcularAtaque() - enemigo.defender();
	                        	else {	
	                        		resultado = jugador.calcularAtaque() - enemigo.getDef();
	                        	}
	                        	
	                        	// Si el daño es negativo se convierte a 0
	            				if (resultado < 0)
	            					resultado = 0;
	            				
	            				// Reduce el daño al hp del enemigo
	            				enemigo.setHp(enemigo.getHp() - resultado);
	            				
	            				// Mostrar el resultado del movimiento
	            				System.out.println("Atacas por " + resultado + " de daño");
	            				System.out.println(enemyName+" Hp: " + enemigo.getHp());
	                            break;
	                        case 2: // El jugador se defiende
	                        	
	                        	// Esta elección afecta al ataque del enemigo, no se necesita acción inmediata
	                            System.out.println("Te proteges");
	                            break;
	                        case 3:// El jugador aumenta su ataque según su método
	                        	jugador.mejorarAtaque();
	                            break;
	                        case 4:// El jugador aumenta su ataque según su método
	                        	jugador.mejorarDefensa();
	                            break;
	                    }
	                } else {
	                    System.out.println("Opción inválida. Por favor, elija un número del 1 al 4.");
	                }
	            } else {
	                System.out.println("Entrada inválida. Por favor, ingrese un número.");
	                scanner.nextLine();// Limpiar el buffer del scanner
	            }
	        }
			
	        // Movimiento del enemigo
	        // Si el enemigo no ha sido derrotado por el movimiento del jugador
	        if(enemigo.getHp() > 0)
	        	
	        	// Si el enemigo se defiende, no se realiza acción, ya que ya se tomó en cuenta en el ataque del jugador
				if(siguienteMovimiento != 2){
					
					// Si el jugador se defiende se toma el doble de su defensa como dice el método
					if (choice == 2) {
						resultado = enemigo.realizarMovimiento(jugador) - jugador.defender();
					}else {					
						resultado = enemigo.realizarMovimiento(jugador) - jugador.getDef();
					}
					
					// Si el daño es menor a 0 se vuelve 0
					if (resultado < 0)
						resultado = 0;
					
					// Se cambia el hp del jugador según el daño
					jugador.setHp(jugador.getHp() - resultado);
					System.out.println("El " + enemigo.getClass().getSimpleName() + " ataca por " + resultado + " de daño");
				}
		}
		
		// Si el jugador es derrotado se activa su mensaje de derrota y se regresa su instancia con hp 0 para anular los siguientes combates 
		if (jugador.getHp() <= 0) {
			jugador.derrota();
		}
		
		// Si el enemigo es derrotado se activa su mensaje de derrota y se mejoran las estadísticas del jugador antes de regresar la instancia
		else {
			enemigo.derrota();
			jugador.setHp(baseHp*2);
			jugador.setAtk(baseAtk+10);
			jugador.setDef(baseDef+10);
		}
		
		return jugador;
	}

}
