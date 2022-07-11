package Project.FindFakeNews.Model;

import java.time.LocalDateTime;

/* Classe para representar as notícias.
 * @author Gabriel Bassani
 */
public class News {
	private Integer id;
	private String originalText;
	private String processedText;
	private String url;
	private LocalDateTime date;

	/**
	 * Getter do id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter do id.
	 * 
	 * @param id inteiro contendo o id da notícia.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter do originalText.
	 */
	public String getOriginalText() {
		return originalText;
	}

	/**
	 * Setter do originalText.
	 * 
	 * @param originalText string contento o texto original da notícia.
	 */
	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	/**
	 * Getter do processedText.
	 */
	public String getProcessedText() {
		return processedText;
	}

	/**
	 * Setter do processedText.
	 * 
	 * @param processedText string contendo o texto da notícia após ser processada.
	 */
	public void setProcessedText(String processedText) {
		this.processedText = processedText;
	}

	/**
	 * Getter da Url.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Setter da Url.
	 * 
	 * @param url string contendo o link da notícia.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Getter do date.
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Setter do date.
	 * 
	 * @param date timestamp contendo data e hora.
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
