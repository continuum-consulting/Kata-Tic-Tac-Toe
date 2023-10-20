package be.jidoka;

public class PrintAssert implements Printer {
	protected String printedContent = "";

	@Override
	public void printLine(String value) {
		printedContent += value;
		printedContent += "\n";
	}

	public void reset() {
		printedContent = "";
	}
}
