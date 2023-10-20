package be.jidoka;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BoardTest {

	@Nested
	class Print {

		@Test
		void emptyState() {
			PrintAssert printer = new PrintAssert();

			new Board(printer).print();

			assertThat(printer.printedContent).isEqualTo(
					"""
					 - - -
					| | | |
					 - - -
					| | | |
					 - - -
					| | | |
					 - - -
					"""
			);
		}

		@Test
		void afterOneMove() {
			PrintAssert printer = new PrintAssert();
			Board board = new Board(printer);

			board.place(Symbol.X, new Coordinate(1, 1));

			board.print();

			assertThat(printer.printedContent).isEqualTo(
					"""
							 - - -
							| | | |
							 - - -
							| |X| |
							 - - -
							| | | |
							 - - -
							"""
			);
		}
	}
}