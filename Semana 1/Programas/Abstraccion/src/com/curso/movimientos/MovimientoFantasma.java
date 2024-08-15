package com.curso.movimientos;

import com.curso.main.Jugador;

public class MovimientoFantasma implements MovimientoEspecial {
	
	@Override
	public void ejecutaMovimientoEspecial(Jugador jugador) {
		jugador.setAtk(jugador.getAtk()-2);
		jugador.setDef(jugador.getDef()-2);
	}

}
