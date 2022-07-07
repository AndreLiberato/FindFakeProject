package Project.FindFakeNews.DAO;

import java.util.HashMap;

import Project.FindFakeNews.model.News;

public class NewsDao {
	private HashMap<Integer, News> newsMap = new HashMap<Integer, News>();
	
	public void addNews(News news) {
		this.newsMap.put(news.getId(), news);
	}
}
