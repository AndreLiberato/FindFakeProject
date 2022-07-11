package Project.FindFakeNews;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.ResourceBundle;

import Project.FindFakeNews.Controller.TextProcessor;
import Project.FindFakeNews.DAO.NewsDAO;
import Project.FindFakeNews.Model.AnalyzerOptions;
import Project.FindFakeNews.Model.JaroWinklerAnalyzer;
import Project.FindFakeNews.Model.LevenshteinAnalyzer;
import Project.FindFakeNews.Model.News;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
	private ChoiceBox<String> wordSizeSelect;
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
	private TextProcessor textProcessor = new TextProcessor();

	/**
	 * Verifica se os dados inseridos são válidos, chama o método para analisar
	 * notícia e exibe resultado na tela
	 * 
	 * @param event Evento acionado pelo clique no botão.
	 * 
	 * @author LorenaToscano
	 */
	@FXML
	public void handleSubmit(ActionEvent event) throws IOException {
		try {
			if (textToAnalyze.getText().trim().isEmpty()) {
				throw new IOException("Campo obrigatório!");
			}

			String processedText = textProcessor.processText(textToAnalyze.getText());
			boolean isFake = analyzeNews(processedText, (AnalyzerOptions) group.getSelectedToggle().getUserData());
			resultTitle.setVisible(true);

			if (isFake) {
				result.setText("Essa notícia pode ser falsa. Busque fontes confiáveis.");

			} else {
				result.setText("Essa notícia parece ser verdadeira!");
			}

			result.setVisible(true);

		} catch (IOException e) {
			helperText.setText(e.getMessage());
			helperText.setVisible(true);
		}
	}

	/**
	 * Percorre todas as notícias armazenadas aplicando o algoritmo de similaridade
	 * entre elas e a notícia inserida até encontrar algum resultado maior ou igual
	 * ao threshold
	 * 
	 * @param content  String com conteúdo processado da notícia.
	 * @param analyzer Enum que indica qual algoritmo foi escolhido para a análise
	 *                 de similaridade.
	 * @return Booleano indicando se a notícia é fake ou não.
	 * 
	 * @author LorenaToscano
	 */
	public boolean analyzeNews(String content, AnalyzerOptions analyzer) {
		double result = 0;
		Collection<News> collectionNews = newsDAO.getNewsMap().values();

		switch (analyzer) {
		case LEVENSHTEIN:
			for (News fakeNews : collectionNews) {
				result = lAnalyzer.calculateDistance(content, fakeNews.getProcessedText());
				if (result >= Double.parseDouble(thresholdPercentage.getText().split("%")[0])) {
					return true;
				}
			}
			break;
		case JARO_WINKLER:
			for (News fakeNews : collectionNews) {
				result = jwAnalyzer.calculateDistance(content, fakeNews.getProcessedText());
				if (result >= Double.parseDouble(thresholdPercentage.getText().split("%")[0])) {
					return true;
				}
			}
			break;
		}

		return false;
	}

	/**
	 * Carrega os dados das notícias do CSV e os armazena no DAO
	 * 
	 * @author Gabriel Bassani
	 */
	public void loadData() throws IOException, FileNotFoundException {
		String file = "src\\data\\boatos.csv";
		BufferedReader reader = null;
		String line = "";
		String separador = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		try {
			reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				News news = new News();

				String[] colunas = line.split(separador);

				if (colunas.length == 4) {
					news.setId(Integer.parseInt(colunas[0]));
					news.setOriginalText(colunas[1]);
					news.setProcessedText(textProcessor.processText(colunas[1]));
					news.setUrl(colunas[2]);
					LocalDateTime dateTime = LocalDateTime.parse(colunas[3], formatador);
					news.setDate(dateTime);
					newsDAO.addNews(news);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}

	}

	/**
	 * Ao iniciar a aplicação, chama o método de carregar os dados e adiciona
	 * configurações iniciais aos elementos de input
	 * 
	 * @author LorenaToscano
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			loadData();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		wordSizeSelect.setItems(FXCollections.observableArrayList("2 caracteres", "3 caracteres", "4 caracteres"));

		wordSizeSelect.setValue("3 caracteres");

		wordSizeSelect.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			textProcessor.setWordSize(Integer.parseInt(newValue.split(" ")[0]));
			textProcessor.configureSmallWordsRegex();

			try {
				loadData();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		});

		thresholdSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
			thresholdPercentage.setText(Integer.toString(newValue.intValue()) + "%");
		});

		rbLevenshtein.setUserData(AnalyzerOptions.LEVENSHTEIN);
		rbJaroWinkler.setUserData(AnalyzerOptions.JARO_WINKLER);
	}

}