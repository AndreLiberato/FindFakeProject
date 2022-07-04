package Project.FindFakeNews.model;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class LevenshteinAnalyzer implements SimilarityAnalyzer {
	public double calculateDistance(String x, String y) {
		
		/* Find the Levenshtein distance between two Strings.
		 * A higher score indicates a greater distance.
		 * This is the number of changes needed to change one sequence into another, 
		 * where each change is a single character modification.
		 */ 
		double maxLength = Double.max(x.length(), y.length());
		System.out.println("maxLength: " + maxLength);
		 return ((maxLength - LevenshteinDistance.getDefaultInstance().apply(x, y))/maxLength) * 100;
	}
	
}
