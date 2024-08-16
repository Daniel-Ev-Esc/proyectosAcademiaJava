package com.curso.main;

public abstract class Entidad {
	
	// Estadísticas necesarias para el combate 
	protected int hp;
	protected int atk;
	protected int def;

	public Entidad(int hp, int atk, int def){
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	// Métodos abstractos con los mensajes inicials y finales de la entidad
	abstract void presentacion();	
	abstract void derrota();
	
	// Cada ataque tiene un elemento aleatorio que usa un porcentaje del ataque
	int calcularAtaque() {
		return (int)  (atk * (Math.random() * (1 - 0.85)) + atk*0.85);
	}
	
	int defender() {
		return def * 2;
	}
	
	// Setters y getters	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

}
