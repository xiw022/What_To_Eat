package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import db.MySQLConnection;
import entity.Item;


// Recommendation based on geo distance and similar categories.
public class GeoRecommendation {

  public List<Item> recommendItems(String userId, double lat, double lon) {
		List<Item> recommendedItems = new ArrayList<>();
		
		// Step 1, get all favorited itemids
		MySQLConnection connection = new MySQLConnection();
		Set<String> favoriteItemIds = connection.getFavoriteItemIds(userId);

		// Step 2, get all categories, sort by count
		Map<String, Integer> allCategories = new HashMap<>();
		for(String itemId : favoriteItemIds) {
			Set<String> categories = connection.getCategories(itemId);
			for(String category : categories) {
				allCategories.put(category, allCategories.getOrDefault(category, 0) + 1);
			}
		}
		List<Entry<String, Integer>> categorylist = new ArrayList<>();
		
		// Step 3, search based on category, filter out favorite items
		
		connection.close();
		return recommendedItems;
  }
}

