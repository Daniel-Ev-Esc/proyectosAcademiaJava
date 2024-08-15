package com.curso.main;

import com.curso.movimientos.MovimientoEspecial;

public abstract class Enemigo extends Entidad{
	
	MovimientoEspecial me;
	int siguienteMovimiento;
	
	Enemigo(int hp, int atk, int def) {
		super(hp, atk, def);
	}
	
	abstract void decirProximoMovimiento();
	abstract int realizarMovimiento(Jugador jugador);

}
