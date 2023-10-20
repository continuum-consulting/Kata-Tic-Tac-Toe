package be.jidoka;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(System.out::println);
		game.start();

		while(true) {
			String input = readLine();
			if (input.equals("exit")) {
				break;
			}
			game.makeTurn(Coordinate.parse(input));

		}
	}

	private static String readLine() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public static String hello() {
		return "world";
	}
}
