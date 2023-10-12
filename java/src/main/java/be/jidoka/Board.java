package be.jidoka;

import java.util.ArrayList;
import java.util.List;

import static be.jidoka.BoxState.UNOCCUPIED;

public class Board {

	private final List<BoxState> boardState = new ArrayList<>(List.of(
			UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
			UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
			UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
	));

	private Player currentPlayer = Player.ONE;

	public Result applyZet(Zet zet) {
		int index = zet.getIndex();

		if (boardState.get(index) != UNOCCUPIED) {
			throw new RuntimeException("This coordinate is already used");
		}

		boardState.set(index, currentPlayer.getBoxState());
		currentPlayer = currentPlayer == Player.ONE ? Player.TWO : Player.ONE;

		return new Result(currentPlayer, List.copyOf(boardState));
	}

}
