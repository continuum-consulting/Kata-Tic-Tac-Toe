package be.jidoka;

public class Game {

	private final Board board = new Board();

	private Player currentPlayer = Player.ONE;

	public Result applyZet(Zet zet) {
		board.applyZet(zet, currentPlayer);

		if (board.checkWin(currentPlayer)) {
			return new Result(null, board.getCurrentState(), currentPlayer);
		}

		if (board.checkBoardFull()) {
			return new Result(null, board.getCurrentState(), null);
		}

		currentPlayer = currentPlayer == Player.ONE ? Player.TWO : Player.ONE;

		return new Result(currentPlayer, board.getCurrentState(), null);
	}
}
