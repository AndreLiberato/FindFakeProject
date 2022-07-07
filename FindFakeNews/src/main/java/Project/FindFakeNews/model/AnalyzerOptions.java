package Project.FindFakeNews.model;

public enum AnalyzerOptions {
	LEVENSHTEIN(1), JARO_WINKLER(2);
	
	private final int value;
	
	AnalyzerOptions(int optionValue) {
		value = optionValue;
	}

	public int getValue() {
		return value;
	}
}
