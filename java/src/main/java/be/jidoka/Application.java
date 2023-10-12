package be.jidoka;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

	private String currentPlayer = "Player 1";

	private final List<String> currentBoard = new ArrayList<>(List.of(
			" ", " ", " ",
			" ", " ", " ",
			" ", " ", " "
	));

	private final List<String> boardCoordinates = List.of(
			"A0", "B0", "C0",
			"A1", "B1", "C1",
			"A2", "B2", "C2"
	);

	public Result start() {
		return new Result(String.format("%s:", currentPlayer), currentBoard);
	}

	public Result play(String coordinate) {
		final int index = boardCoordinates.indexOf(coordinate);
		String message;

		if (index == -1) {
			message = String.format("This coordinate doesn't exist, %s:", currentPlayer);
		} else if (Objects.equals(currentBoard.get(index), " ")) {
			if (Objects.equals(currentPlayer, "Player 1")) {
				currentBoard.set(index, "X");
				currentPlayer = "Player 2";
			} else {
				currentBoard.set(index, "O");
				currentPlayer = "Player 1";
			}
			message = String.format("%s:", currentPlayer);
		} else {
			message = String.format("This coordinate is already used, %s:", currentPlayer);
		}

		return new Result(message, currentBoard);
	}
}
