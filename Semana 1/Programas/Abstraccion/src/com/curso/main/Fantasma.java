package com.curso.main;

// Contiene los mensajes específicos del fantasma
public class Fantasma extends Enemigo{
	
	public Fantasma(int hp, int atk, int def) {
		super(hp, atk, def);
	}	
	
	@Override
	int decirProximoMovimiento() {
		siguienteMovimiento = (int)((Math.random() * 3)+1);
		
		switch (siguienteMovimiento) {
		case 1: 
			System.out.println("El Fantasma parece enojado");
			break;
		case 2: 
			System.out.println("El Fantasma casi no se ve");
			break;
		case 3: 
			System.out.println("El Fantasma hace una cara tenebrosa");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + siguienteMovimiento);
		}
		
		return siguienteMovimiento;
	}
	
	@Override
	void presentacion() {
		System.out.println("¡El Fantasma aparece de la nada!");
	}
	
	@Override
	void derrota() {
		System.out.println("El Fantasma desaparece con un grito...");
		
	}
	
}
