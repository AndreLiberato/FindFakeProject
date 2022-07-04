package Project.FindFakeNews.model;

public interface SimilarityAnalyzer {
	double calculateDistance(String x, String y);
}
