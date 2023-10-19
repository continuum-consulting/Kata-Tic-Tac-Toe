package be.jidoka;

import java.util.ArrayList;
import java.util.List;

import static be.jidoka.BoxState.UNOCCUPIED;

public class Board {
	public static final List<BoxState> EMPTY_BOARD = List.of(
			UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
			UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
			UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
	);

	private final List<BoxState> boardState = new ArrayList<>(EMPTY_BOARD);

	public void applyZet(Zet zet, Player current) {
		int index = zet.getIndex();

		if (boardState.get(index) != UNOCCUPIED) {
			throw new RuntimeException("This coordinate is already used");
		}

		boardState.set(index, current.getBoxState());
	}

	public List<BoxState> getCurrentState() {
		return List.copyOf(boardState);
	}

	public boolean checkBoardFull() {
		return boardState.stream().filter(boxState -> boxState != UNOCCUPIED).toList().size() == 9;
	}

	public boolean checkWin(Player current) {
		return WinCondition.WIN_CONDITIONS.stream()
				.anyMatch(winCondition -> checkCondition(winCondition, current));
	}

	private boolean checkCondition(WinCondition condition, Player current) {
		return boardState.get(condition.getX()) == current.getBoxState()
				&& boardState.get(condition.getY()) == current.getBoxState()
				&& boardState.get(condition.getZ()) == current.getBoxState();
	}
}
