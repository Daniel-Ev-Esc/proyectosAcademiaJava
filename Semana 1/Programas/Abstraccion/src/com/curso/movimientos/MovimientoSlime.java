package com.curso.movimientos;

import com.curso.main.Jugador;

public class MovimientoSlime implements MovimientoEspecial {
	
	// Movimiento básico que reduce la defensa del jugador
	@Override
	public void ejecutaMovimientoEspecial(Jugador jugador) {
		System.out.println("El acido del Slime deteriora tu escudo...");
		jugador.setDef(jugador.getDef()-2);
	}

}
