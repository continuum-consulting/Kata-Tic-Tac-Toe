package be.jidoka;

import java.util.List;

public class Result {

	private final String message;

	private final List<String> coordinates;

	public Result(String message, List<String> coordinates) {
		this.message = message;
		this.coordinates = coordinates;
	}

	public String getMessage() {
		return message;
	}

	public List<String> getCoordinates() {
		return coordinates;
	}
}
