package com.curso.main;


import java.util.Scanner;

import com.curso.movimientos.MovimientoDragon;
import com.curso.movimientos.MovimientoFantasma;
import com.curso.movimientos.MovimientoSlime;

public class Principal {

	public static void main(String[] args) {
		
		Jugador jugador = new Jugador(20, 10, 5);
		Enemigo slime = new Slime(20, 5, 5);
		slime.me = new MovimientoSlime();
		Enemigo fantasma = new Fantasma(40, 16, 12);
		fantasma.me = new MovimientoFantasma();
		Enemigo dragon = new Dragon(80, 25, 15);
		dragon.me = new MovimientoDragon();
		
		jugador = combate(jugador, slime);
		
		if(jugador.getHp() > 0)
			jugador = combate(jugador, fantasma);
		
		if(jugador.getHp() > 0)
			jugador = combate(jugador, dragon);
		
		if(jugador.getHp() > 0)
		System.out.println("Felicidades, haz llegado al fondo de la masmorra y encontraste el tesoro");

	}
	
	static Jugador combate(Jugador jugador, Enemigo enemigo) {
		
		enemigo.presentacion();
		jugador.presentacion();
		
		int baseHp = jugador.getHp();
		int baseAtk = jugador.getAtk();
		int baseDef = jugador.getDef();
		
		while (enemigo.getHp() > 0 && jugador.getHp() > 0) {
			System.out.println("Jugador: Hp: " + jugador.getHp() + " atk: " + jugador.getAtk() + " def: " + jugador.getDef());
			System.out.println(enemigo.getClass().getSimpleName()+" Hp: " + enemigo.getHp());
			
			enemigo.decirProximoMovimiento();

			Scanner scanner = new Scanner(System.in);
	        int choice = 0;
	        boolean valid = false;
			int resultado;

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
	                        case 1:
	                        	if(enemigo.siguienteMovimiento == 2)
	                        		resultado = jugador.calcularAtaque() - enemigo.calcularDefensa();
	                        	else {	
	                        	resultado = jugador.calcularAtaque() - enemigo.getDef();
	                        	}
	            				if (resultado < 0)
	            					resultado = 0;
	            				enemigo.setHp(enemigo.getHp() - resultado);
	            				System.out.println("Atacas por " + resultado + " de daño");
	            				System.out.println(enemigo.getClass().getSimpleName()+" Hp: " + enemigo.getHp());
	                            break;
	                        case 2:
	                            System.out.println("Te proteges");
	                            break;
	                        case 3:
	                        	jugador.mejorarAtaque();
	                            break;
	                        case 4:
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
			
	        if(enemigo.getHp() > 0)
			if(enemigo.siguienteMovimiento != 2){
				if (choice == 2) {
					resultado = enemigo.realizarMovimiento(jugador) - jugador.calcularDefensa();
				}else {					
					resultado = enemigo.realizarMovimiento(jugador) - jugador.getDef();
				}
				if (resultado < 0)
					resultado = 0;
				jugador.setHp(jugador.getHp() - resultado);
				System.out.println("El " + enemigo.getClass().getSimpleName() + " ataca por " + resultado + " de daño");
		}
		}
			
		if (jugador.getHp() <= 0) {
			jugador.derrota();
		}
		else {
			enemigo.derrota();
			jugador.setHp(baseHp*2);
			jugador.setAtk(baseAtk+10);
			jugador.setDef(baseDef+10);
		}
		return jugador;
		
	}

}
