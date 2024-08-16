package com.curso.main;

// Contiene los mensajes específicos del dragon
public class Slime extends Enemigo{
	
	public Slime(int hp, int atk, int def) {
		super(hp, atk, def);
	}	
	
	@Override
	int decirProximoMovimiento() {
		siguienteMovimiento = (int)((Math.random() * 3)+1);
		
		switch (siguienteMovimiento) {
		case 1: 
			System.out.println("El Slime se prepara para saltar");
			break;
		case 2: 
			System.out.println("El Slime parece tenso");
			break;
		case 3: 
			System.out.println("El Slime concentra su acido");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + siguienteMovimiento);
		}
		
		return siguienteMovimiento;
	}
	
	@Override
	void presentacion() {
		System.out.println("¡El Slime sale de los arbustos!");
	}
	
	@Override
	void derrota() {
		System.out.println("El Slime huye hacia una cueva...");
		
	}

}
