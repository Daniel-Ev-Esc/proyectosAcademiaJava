package com.curso.v0;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


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
		
		// Despliega los numeros de una lista multiplicados por otro
		BiConsumer<Integer, List<Integer>> dobleListaBiConsumer = (x,y) -> {for (Integer integer : y) {
		System.out.println(integer*x);	
		}		};
		
		System.out.println("-----");
		dobleListaBiConsumer.accept(4, intList);
		
		// Despliega un string n veces
		BiConsumer<String, Integer> multipleStringBiConsumer = (s,n) -> { for (int i = 0; i < n; i++) {
			System.out.print(s);
		} 
		System.out.println();};
		
		System.out.println("-----");
		multipleStringBiConsumer.accept("hello",7);
		
		// Predicate 
		System.out.println("--- Predicate ---");
		// Recieves a number and checks if it's bigger than 100
		Predicate<Integer> moreThan100 = x-> x>100;
		
		System.out.println(moreThan100.test(101));
		
		// Checks if a string from a string builder is a palindrome
		Predicate<StringBuilder> checkPalindromePredicate = s-> s == s.reverse();
		
		System.out.println(checkPalindromePredicate.test(new StringBuilder("anna")));
		
		// Checks if a password is safe by checking if it's larger than 5 characters
		Predicate<String> checkPasswordPredicate = x -> x.length()>5;
		
		System.out.println(checkPasswordPredicate.test("secr4"));
		
		// Checks if a number is even
		Predicate<Integer> checkEvenPredicate = x -> x%2 == 0;
		
		System.out.println(checkEvenPredicate.test(3));
		
		// Bipredicate
		System.out.println("--- BiPredicate ---");
		
		// Recieves a string and checks if the length is bigger than the one specified
		BiPredicate<String, Integer> lengthRequirements = (x,y)-> x.length()>y;
		System.out.println(lengthRequirements.test("hello world", 5));
		
		// Returns true if the double of an int is bigger then a double plus 10
		BiPredicate<Integer, Double> doubleOrTen = (i, d) -> i*2 > d+10.0;
		System.out.println(doubleOrTen.test(6, 2.1));
		
		// Checks if an integer in an ordered array
		BiPredicate<List<Integer>, Integer> checksListBiPredicate = (li, x) -> { for (Integer integer : intList) {
			if(integer == x)
				return true;
			if(integer > x)
				return false;
			} 
			return false;
		};
		
		System.out.println(checksListBiPredicate.test(intList, 6));
		
		// Checks if the sum of two numbers is over 10
		BiPredicate<Integer, Double> sumTo10 = (x,y) -> x+y >10;
		
		System.out.println(sumTo10.test(3, 7.1));
		
		// Function
		System.out.println("--- Function ---");
		
		// Returns the combined length of a list of strings
		Function<List<String>, Integer> sumOfLengthFunction = li -> {int i = 0; for (String string: li) {
			i += string.length();
		} 
		return i;};
		
		List<String> listStrings = new ArrayList<String>();
		
		listStrings.add("Hello");
		listStrings.add("World");
		
		System.out.println(sumOfLengthFunction.apply(listStrings));
		
		// Returns the first element of a list
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(5);
		list2.add(8);
		Function<List<Integer>, Integer> getFirstFunction = li -> li.get(0);
		
		System.out.println("-----");
		System.out.println(getFirstFunction.apply(list2));
		
		// Returns a direction based on the number introduced (1 to 4, any other number gives an error)
		Function<Integer, String> getDirectionFunction = i -> {
			switch (i) {
			case 1: 
				return "North";
			case 2: 
				return "East";
			case 3: 
				return "South";
			case 4: 
				return "West";
			default:
				return "Error";
			}
		};
		System.out.println("-----");
		System.out.println(getDirectionFunction.apply(3));
		
		// Generates an object using only one integer and setting it to the height
		Function<Integer, MedicalData> createData =  h -> new MedicalData(h);
		
		System.out.println("-----");
		System.out.println(createData.apply(140));
		
		// Bifunction
		
		System.out.println("--- BiFunction ---");
		
		// Returns the specified element of a list of integers, if the index is not in the list, returns -1;
		BiFunction<List<Integer>, Integer, Integer> returnElementBiFunction = (li, i) -> {if(i < li.size() && i > 0) {return li.get(i);}
			return -1;
		};
		
		System.out.println(returnElementBiFunction.apply(list2, 2));
		// Using an integer and a double in a constructor, This lambda function creates an instance of MedicalData with the specified value
		BiFunction<Double, Integer, MedicalData> createDataBiFunction = (d, i) -> new MedicalData(d,i);
		
		System.out.println("-----");
		System.out.println(createDataBiFunction.apply(80.0, 170));
		
		// Creates an entry for a map from an integer and a String
		Map<Integer, String> newMap = new HashMap<>();
		
		BiFunction<Integer, String, Map.Entry<Integer, String>> createEntryBiFunction = (i, s) -> new AbstractMap.SimpleEntry<>(i, s);
		
		Map.Entry<Integer, String> entry = createEntryBiFunction.apply(26, "Jhon Smith");
        
        newMap.put(entry.getKey(), entry.getValue());
        
        System.out.println("-----");
        System.out.println(newMap);
        
        // Recibe dos strings, si el segundo se puede encontrar en el primero, regresa la longitud del resto del string
        BiFunction<String, String, Integer> remainingString = (s,sub) -> s.contains(sub) ? s.length() - sub.length() : 0;
        
        System.out.println("-----");
        System.out.println(remainingString.apply("aerodinamico", "aero"));
        
        // Unary operations
		System.out.println("--- Unary Operation---");
		
		// Recibe un entero y regresa su cuadrado
		UnaryOperator<Integer> squareOperator = x -> x*x;
		System.out.println(squareOperator.apply(4));
		
		// Regresa la parte decimal de un double
		UnaryOperator<Double> decimalOperator = d -> d - Math.floor(d);
		System.out.println("-----");
		System.out.println(decimalOperator.apply(8.5));
		
		// Regresa el inverso de un double
		UnaryOperator<Double> inverseOperator = d -> 1/d;
		System.out.println("-----");
		System.out.println(inverseOperator.apply(0.75));
		
		// Add a leading and trailing space to a string
		UnaryOperator<String> addSpaceOperator = s -> " " + s + " ";
		System.out.println("-----");
		System.out.println(addSpaceOperator.apply("Hello world"));
		
		// Binary Operators
		System.out.println("--- Binary Operators ---");
		
		// Get the max imun from two numbers
		BinaryOperator<Integer> maxBinaryOperator = (a,b) -> Math.max(a, b);
		System.out.println(maxBinaryOperator.apply(12, 89));
		
		// Add the decimal values of two doubles
		BinaryOperator<Double> sumDecimals = (c,d) -> (c - Math.floor(c)) + (d-Math.floor(d));
		System.out.println("-----");
		System.out.println(sumDecimals.apply(5.8, 9.5));
		
		// Adds a dash between the two strings passed
		BinaryOperator<String> dashBinaryOperator = (str1, str2) -> str1 + " - " + str2;
		System.out.println(dashBinaryOperator.apply("Hello", "World"));
		
		// Suma las propiedades de dos objetos de datos médicos y construye uno nuevo con esos datos
		MedicalData mda = new MedicalData(72.3, 150);
		MedicalData mdb = new MedicalData(66.5, 180);
		BinaryOperator<MedicalData> averageMedicalDataBinaryOperator = (mdone, mdtwo) -> new MedicalData((mdone.getWeight() + mdtwo.getWeight())/2, (int)((mdone.getHeight() + mdtwo.getHeight())/2));
		System.out.println("-----");
		System.out.println(averageMedicalDataBinaryOperator.apply(mda, mdb));
		}

}

class MedicalData{
	
	int id;
	double weight;
	int height;
	
	
	
	public MedicalData() {
		
	}
	
	public MedicalData(int height) {
		this.height = height;
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