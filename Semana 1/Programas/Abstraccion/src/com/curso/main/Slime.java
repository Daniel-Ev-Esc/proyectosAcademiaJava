package com.curso.main;

public class Slime extends Enemigo{
	
	public Slime(int hp, int atk, int def) {
		super(hp, atk, def);
	}	
	
	@Override
	void decirProximoMovimiento() {
		siguienteMovimiento = (int)((Math.random() * 3)+1);
		
		switch (siguienteMovimiento) {
		case 1: 
			System.out.println("El slime se prepara para saltar");
			break;
		case 2: 
			System.out.println("El slime parece tenso");
			break;
		case 3: 
			System.out.println("El slime concentra su acido");
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + siguienteMovimiento);
		}
		
	}
	
	@Override
	void presentacion() {
		System.out.println("¡El slime sale de los arbustos!");
	}
	
	@Override
	void derrota() {
		System.out.println("El slime huye hacia una cueva...");
		
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
