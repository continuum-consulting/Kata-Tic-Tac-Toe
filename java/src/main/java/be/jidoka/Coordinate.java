package be.jidoka;

import static java.lang.Integer.parseInt;

public record Coordinate(int x, int y) {

	public static Coordinate parse(String coordinate) {
		String[] parts = coordinate.split(",");
		return new Coordinate(parseInt(parts[0]), parseInt(parts[1]));
	}
}
