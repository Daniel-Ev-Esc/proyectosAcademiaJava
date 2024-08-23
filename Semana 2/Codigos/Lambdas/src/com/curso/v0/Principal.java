package com.curso.v0;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class Principal {

	public static void main(String[] args) {

		//Supplier
		
		System.out.println("--- Suppliers ---");
		// Create an empty instance of Medical data using the default constructor
		Supplier<MedicalData> createDataProvider = () -> new MedicalData();
		
		System.out.println(createDataProvider.get());

		// Generates an id by creating a random number
		Supplier<Integer> generateIdSupplier = () -> (int)(Math.random()*100000000);
		System.out.println("-----");
		System.out.println(generateIdSupplier.get());
		
		// Gives a date object 14 days in advance
		Supplier<Date> twoWeekSupplier = () -> new Date(System.currentTimeMillis() + 14L * 24 * 60 * 60 * 1000);
		
		System.out.println("-----");
		System.out.println(twoWeekSupplier.get());
		
		// Returns the default settings of an application
		Supplier<String> defaultSettingSupplier = () -> "{applicationName = 'Default', applicationVersion = '0.0.1'}";
		
		System.out.println("-----");
		System.out.println(defaultSettingSupplier.get());
		
		// Consumer
		System.out.println("--- Consumers ---");
		
		// Takes a message and displays it whit its length on console
		Consumer<String> messageConsumer = x -> System.out.println(x + " " + x.length());
		messageConsumer.accept("Hello world");
		
		// Sets a MedicalData object to it's default state
		
		MedicalData md1 = new MedicalData(80.2,158);
		
		Consumer<MedicalData> setToDefaultConsumer = x -> {x.setHeight(0); x.setWeight(0);};
		
		System.out.println("-----");
		System.out.println("Before: " + md1);
		setToDefaultConsumer.accept(md1);
		System.out.println("After: " + md1);
		
		// Adds 10 random numbers from 0 to 9 to a list if integers
		
		List<Integer> listaIntegers = new ArrayList<Integer>();
		
		Consumer<List<Integer>> add10RandomConsumer = x -> {for(int i=0; i < 10; i++) 
			x.add((int) (Math.random() * 10) );
		};
		
		add10RandomConsumer.accept(listaIntegers);
		System.out.println("-----");
		System.out.println(listaIntegers);
		
		// Simulates the storage of an object and displays its atributes and time of storage
		
		Consumer<MedicalData> storeDataConsumer = x -> System.out.println(x + " " + new Date().toString());
		
		System.out.println("-----");
		storeDataConsumer.accept(new MedicalData(44.5, 140));
		
		// BiConsumer
		System.out.println("--- Biconsumer ---");

		// Insert a number to an ordered array
		List<Integer> intList = new ArrayList<Integer>();
		
		intList.add(1);
        intList.add(3);
        intList.add(5);
        intList.add(7);
		
		BiConsumer<List<Integer>, Integer> insertInorderBiConsumer = (x,y) -> {
			int i = 0;
			
			while (i < x.size() && x.get(i) < y){
				i++;
			}
			x.add(i, y);
		};
		
		System.out.println("-----");
		
		System.out.println("Before " + intList);
		
		insertInorderBiConsumer.accept(intList, 6);
		insertInorderBiConsumer.accept(intList, 8);
		
		System.out.println("After " + intList);
		
		// Alters the value of the weight to y in the MedicalData if its higher than the one in the object x
		BiConsumer<MedicalData, Double> setWeigthBiConsumer = (x,y) -> {if(x.getWeight() < y) x.setWeight(y);};
		
		MedicalData md2 = new MedicalData();
		System.out.println("-----");
		System.out.println("Before: " + md2);
		setWeigthBiConsumer.accept(md2, 60.0);
		System.out.println("After: " + md2);
		
		
		// Bifunction

		// Using an integer and a double in a constructor, This lambda function creates an instance of MedicalData with the specified value
		BiFunction<Double, Integer, MedicalData> createDataBiFunction = (d, i) -> new MedicalData(d,i);
	}

}

class MedicalData{
	
	int id;
	double weight;
	int height;
	
	
	
	public MedicalData() {
		
	}


	public MedicalData(double weight, int height) {
		this.weight = weight;
		this.height = height;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	@Override
	public String toString() {
		return "MedicalData [weight=" + weight + ", height=" + height + "]";
	}
	
}