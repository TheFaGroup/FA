package fa;

import java.util.ArrayList;

public class Feed {
	public String uri;
	private ArrayList<Article> articleList;
	private DbConnector dbConnector;
	
	public void updateArticleList() {
	
	}
	
	public Feed(String uri) {
		this.uri = uri;
	}
}
