package com.curso.main;

public class Fantasma extends Enemigo{
	
	public Fantasma(int hp, int atk, int def) {
		super(hp, atk, def);
	}	
	
	@Override
	void decirProximoMovimiento() {
		siguienteMovimiento = (int)((Math.random() * 3)+1);
		
		switch (siguienteMovimiento) {
		case 1: 
			System.out.println("El fantasma parece enojado");
			break;
		case 2: 
			System.out.println("El fantasma casi no se ve");
			break;
		case 3: 
			System.out.println("El fantasma hace una cara tenebrosa");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + siguienteMovimiento);
		}
		
	}
	
	@Override
	void presentacion() {
		System.out.println("¡El fantasma aparece de la nada!");
	}
	
	@Override
	void derrota() {
		System.out.println("El fantasma desaparece con un grito...");
		
	}
	
	@Override
	int realizarMovimiento(Jugador jugador) {
		switch (siguienteMovimiento) {
		case 1: 
			return calcularAtaque();
		case 2: 
			return calcularDefensa();
		case 3: 
			me.ejecutaMovimientoEspecial(jugador);
			return calcularAtaque();
		default:
			throw new IllegalArgumentException("Unexpected value: " + siguienteMovimiento);
		}
		
	}

}
