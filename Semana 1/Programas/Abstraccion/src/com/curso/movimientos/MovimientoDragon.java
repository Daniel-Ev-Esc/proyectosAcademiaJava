package com.curso.movimientos;

import com.curso.main.Jugador;

public class MovimientoDragon implements MovimientoEspecial {
	
	@Override
	public void ejecutaMovimientoEspecial(Jugador jugador) {
		jugador.setAtk(jugador.getAtk()-3);
		jugador.setDef(jugador.getDef()-3);
	}

}
