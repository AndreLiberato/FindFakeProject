package Project.FindFakeNews.Model;

import org.apache.commons.text.similarity.JaroWinklerDistance;

public class JaroWinklerAnalyzer implements SimilarityAnalyzer {

	@Override
	public double calculateDistance(String x, String y) {
		/*
		 * Calcula a similaridade entre duas strings utilizando o algoritmo Jaro-Winkler
		 * Depois converte para porcentagem.
		 * 
		 * @author Gabriel Bassani
		 */

		JaroWinklerDistance jaro = new JaroWinklerDistance();

		return jaro.apply(x, y) * 100;
	}

}
