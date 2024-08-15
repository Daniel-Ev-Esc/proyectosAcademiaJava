package com.curso.main;

public abstract class Entidad {
	
	int hp;
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

	int atk;
	int def;

	public Entidad(int hp, int atk, int def){
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}
	
	abstract void presentacion();	
	abstract void derrota();
	
	int calcularAtaque() {
		return (int)  (atk * (Math.random() * (1 - 0.85)) + atk*0.85);
	}
	
	int calcularDefensa() {
		return def * 2;
	}

}
