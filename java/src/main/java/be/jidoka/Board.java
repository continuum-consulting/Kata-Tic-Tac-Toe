package be.jidoka;

public class Board {

	private final String[][] board = new String[3][3];
	private final Printer printer;

	public Board(Printer printer) {
		this.printer = printer;
	}

	public void print() {
		for (int i = 0; i < board.length; i++) {
			printer.printLine(" - - -");
			printRow(board[i]);
		}
		printer.printLine(" - - -");
	}

	private void printRow(String[] row) {
		StringBuilder builder = new StringBuilder();
		for (String s : row) {
			builder.append("|");
			builder.append(s == null ? " " : s);
		}
		builder.append("|");
		String line = builder.toString();
		printer.printLine(line);
	}

	public void place(Symbol symbol, Coordinate coordinate) {
		board[coordinate.x()][coordinate.y()] = symbol.toString();
	}
}
