package be.jidoka;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String input = readLine();
		System.out.println("You entered: " + input);
	}

	private static String readLine() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a value..");
		return scanner.nextLine();
	}

	public static String hello() {
		return "world";
	}
}
