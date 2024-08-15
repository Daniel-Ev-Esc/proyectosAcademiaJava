package com.curso.movimientos;

import com.curso.main.Jugador;

public class MovimientoSlime implements MovimientoEspecial {
	
	@Override
	public void ejecutaMovimientoEspecial(Jugador jugador) {
		jugador.setDef(jugador.getDef()-2);
	}

}
