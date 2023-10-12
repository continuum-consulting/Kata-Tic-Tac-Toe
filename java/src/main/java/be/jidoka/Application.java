package be.jidoka;

import java.util.List;

import static be.jidoka.BoxState.UNOCCUPIED;

public class Application {

	Board board;

	public Result start() {
		board = new Board();

		return new Result(Player.ONE, List.of(
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
		));
	}

	public Result play(String coordinate) {
		Zet zet = Zet.parse(coordinate);

		return board.applyZet(zet);
	}
}
