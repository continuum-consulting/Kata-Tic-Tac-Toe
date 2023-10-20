package be.jidoka;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

	private final Printer printer;
	private final Board board;
	private final Queue<Player> players;

	public Game(Printer printer) {
		this.printer = printer;
		this.board = new Board(printer);
		players = new LinkedList<>(List.of(new Player(Symbol.X), new Player(Symbol.O)));
	}

	public void start() {
		board.print();
		announcePlayer();
	}

	private void announcePlayer() {
		Player currentPlayer = players.peek();
		printer.printLine("Player %s, please enter a coordinate:".formatted(currentPlayer.symbol()));
	}

	public void makeTurn(Coordinate coordinate) {
		Player currentPlayer = players.poll();
		board.place(currentPlayer.symbol(), coordinate);
		board.print();
		players.add(currentPlayer);
		announcePlayer();
	}
}
