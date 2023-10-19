package be.jidoka;

import java.util.List;

public class WinCondition {

	public static final List<WinCondition> WIN_CONDITIONS = List.of(
			// Horizontal
			new WinCondition(0, 1, 2),
			new WinCondition(3, 4, 5),
			new WinCondition(6, 7, 8),
			// Vertical
			new WinCondition(0, 3, 6),
			new WinCondition(1, 4, 7),
			new WinCondition(2, 5, 8),
			// Diagonal
			new WinCondition(0, 4, 8),
			new WinCondition(6, 4, 2)
	);

	private final int x;
	private final int y;
	private final int z;

	public WinCondition(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}
}
