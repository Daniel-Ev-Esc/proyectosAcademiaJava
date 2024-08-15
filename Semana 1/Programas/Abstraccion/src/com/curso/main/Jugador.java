package com.curso.main;

public class Jugador extends Entidad{
	
	Jugador(int hp, int atk, int def){
		super(hp, atk, def);
	}
	
	// Métodos de mejora de estadísticas, son aleatorios del 0 al 5
	void mejorarAtaque() {
		atk += (int)((Math.random() * 5));
		System.out.println("Ataque aumentado a "+atk);
	}
	
	void mejorarDefensa() {
		def += (int)((Math.random() * 5));
		System.out.println("Defensa aumentada a "+def);
	}
	
	// Mensajes específicos del jugador	
	@Override
	void presentacion() {
		System.out.println("¡Que comience el combate!");
	}
	
	@Override
	void derrota() {
		System.out.println("Game Over...");
	}

}
