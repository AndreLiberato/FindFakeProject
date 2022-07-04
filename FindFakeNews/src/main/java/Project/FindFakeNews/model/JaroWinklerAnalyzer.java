package Project.FindFakeNews.model;

import org.apache.commons.text.similarity.JaroWinklerDistance;

public class JaroWinklerAnalyzer implements SimilarityAnalyzer {

	@Override
	public double calculateDistance(String x, String y) {
		/* Jaro Similarity is the measure of similarity between two strings. 
		 * The value of Jaro distance ranges from 0 to 1.
		 * Where 1 means the strings are equal and 0 means no similarity between the two strings. 
		 */ 
		
		JaroWinklerDistance jaro = new JaroWinklerDistance();
		
		
		return jaro.apply(x, y) * 100;
	}

}
