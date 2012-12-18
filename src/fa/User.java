package fa;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
	private static DbConnector dbConnector; 
	private static HashMap<Integer, FeedBag> userMap;
	
	public static Integer login(String username, String password) {
		Integer loginId;
		FeedBag newUser;
		
		// Überprüfen ob name/password korrekt und loginId
		loginId = 0;
		if(loginId != 0) {
			newUser = new FeedBag();
			userMap.put(loginId, newUser);
		}
		
		return loginId;
	}
	
	public static void logout(Integer loginId) {
		if(userMap.get(loginId) != null) {
			userMap.remove(loginId);
		}
	}
	
	public static ArrayList<Tuple<String, String>> pullFeeds(Integer loginId) {
		ArrayList<Tuple<String, String>> tempList = new ArrayList<Tuple<String, String>>();
		
		for(Tuple<Feed, String> listItem: userMap.get(loginId).feedList) {
			tempList.add(new Tuple<String, String>(listItem.x.uri, listItem.y));
		}
		
		return tempList;
	}
	
	public static ArrayList<Article> pullArticleFromFeed(String uri, Integer loginId) {
		return null;
	}
	
	public static ArrayList<Article> pullFromTag(Integer loginId, String tagName) {
		return null;
	}
	
	public static ArrayList<String> pullTags(Integer loginId) {
		return null;
	}
	
	public static void addFeed(Integer loginId, String uri, String name) {
		userMap.get(loginId).addFeed(uri, name);
	}
	
	public static void deleteFeed(Integer loginId, String uri) {
		userMap.get(loginId).deleteFeed(uri);
	}
	
	public static void renameFeed(Integer loginId, String uri, String name) {
		userMap.get(loginId).renameFeed(uri, name);
	}
	
	public static void markArticleAsReaded(Integer loginId, String uri, Article article) {
		userMap.get(loginId).markArticleAsReaded(uri, article);
	}
	
	public static void markFeedAsReaded(Integer loginId, String uri) {
		userMap.get(loginId).markFeedAsReaded(uri);
	}
	
	public static void markAllFeedAsReaded(Integer loginId) {
		userMap.get(loginId).markAllFeedAsReaded();
	}
	
	public static void addFeedToTag(Integer loginId, String uri, String tagName) {
		userMap.get(loginId).addFeedToTag(userMap.get(loginId).lookupFeed(uri), tagName);
	}
	
	public static void removeFeedFromTag(Integer loginId, String uri, String tagName) {
		userMap.get(loginId).removeFeedFromTag(userMap.get(loginId).lookupFeed(uri), tagName);
	}
		
	public static void removeTag(Integer loginId, String name) {
		userMap.get(loginId).removeTag(name);
	}
	
	public static void addTag(Integer loginId, String name) {
		userMap.get(loginId).addTag(name);
	}
	
	public static void registerUser(String username, String password) {
		// DB Zeugs
	}
	
	public static void main (String[] args) {
		dbConnector = new DbConnector();
		
		try {
			dbConnector.connectDb();
		} catch(Exception e) {
			System.out.println("EXTRAODINARY_CRITICAL_ERROR [1]: Database Con not useable!");
		}
	}
}
