package Project.FindFakeNews.model;

import java.time.LocalDate;

public class News {
	private Integer id;
	private String originalText;
	private String processedText;
	private String url;
	private LocalDate date;
	
	
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
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	
}
