package be.jidoka;

import java.util.List;

public class Zet {

	private final String coordinate;

	private static final List<String> boardCoordinates = List.of(
			"A0", "B0", "C0",
			"A1", "B1", "C1",
			"A2", "B2", "C2"
	);

	private Zet(String coordinate) {
		this.coordinate = coordinate;
	}

	public static Zet parse(String coordinate) {
		if (!boardCoordinates.contains(coordinate)) {
			throw new RuntimeException("Coordinate doesn't exist");
		}

		return new Zet(coordinate);
	}

	public int getIndex() {
		return boardCoordinates.indexOf(coordinate);
	}
}
