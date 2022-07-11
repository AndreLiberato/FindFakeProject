package Project.FindFakeNews.Model;

import org.apache.commons.text.similarity.LevenshteinDistance;

/*
 * Calcula a similaridade entre duas strings utilizando o algoritmo Levenshtein
 * Depois converte para porcentagem.
 * 
 * O algoritmo Levenshtein mostra o número de mudanças (caracteres) que devem
 * serem feitas para uma string se tornar igual a outar.
 * 
 * @author Gabriel Bassani
 */
public class LevenshteinAnalyzer implements SimilarityAnalyzer {
	public double calculateDistance(String x, String y) {
		

		double maxLength = Double.max(x.length(), y.length());
		double distanceLevenshtein = LevenshteinDistance.getDefaultInstance().apply(x, y);
		return 100 - ((100 * distanceLevenshtein) / maxLength);
	}

}
