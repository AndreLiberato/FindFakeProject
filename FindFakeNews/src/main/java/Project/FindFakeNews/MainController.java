package Project.FindFakeNews;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Project.FindFakeNews.model.AnalyzerOptions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
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
  
    /**
     * Verifica se os dados inseridos são válidos, chama o método para analisar notícia e exibe resultado na tela
     * @author Lorena Toscano
     */
	@FXML
	public void handleSubmit(ActionEvent event) throws IOException {
		try {
			System.out.println(textToAnalyze.getText());
			System.out.println(group.getSelectedToggle().getUserData());
			System.out.println(thresholdPercentage.getText());
			
			boolean isFake = analyzeNews(textToAnalyze.getText(), (AnalyzerOptions) group.getSelectedToggle().getUserData());
			
			resultTitle.setText("Resultado:");
			
			if (isFake) {
				result.setText("Essa notícia pode ser falsa. Busque fontes confiáveis.");
			} else {
				result.setText("Essa notícia parece ser verdadeira!");
			}
			
		} catch(Exception e) {
			// Mostra na tela que o texto inserido é inválido
		}
	}
	
	public boolean analyzeNews(String text, AnalyzerOptions analyzer) {
		if (analyzer == AnalyzerOptions.LEVENSHTEIN) {
			// Aplica algoritmo de Leveshtein
		} else {
			// Aplica algoritmo de JaroWinkler
		}
		return false;
	}
  
	
	/**
	 * Ao iniciar a aplicação, ccarrega os dados do dataset e adiciona configurações iniciais nos elementos de input
	 * @author Lorena Toscano
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		try {
//			// Chama funçao loadData
//		} catch (IOException e) {
//			System.out.println("Erro na leitura do dataset!);
//			System.out.println(e.getMessage());
//		}
	  
		thresholdSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			thresholdPercentage.setText(Integer.toString(newValue.intValue()) + "%");
		});
		rbLevenshtein.setUserData(1);
		rbLevenshtein.setToggleGroup(group);
		rbLevenshtein.setSelected(true);
		rbJaroWinkler.setUserData(2);
		rbJaroWinkler.setToggleGroup(group);
	}
}