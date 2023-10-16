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

		if (checkWin(boardState, currentPlayer)) {
			return new Result(null, List.copyOf(boardState), currentPlayer);
		}

		currentPlayer = currentPlayer == Player.ONE ? Player.TWO : Player.ONE;

		return new Result(currentPlayer, List.copyOf(boardState), null);
	}

	public List<BoxState> getBoardState() {
		return boardState;
	}

	private boolean checkWin(List<BoxState> boardState, Player player) {
		return checkHorizontalWin(boardState, player)
				|| checkVerticalWin(boardState, player)
				|| checkDiagonalWin(boardState, player);
	}

	private boolean checkHorizontalWin(List<BoxState> boardState, Player player) {
		for (int i = 0; i < 3; i++) {
			if (boardState.get(i * 3) == player.getBoxState() &&
					boardState.get(i * 3 + 1) == player.getBoxState() &&
					boardState.get(i * 3 + 2) == player.getBoxState()) {
				return true;
			}
		}
		return false;
	}

	private boolean checkVerticalWin(List<BoxState> boardState, Player player) {
		for (int i = 0; i < 3; i++) {
			if (boardState.get(i) == player.getBoxState() &&
					boardState.get(i + 3) == player.getBoxState() &&
					boardState.get(i + 6) == player.getBoxState()) {
				return true;
			}
		}
		return false;
	}

	private boolean checkDiagonalWin(List<BoxState> boardState, Player player) {
		if (boardState.get(0) == player.getBoxState() &&
				boardState.get(4) == player.getBoxState() &&
				boardState.get(8) == player.getBoxState()) {
			return true;
		}

		if (boardState.get(2) == player.getBoxState() &&
				boardState.get(4) == player.getBoxState() &&
				boardState.get(6) == player.getBoxState()) {
			return true;
		}

		return false;
	}
}
