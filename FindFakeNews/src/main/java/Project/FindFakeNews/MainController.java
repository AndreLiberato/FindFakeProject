package Project.FindFakeNews;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Project.FindFakeNews.DAO.NewsDAO;
import Project.FindFakeNews.model.AnalyzerOptions;
import Project.FindFakeNews.model.JaroWinklerAnalyzer;
import Project.FindFakeNews.model.LevenshteinAnalyzer;
import Project.FindFakeNews.model.News;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;



public class MainController implements Initializable {
    @FXML
	private TextArea textToAnalyze;
    @FXML
    private Label thresholdPercentage;
    @FXML
    private Slider thresholdSlider;
    @FXML
    private ToggleGroup group = new ToggleGroup();
    @FXML
    private RadioButton rbLevenshtein;
    @FXML
    private RadioButton rbJaroWinkler;
    @FXML
    private Label result;
    @FXML
    private Label resultTitle;
    @FXML
    private Text helperText;
    
    private NewsDAO newsDAO = new NewsDAO();
    private LevenshteinAnalyzer lAnalyzer = new LevenshteinAnalyzer();
    private JaroWinklerAnalyzer jwAnalyzer = new JaroWinklerAnalyzer();
    // private TextProcessor textProcessor = new TextProcessor();
  
    
    /**
     * Verifica se os dados inseridos são válidos, chama o método para analisar notícia e exibe resultado na tela
     * @author Lorena Toscano
     */
	@FXML
	public void handleSubmit(ActionEvent event) throws IOException {
		try {
			System.out.println(textToAnalyze.getText());
			
			if (textToAnalyze.getText().trim().isEmpty()) {
				throw new IOException("Campo obrigatório!");
			}
			
			String processedText = "";
			
//			processedText = textProcessor.processText(textToAnalyze.getText());

			boolean isFake = analyzeNews(processedText, (AnalyzerOptions) group.getSelectedToggle().getUserData());
			
			resultTitle.setVisible(true);
			
			if (isFake) {
				result.setText("Essa notícia pode ser falsa. Busque fontes confiáveis.");
				
			} else {
				result.setText("Essa notícia parece ser verdadeira!");
			}
			
			result.setVisible(true);
			
		} catch(IOException e) {
			helperText.setText(e.getMessage());
			helperText.setVisible(true);
		}
	}
	
	/**
	 * Percorre todas as notícias armazenadas aplicando o algoritmo de similaridade entre elas e a string 
	 * inserida até encontrar algum resultado maior ou igual ao threshold
	 * @author Lorena Toscano
	 */
	public boolean analyzeNews(String content, AnalyzerOptions analyzer) {
		double result = 0;
		
		for (News fakeNews : newsDAO.getNewsMap().values()) {
			if (analyzer == AnalyzerOptions.LEVENSHTEIN) {
				result = lAnalyzer.calculateDistance(content, fakeNews.getProcessedText());
			} else {
				result = jwAnalyzer.calculateDistance(content, fakeNews.getProcessedText());
			}
			
			if (result >= Double.parseDouble(thresholdPercentage.getText().split("%")[0])) {
				return true;
			}
		}
			
		return false; 
	}
	
	/**
	 * Carrega os dados das notícias do CSV e os armazena no DAO
	 * @author 
	 */
	public void loadData() throws IOException {
		
	}
  
	
	/**
	 * Ao iniciar a aplicação, chama o método de carregar os dados e adiciona configurações iniciais 
	 * aos elementos de input
	 * @author Lorena Toscano
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		try {
//			// Chama funçao loadData
//		} catch (IOException e) {
//			System.out.println("Erro na leitura do CSV!);
//		}
	  
		thresholdSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			thresholdPercentage.setText(Integer.toString(newValue.intValue()) + "%");
		});
		
		rbLevenshtein.setUserData(AnalyzerOptions.LEVENSHTEIN);
		rbJaroWinkler.setUserData(AnalyzerOptions.JARO_WINKLER);
	}
}