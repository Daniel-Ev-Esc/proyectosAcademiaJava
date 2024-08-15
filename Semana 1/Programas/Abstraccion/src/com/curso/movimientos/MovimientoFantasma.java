package com.curso.movimientos;

import com.curso.main.Jugador;

public class MovimientoFantasma implements MovimientoEspecial {
	
	// Movimiento intermedio que reduce ambas estadísticas
	@Override
	public void ejecutaMovimientoEspecial(Jugador jugador) {
		System.out.println("El Fantasma lanza un grito debilitante...");
		jugador.setAtk(jugador.getAtk()-2);
		jugador.setDef(jugador.getDef()-2);
	}

}
