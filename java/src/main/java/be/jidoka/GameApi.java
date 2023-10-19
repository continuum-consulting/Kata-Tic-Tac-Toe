package be.jidoka;

public class GameApi {

	private Game game;

	public Result start() {
		game = new Game();

		return new Result(Player.ONE, Board.EMPTY_BOARD, null);
	}

	public Result play(String coordinate) {
		Zet zet = Zet.parse(coordinate);

		return game.applyZet(zet);
	}
}
