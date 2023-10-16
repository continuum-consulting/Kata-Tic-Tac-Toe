package be.jidoka;

import java.util.List;

public class Result {

	private final Player nextPlayer;
	private final Player winner;

	private final List<BoxState> boardState;

	public Result(Player nextPlayer, List<BoxState> boardState, Player winner) {
		this.nextPlayer = nextPlayer;
		this.boardState = boardState;
		this.winner = winner;
	}

	public Player getNextPlayer() {
		return nextPlayer;
	}

	public List<BoxState> getBoardState() {
		return boardState;
	}

	public Player getWinner() {
		return winner;
	}
}
