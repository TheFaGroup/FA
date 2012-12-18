package fa;

import java.util.ArrayList;

public class FeedBag {
	private ArrayList<Tuple<Feed, ArrayList<Article>>> unreadedArticle;
	private ArrayList<Tuple<String, ArrayList<Feed>>> tag;
	public ArrayList<Tuple<Feed, String>> feedList;
	private DbConnector dbConnector;
	
	public void addFeed(String uri, String name) {
		// Lese feedList aus DB und setze feedList
		
		feedList.add(new Tuple<Feed, String>(new Feed(uri), name));
		
		// Schreibe geändert in DB
	}
	
	public void deleteFeed(String uri) {
		// Lese feedList aus DB und setze feedList
		
		for(Tuple<Feed, String> feedTemp: feedList) {
			if(feedTemp.x.uri == uri) {
				feedList.remove(feedTemp);
				break;
			}
		}
		
		// Schreibe feedList in DB
	}
	
	public void renameFeed(String uri, String name) {
		// Lese feedList aus DB und setze feedList
		
		for(Tuple<Feed, String> feedTemp: feedList) {
			if(feedTemp.x.uri == uri) {
				feedList.get(feedList.indexOf(feedTemp)).y = name;
				break;
			}
		}		
		
		// Schreibe feedList in DB
	}
	
	public void markArticleAsReaded(String uri, Article article) {
		// Lese feedList aus DB und setze feedList
		
		for(Tuple<Feed, ArrayList<Article>> unreadedTupleArticleTemp: unreadedArticle) {
			if(unreadedTupleArticleTemp.x.uri == uri) {
				for(Article unreadedArticleTemp: unreadedTupleArticleTemp.y) {
					if(article == unreadedArticleTemp) {
						ArrayList<Article> tmp = new ArrayList<Article>();
						
						//tmp = unreadedArticle.get(unreadedArticle.indexOf(unreadedTupleArticleTemp));
						
						
						break;
					}
				}
			}
		}
		
		// Schreibe feedList in DB
	}
	
	public void markFeedAsReaded(String uri) {
		// Lese feedList aus DB und setze feedList
		
		for(Tuple<Feed, ArrayList<Article>> unreadedArticleTemp: unreadedArticle) {
			if(unreadedArticleTemp.x.uri == uri) {
				unreadedArticleTemp.y.remove(unreadedArticleTemp);
				break;
			}
		}
		
		// Schreibe feedList in DB
	}
	
	public void markAllFeedAsReaded() {
	
	}
	
	public void addFeedToTag(Feed feed, String name) {
	
	}
	
	public void removeFeedFromTag(Feed feed, String name) {
	
	}
	
	public void removeTag(String name) {
	
	}
	
	public void addTag(String name) {
	
	}
	
	public Feed lookupFeed(String feedUri) {
		return null;
	}
}
