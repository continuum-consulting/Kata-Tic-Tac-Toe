package be.jidoka;

public enum Player {
	ONE(BoxState.PLAYER_1),
	TWO(BoxState.PLAYER_2);

	private final BoxState boxState;

	Player(BoxState boxState) {
		this.boxState = boxState;
	}

	public BoxState getBoxState() {
		return boxState;
	}
}
