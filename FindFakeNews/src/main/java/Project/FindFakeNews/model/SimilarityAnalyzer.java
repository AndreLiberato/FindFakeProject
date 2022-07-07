package Project.FindFakeNews.model;

public interface SimilarityAnalyzer {
	public double calculateDistance(String x, String y);
}
