package com.curso.movimientos;

import com.curso.main.Jugador;

public class MovimientoDragon implements MovimientoEspecial {
	
	// Movimiento más poderoso que reduce mucho las estadísticas del jugador 
	@Override
	public void ejecutaMovimientoEspecial(Jugador jugador) {
		System.out.println("El Dragon lanza llamas con furia...");
		jugador.setAtk(jugador.getAtk()-3);
		jugador.setDef(jugador.getDef()-3);
	}

}
