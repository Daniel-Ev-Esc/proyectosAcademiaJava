package com.curso.v0;

import java.util.function.BiFunction;

public class Principal {

	public static void main(String[] args) {

		//Provider

		//


		// Bifunction

		// Usando un entero y un double en un constructor, esta lambda crea una instancia de DatosMédicos con los valores especificados
		BiFunction<Double, Integer, DatosMedicos> createDatos = (d, i) -> new DatosMedicos(s,i);
	}

}

class DatosMedicos{
	
	double d;
	
}