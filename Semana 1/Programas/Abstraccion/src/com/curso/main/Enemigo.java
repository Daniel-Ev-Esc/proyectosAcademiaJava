package com.curso.main;

import com.curso.movimientos.MovimientoEspecial;

public abstract class Enemigo extends Entidad{
	
	MovimientoEspecial me;
	int siguienteMovimiento;
	
	Enemigo(int hp, int atk, int def) {
		super(hp, atk, def);
	}
	
	// Métodos usados para manejar la lógica de los ataques del enemigo
	
	// Genera el proximo movimiento, lo anuncia con un mensaje y regresa la elección
	abstract int decirProximoMovimiento();
	
	// Ejecuta el movimiento generado, el movimiento especial tiene efecto en el jugador, por lo que se necesita enviar como parámetro
	int realizarMovimiento(Jugador jugador) {
		switch (siguienteMovimiento) {
		case 1: 
			return calcularAtaque();
		case 2: 
			return defender();
		case 3: 
			me.ejecutaMovimientoEspecial(jugador);
			return calcularAtaque();
		default:
			throw new IllegalArgumentException("Unexpected value: " + siguienteMovimiento);
		}
		
	}

}
