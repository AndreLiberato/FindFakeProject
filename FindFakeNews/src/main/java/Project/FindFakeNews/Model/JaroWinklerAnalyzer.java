package Project.FindFakeNews.Model;

import org.apache.commons.text.similarity.JaroWinklerDistance;

/*
 * Calcula a similaridade entre duas strings utilizando o algoritmo Jaro-Winkler
 * Depois converte para porcentagem.
 * 
 * @author Gabriel Bassani
 */
public class JaroWinklerAnalyzer implements SimilarityAnalyzer {

	@Override
	public double calculateDistance(String x, String y) {
		

		JaroWinklerDistance jaro = new JaroWinklerDistance();

		return jaro.apply(x, y) * 100;
	}

}
