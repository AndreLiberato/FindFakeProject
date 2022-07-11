package Project.FindFakeNews.DAO;

import java.util.HashMap;

import Project.FindFakeNews.Model.News;

/* Classe para armazenas as notícias.
 * @author Gabriel Bassani
 */
public class NewsDAO {
	private HashMap<Integer, News> newsMap = new HashMap<Integer, News>();

	/**
	 * Getter do HashMap newsMap.
	 */
	public HashMap<Integer, News> getNewsMap() {
		return newsMap;
	}

	/**
	 * Metodo para adicionar objeto de notícia (News) ao Hashmap da classe NewsDAO.
	 * 
	 * @param news objeto de notícia (News).
	 */
	public void addNews(News news) {
		this.newsMap.put(news.getId(), news);
	}
}
