package com.curso.main;

// Contiene los mensajes específicos del dragon
public class Dragon extends Enemigo{
	
	public Dragon(int hp, int atk, int def) {
		super(hp, atk, def);
	}	
	
	@Override
	int decirProximoMovimiento() {
		siguienteMovimiento = (int)((Math.random() * 3)+1);
		
		switch (siguienteMovimiento) {
		case 1: 
			System.out.println("El dragon te mira fijamente");
			break;
		case 2: 
			System.out.println("El dragon permanece inmovil");
			break;
		case 3: 
			System.out.println("El ambiente se siente mas calido");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + siguienteMovimiento);
		}
		
		return siguienteMovimiento;
	}
	
	@Override
	void presentacion() {
		System.out.println("¡Encuentras al dragon de la mazmorra!");
	}
	
	@Override
	void derrota() {
		System.out.println("El dragon reconoce tu fuerza y se prepara para dormir...");
		
	}

}
