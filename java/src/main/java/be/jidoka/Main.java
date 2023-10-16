package be.jidoka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		Result start = game.start();

		playGame(game, start);
	}

	private static void playGame(Game game, Result result) {
		if (result.getWinner() != null) {
			System.out.printf("Player %s has won", result.getWinner());
			return;
		}

		printBoard(result.getBoardState());

		String input = readLine();
		try {
			Result nextResult = game.play(input);
			playGame(game, nextResult);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			playGame(game, result);
		}
	}

	private static String readLine() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a value: ");
		return scanner.nextLine();
	}

	private static void printBoard(List<BoxState> boardState) {
		List<String> board = formatBoardState(boardState);

		System.out.println("   /-A-|-B-|-C-\\");
		System.out.println("   /---|---|---\\");
		System.out.println(" 0 | " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) + " |");
		System.out.println("   |-----------|");
		System.out.println(" 1 | " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " |");
		System.out.println("   |-----------|");
		System.out.println(" 2 | " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " |");
		System.out.println("   /---|---|---\\");
	}

	private static List<String> formatBoardState(List<BoxState> boardState) {
		final ArrayList<String> board = new ArrayList<>();

		boardState.forEach(state -> {
			if (state == BoxState.PLAYER_1) {
				board.add("X");
			} else if (state == BoxState.PLAYER_2) {
				board.add("O");
			} else {
				board.add(" ");
			}
		});

		return board;
	}
}
