package Project.FindFakeNews;

import java.text.Normalizer;
import java.util.Collections;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TextProcessor.
 * 
 * Classe responsável por processar todos os textos de entrada no programa.
 * 
 * @author AndreLiberato
 */
public class TextProcessor {
	private Integer wordSize;
	private String smallWordsRegex;
	private static final String repeatedWhiteSpacesRegex = "( {2,})+";
	private static final String whiteSpacesAtbeginningAndEndRegex = "^ | $";
	private static final String specialCharactersRegex = "[^a-z ]+";
	private static final String repeatedWordRegex = "\\b(\\w+)(?:\\W+\\1\\b)+";

	/**
	 * Construtor da classe. Configura o wordSize default para 3 e configura
	 * smallWordRegex com o valor de wordSize.
	 */
	TextProcessor() {
		setWordSize(3);
		configureSmallWordsRegex();
	}

	/**
	 * Setter do wordSize.
	 * 
	 * @param wordSize Inteiro que representa o tamanho das palavras que serão
	 * removidas.
	 */
	void setWordSize(Integer wordSize) {
		this.wordSize = wordSize;
	}

	/**
	 * Getter do wordSize.
	 * 
	 * @return Inteiro que representa o tamanho da palavra.
	 */
	Integer getWordSize() {
		return this.wordSize;
	}

	/**
	 * Configura o smallWordsRegex para um valor pré-definido de wordSize. O
	 * wordSize precisa estar previamente settado. Em caso de troca do valor de
	 * wordSize, chamar novamente a função de configuração.
	 */
	void configureSmallWordsRegex() {
		String wordSizeStr = getWordSize().toString();
		smallWordsRegex = "(?<= )([a-zA-Z]{1," + wordSizeStr + "})(?= )|^([a-zA-Z]{1," + wordSizeStr
				+ "})(?=\\W)|(?<= )([a-zA-Z]{1," + wordSizeStr + "})(?=\\W)";
	}

	/**
	 * Getter do smallWordsRegex.
	 * 
	 * @return String smallWordsRegex.
	 */
	String getSmallWordsRegex() {
		return this.smallWordsRegex;
	}

	/**
	 * Processa o texto chamando todas as funções auxiliares. A ordem das funções
	 * chamadas em processText afeta consideravelmente o resultado final.
	 * 
	 * @param text String contendo o texto que será processado.
	 * @return String contendo o texto processado.
	 */
	public String processText(String text) {
		text += " ";
		text = toLowerCase(text);
		text = removeAccents(text);
		text = removeSpecialCharacters(text);
		text = removeSmallWords(text);
		text = sortWords(text);
		text = removeRepeatedWords(text);
		text = normalizeWhiteSpaces(text);
		return text;
	}

	/**
	 * Remove palavras com tamanho menor ou igual a wordSize usando regex.
	 * 
	 * @param text String contendo o texto que será processado.
	 * @return String com o texto processado.
	 */
	private String removeSmallWords(String text) {
		return text.replaceAll(smallWordsRegex, "");
	}

	/**
	 * Altera todas as letras do texto para minúsculo.
	 * 
	 * @param text String contendo o texto que será processado.
	 * @return String com o texto processado.
	 */
	private String toLowerCase(String text) {
		return text.toLowerCase();
	}

	/**
	 * Remove os acentos dos caracteres usando regex.
	 * 
	 * @param text String contendo o texto que será processado.
	 * @return String com o texto processado.
	 */
	private String removeAccents(String text) {
		return Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	/**
	 * Remove todos os caracteres especiais usando regex.
	 * 
	 * @param text String contendo o texto que será processado.
	 * @return String com o texto processado.
	 */
	private String removeSpecialCharacters(String text) {
		return text.replaceAll(specialCharactersRegex, " ");
	}

	/**
	 * Remove as ocorrências de palavras repetidas usando regex. Essa função
	 * necessita que o text já esteja com as palavras ordenadas.
	 * 
	 * @param text String contendo o texto que será processado.
	 * @return String com o texto processado.
	 */
	private String removeRepeatedWords(String text) {
		Pattern pattern = Pattern.compile(repeatedWordRegex);
		Matcher matcher = pattern.matcher(text);
		String wordsNotRepeated = new String();
		while (matcher.find()) {
			wordsNotRepeated += matcher.group().split(" ")[0].toString() + " ";
		}
		text = text.replaceAll(repeatedWordRegex, "");
		text += " " + wordsNotRepeated;
		text = sortWords(text);
		return text;
	}

	/**
	 * Padroniza os espaços em branco do texto usando regex.
	 * 
	 * @param text String contendo o texto que será processado.
	 * @return String com o texto processado.
	 */
	private String normalizeWhiteSpaces(String text) {
		text = text.replaceAll(repeatedWhiteSpacesRegex, " ");
		text = text.replaceAll(whiteSpacesAtbeginningAndEndRegex, "");
		return text;
	}

	/**
	 * Ordena as palavras do texto em ordem alfabetica.
	 * 
	 * @param text String contendo o texto que será processado.
	 * @return String com o texto processado.
	 */
	private String sortWords(String text) {
		String[] splitedText = text.split(" ");
		Vector<String> vectorSort = new Vector<String>();
		for (String word : splitedText) {
			vectorSort.add(word);
		}
		;
		Collections.sort(vectorSort);
		String newText = new String();
		for (String word : vectorSort) {
			newText += word + " ";
		}
		return newText;
	}
}