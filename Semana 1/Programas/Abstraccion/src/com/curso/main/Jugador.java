package com.curso.main;

public class Jugador extends Entidad{
	
	Jugador(int hp, int atk, int def){
		super(hp, atk, def);
	}
	
	void mejorarAtaque() {
		atk += (int)((Math.random() * 5));
		System.out.println("Ataque aumentado a "+atk);
	}
	
	void mejorarDefensa() {
		def += (int)((Math.random() * 5));
		System.out.println("Defensa aumentada a "+def);
	}
	
	@Override
	void presentacion() {
		System.out.println("¡Que comience el combate!");
	}
	
	@Override
	void derrota() {
		System.out.println("Game Over...");
	}

}
