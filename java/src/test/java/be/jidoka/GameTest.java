package be.jidoka;

import org.junit.jupiter.api.Test;

import static be.jidoka.BoxState.PLAYER_1;
import static be.jidoka.BoxState.PLAYER_2;
import static be.jidoka.BoxState.UNOCCUPIED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class GameTest {

	@Test
	void shouldStartTicTacToe() {
		Game application = new Game();

		Result result = application.start();

		assertThat(result.getNextPlayer()).isEqualTo(Player.ONE);
		assertThat(result.getBoardState()).containsExactly(
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
		);
		assertThat(result.getWinner()).isNull();
	}

	@Test
	void shouldPlaceXForPlayer1() {
		Game application = new Game();
		application.start();

		Result result = application.play("A0");

		assertThat(result.getNextPlayer()).isEqualTo(Player.TWO);
		assertThat(result.getBoardState()).containsExactly(
				PLAYER_1, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
		);
		assertThat(result.getWinner()).isNull();
	}

	@Test
	void shouldPlaceOForPlayer2() {
		Game application = new Game();
		application.start();

		application.play("A0");
		Result result = application.play("A1");

		assertThat(result.getNextPlayer()).isEqualTo(Player.ONE);
		assertThat(result.getBoardState()).containsExactly(
				PLAYER_1, UNOCCUPIED, UNOCCUPIED,
				PLAYER_2, UNOCCUPIED, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
		);
		assertThat(result.getWinner()).isNull();
	}

	@Test
	void shouldCheckIfCoordinateIsAlreadyOccupied() {
		Game application = new Game();
		application.start();

		application.play("A0");
		assertThrows(RuntimeException.class, () -> application.play("A0"));
	}

	@Test
	void shouldCheckForNonExistingCoordinates() {
		Game application = new Game();
		application.start();

		assertThrows(RuntimeException.class, () -> application.play("NOT_EXISTING"));
	}

	@Test
	void shouldWinWhenThreeInARow() { // horizontal
		Game application = new Game();
		application.start();

		application.play("A0");
		application.play("A1");
		application.play("B0");
		application.play("B1");
		Result result = application.play("C0");

		assertThat(result.getNextPlayer()).isEqualTo(null);
		assertThat(result.getBoardState()).containsExactly(
				PLAYER_1, PLAYER_1, PLAYER_1,
				PLAYER_2, PLAYER_2, UNOCCUPIED,
				UNOCCUPIED, UNOCCUPIED, UNOCCUPIED
		);
		assertThat(result.getWinner()).isEqualTo(Player.ONE);
	}

	@Test
	void shouldWinWhenThreeInAColumn() { // vertical
		Game application = new Game();
		application.start();

		application.play("A0");
		application.play("B0");
		application.play("A1");
		application.play("B1");
		Result result = application.play("A2");

		assertThat(result.getNextPlayer()).isEqualTo(null);
		assertThat(result.getBoardState()).containsExactly(
				PLAYER_1, PLAYER_2, UNOCCUPIED,
				PLAYER_1, PLAYER_2, UNOCCUPIED,
				PLAYER_1, UNOCCUPIED, UNOCCUPIED
		);
		assertThat(result.getWinner()).isEqualTo(Player.ONE);
	}

	@Test
	void shouldWinWhenThreeInDiagonalTopBottom() { // diagonal
		Game application = new Game();
		application.start();

		application.play("A0");
		application.play("C0");
		application.play("B1");
		application.play("C1");
		Result result = application.play("C2");

		assertThat(result.getNextPlayer()).isEqualTo(null);
		assertThat(result.getBoardState()).containsExactly(
				PLAYER_1, UNOCCUPIED, PLAYER_2,
				UNOCCUPIED, PLAYER_1, PLAYER_2,
				UNOCCUPIED, UNOCCUPIED, PLAYER_1
		);
		assertThat(result.getWinner()).isEqualTo(Player.ONE);
	}

	@Test
	void shouldWinWhenThreeInDiagonalBottomTop() { // diagonal
		Game application = new Game();
		application.start();

		application.play("A2");
		application.play("C1");
		application.play("B1");
		application.play("C2");
		Result result = application.play("C0");

		assertThat(result.getNextPlayer()).isEqualTo(null);
		assertThat(result.getBoardState()).containsExactly(
				UNOCCUPIED, UNOCCUPIED, PLAYER_1,
				UNOCCUPIED, PLAYER_1, PLAYER_2,
				PLAYER_1, UNOCCUPIED, PLAYER_2
		);
		assertThat(result.getWinner()).isEqualTo(Player.ONE);
	}
}
