package be.jidoka;

import org.junit.jupiter.api.Test;

import static be.jidoka.BoxState.PLAYER_1;
import static be.jidoka.BoxState.PLAYER_2;
import static be.jidoka.BoxState.UNOCCUPIED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ApplicationTest {

	@Test
	void shouldStartTicTacToe() {
		Application application = new Application();

		Result result = application.start();

		assertThat(result.getNextPlayer()).isEqualTo(Player.ONE);
		assertThat(result.getBoardState()).containsExactly(
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
		);
	}

	@Test
	void shouldPlaceXForPlayer1() {
		Application application = new Application();
		application.start();

		Result result = application.play("A0");

		assertThat(result.getNextPlayer()).isEqualTo(Player.TWO);
		assertThat(result.getBoardState()).containsExactly(
				PLAYER_1, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
		);
	}

	@Test
	void shouldPlaceOForPlayer2() {
		Application application = new Application();
		application.start();

		application.play("A0");
		Result result = application.play("A1");

		assertThat(result.getNextPlayer()).isEqualTo(Player.ONE);
		assertThat(result.getBoardState()).containsExactly(
				PLAYER_1, UNOCCUPIED, UNOCCUPIED,
				PLAYER_2, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
		);
	}

	@Test
	void shouldCheckIfCoordinateIsAlreadyOccupied() {
		Application application = new Application();
		application.start();

		application.play("A0");
		assertThrows(RuntimeException.class, () -> application.play("A0"));

	}

	@Test
	void shouldCheckForNonExistingCoordinates() {
		Application application = new Application();
		application.start();

		assertThrows(RuntimeException.class, () -> application.play("NOT_EXISTING"));
	}

//	@Test
//	void shouldWinWhenThreeInARow() { // horizontal
//		Application application = new Application();
//		application.start();
//
//		application.play("A0");
//		application.play("A1");
//		application.play("B0");
//		application.play("B1");
//		Result result = application.play("C0");
//
//		assertThat(result.getMessage()).isEqualTo("Player 1 has won!");
//		assertThat(result.getCoordinates()).containsExactly(
//				"X", "X", "X",
//				"O", "O", " ",
//				" ", " ", " ");
//	}
//
//	@Test
//	void shouldWinWhenThreeInAColumn() { // vertical
//		// when do you win?
//		// 0 0 0, A A A => three times the same
//		// A0 B1 C2, A2 B1 C0 => three times the same
//		// how to do this test driven
//		// the win check also only needs to start when minimum 5th round
//		// list of player actions
//	}
//
//	@Test
//	void shouldWinWhenThreeInDiagonal() { // diagonal
//		// when do you win?
//		// 0 0 0, A A A => three times the same
//		// A0 B1 C2, A2 B1 C0 => three times the same
//		// how to do this test driven
//		// the win check also only needs to start when minimum 5th round
//		// list of player actions
//	}
}
