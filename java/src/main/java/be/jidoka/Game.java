package be.jidoka;

public class Game {

	private Board board;

	public Result start() {
		board = new Board();

		return new Result(Player.ONE, board.getBoardState(), null);
	}

	public Result play(String coordinate) {
		Zet zet = Zet.parse(coordinate);

		return board.applyZet(zet);
	}
}
