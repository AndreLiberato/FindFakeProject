package Project.FindFakeNews.DAO;

import java.util.HashMap;

import Project.FindFakeNews.model.News;

public class NewsDAO {
	private HashMap<Integer, News> newsMap = new HashMap<Integer, News>();
	
	public HashMap<Integer, News> getNewsMap() {
		return newsMap;
	}
	
	public void addNews(News news) {
		this.newsMap.put(news.getId(), news);
	}
}
