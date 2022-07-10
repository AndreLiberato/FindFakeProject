package Project.FindFakeNews.model;

import org.apache.commons.text.similarity.LevenshteinDistance;

public class LevenshteinAnalyzer implements SimilarityAnalyzer {
	public double calculateDistance(String x, String y) {
		/* Calcula a similaridade entre duas strings utilizando o algoritmo Levenshtein
		 * Depois converte para porcentagem.
		 * 
		 * O algoritmo Levenshtein mostra o número de mudanças (caracteres) que devem serem feitas 
		 * para uma string se tornar igual a outar.
		 * @author Gabriel Bassani
		 */ 
		
		double maxLength = Double.max(x.length(), y.length());
		System.out.println("maxLength: " + maxLength);
		 return ((maxLength - LevenshteinDistance.getDefaultInstance().apply(x, y))/maxLength) * 100;
	}
	
}
