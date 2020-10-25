package com.learn.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {
		/**
		 * Challenge 3:
		 * Right now the function in challenge 2 doesn't do anything.
		 * Write the code that will execute the function with an argument of "1234567890"
		 */
		
		// Challenge 3 solution:
		System.out.println("Result = " + everySecondCharSolution.apply("1234567890"));
		
		/**
		 * Challenge 5:
		 * Using the bonus version on challenge 4, call the method and print the result returned from the method
		 */
		
		// Challenge 5 solution:
		String result = everySecondCharacter(everySecondCharSolution, "1234567890");
		System.out.println("\nResult = " + result);
		
		/**
		 * Challenge 7:
		 * The supplier won't do anything until we use it,
		 * Use the Supplier(Challenge 6) to assign the string "I love Java!" to a variable called supplierResult,
		 * Then print the variable to the console
		 */
		
		// Challenge 7 solution:
		String supplierResult = iLoveJava.get();
		System.out.println("\nSupplier result = " + supplierResult);
		
		/**
		 * Challenge 9:
		 * Suppose we have the following list of the top 5 male and female names for 2015,
		 * Write code to print the items in the list in sorted order, and with the first letter in each name upper-cased
		 * Use Lambda expressions and Stream operations wherever possible
		 */
		List<String> topNames2015 = Arrays.asList(
				"Amelia", "Olivia", "emily", "Isla", "Ava",
				"oliver", "Jack", "Charlie", "harry", "Jacob"
		);
		
		// Challenge 9 solution:
		System.out.println("\nList of the top 5 male and female names for 2015");
		System.out.println("================================================");
		topNames2015
			.stream()
			.map(name -> name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase())
			.sorted()
			.forEach(System.out::println);
		
		/**
		 * Challenge 10:
		 * Instead of printing out the sorted names(challenge 9),
		 * Print out how many names start with the letter 'A'
		 */
		
		// Challenge 10 solution:
		System.out.println("\nList of the top male and female names start with the letter 'A' for 2015");
		System.out.println("========================================================================");
		topNames2015
			.stream()
			.map(name -> name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase())
			.filter(name -> name.startsWith("A"))
			.forEach(System.out::println);

	}
	
	/**
	 * Challenge 1:
	 * Write the following anonymous class as a lambda expression
	 */
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			String myString = "Let's split this up into an array";
			String[] parts = myString.split(" ");
			for (String part : parts) {
				System.out.println(part);
			}
		}
	};
	
	// Challenge 1 Solution:
	Runnable solutionRunnable = () -> {
		String myString = "Let's split this up into an array";
		String[] parts = myString.split(" ");
		
		for (String part : parts) {
			System.out.println(part);
		}
	};
	
	/**
	 * Challenge 2:
	 * Write the following method as a lambda expression, Don't worry about assigning it to anything
	 */
	public static String everySecondChar(String source) {
		StringBuilder returnVal = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			if (i % 2 == 1) {
				returnVal.append(source.charAt(i));
			}
		}
		
		return returnVal.toString();
	}
	
	// Challenge 2 solution:
	static Function<String, String> everySecondCharSolution = (source) -> {
		StringBuilder returnVal = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			if (i % 2 == 1) {
				returnVal.append(source.charAt(i));
			}
		}
		
		return returnVal.toString();
	};
	
	/**
	 * Challenge 4:
	 * Instead of executing this function(challenge 2) directly,
	 * Suppose we want to pass it to a method called everySecondCharacter that accept the function as a parameter
	 * and executes it with the argument "1234567890"
	 * 
	 * It should return the result of the function.
	 * For bonus points, don't hard code the argument string within the method
	 */
	
	// Challenge 4 solution:
	public static String everySecondCharacter(Function<String, String> everySecondCharSolution, String source) {
		return everySecondCharSolution.apply(source);
	}
	
	/**
	 * Challenge 6:
	 * Write a lambda expression that maps to the java.util.Supplier interface
	 * This lambda sould return the string "I love Java!", assign it to a variable called iLoveJava
	 */
	
	// Challenge 6 solution:
	static Supplier<String> iLoveJava = () -> "I love Java!";
	
	/**
	 * Challenge 8:
	 * There are many interfaces in the Java SDK, and sometimes we can use a lambda expression instead of creating
	 * an instance that implements the interface we want to use
	 * 
	 * Given a specific interface, how wan we tell whether we can map a lambda expression to it ?
	 * What's the criteria that has to be met ?
	 */

	/**
	 * Challenge 8 solution:
	 * The interface has to be a functional interface.
	 * It can have only a single method tha must be implemented
	 * 
	 * A functional interface can contain more than one method, but one must have default implementations
	 * Most of the time, the documentaion for the interface will state whether it's a functional interface
	 * A functional interface is annotaed with @FunctionalInterface
	 * 
	 * Example: 
	 * @FunctionalInterface
	 * public interface Supplier<T> {
     * 		T get();
     * }
	 */
}
