package be.jidoka;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	void gameStartTest() {
		PrintAssert printer = new PrintAssert();
		Game game = new Game(printer);
		game.start();
		assertThat(printer.printedContent).isEqualTo(
				"""
					 - - -
					| | | |
					 - - -
					| | | |
					 - - -
					| | | |
					 - - -
					Player X, please enter a coordinate:
					""");
	}

	@Test
	void gameFirstTurn() {
		PrintAssert printer = new PrintAssert();
		Game game = new Game(printer);
		game.start();
		printer.reset();
		game.makeTurn(new Coordinate(1, 1));
		assertThat(printer.printedContent).isEqualTo(
				"""
					 - - -
					| | | |
					 - - -
					| |X| |
					 - - -
					| | | |
					 - - -
					Player O, please enter a coordinate:
					""");
	}
}
