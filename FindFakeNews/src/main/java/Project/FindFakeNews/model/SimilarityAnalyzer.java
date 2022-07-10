package Project.FindFakeNews.model;

/* Classe responsável por definir a função calculateDistance(), que busca a similaridade entre strings.
 * @author Gabriel Bassani
 */
public interface SimilarityAnalyzer {
	/**
	 * Faz o calculo da similaridades entre strings. Pode utilizar o algorítmo
	 * Jaro-Winkler ou Levenshtein.
	 * 
	 * @author Gabriel Bassani
	 */
	public double calculateDistance(String x, String y);
}
