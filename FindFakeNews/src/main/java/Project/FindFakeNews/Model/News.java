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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOriginalText() {
		return originalText;
	}

	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

	public String getProcessedText() {
		return processedText;
	}

	public void setProcessedText(String processedText) {
		this.processedText = processedText;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}