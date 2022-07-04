package Project.FindFakeNews.model;

public class teste {

	public static void main(String[] args) {
		// Pode ser apagado, tô usando esse arquivo como teste
		LevenshteinAnalyzer a = new LevenshteinAnalyzer();
		JaroWinklerAnalyzer b = new JaroWinklerAnalyzer();
		
		System.out.println(a.calculateDistance("Gabriel Bassani", "Gabriel Bassanii"));
		System.out.println(b.calculateDistance("Gabriel", "Gabriel"));
	}

}
