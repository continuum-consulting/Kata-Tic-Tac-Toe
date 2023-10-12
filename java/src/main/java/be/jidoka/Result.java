package be.jidoka;

import java.util.List;

public class Result {

	private final Player nextPlayer;

	private final List<BoxState> boardState;

	public Result(Player nextPlayer, List<BoxState> boardState) {
		this.nextPlayer = nextPlayer;
		this.boardState = boardState;
	}

	public Player getNextPlayer() {
		return nextPlayer;
	}

	public List<BoxState> getBoardState() {
		return boardState;
	}
}
