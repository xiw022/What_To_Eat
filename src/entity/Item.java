
package entity;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Item {
	private String itemId;
	private String name;
	private double rating;
	private String address;
	private double distance;
	private Set<String> categories;
	private String imageUrl;
	private String url;
	
	private Item(ItemBuilder builder) {
		this.itemId = builder.itemId;
		this.name = builder.name;
		this.rating = builder.rating;
		this.address = builder.address;
		this.distance = builder.distance;
		this.categories = builder.categories;
		this.imageUrl = builder.imageUrl;
		this.url = builder.url;
	}

	public String getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getUrl() {
		return url;
	}

	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("item_id", itemId);
			obj.put("name", name);
			obj.put("rating", rating);
			obj.put("address", address);
			obj.put("distance", distance);
			obj.put("categories", new JSONArray(categories));
			obj.put("image_url", imageUrl);
			obj.put("url", url);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static class ItemBuilder {
		private String itemId;
		private String name;
		private double rating;
		private String address;
		private double distance;
		private Set<String> categories;
		private String imageUrl;
		private String url;
		
		public ItemBuilder setItemId(String itemId) {
			this.itemId = itemId;
			return this;
		}

		public ItemBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public ItemBuilder setRating(double rating) {
			this.rating = rating;
			return this;
		}

		public ItemBuilder setAddress(String address) {
			this.address = address;
			return this;
		}

		public ItemBuilder setDistance(double distance) {
			this.distance = distance;
			return this;
		}

		public ItemBuilder setCategories(Set<String> categories) {
			this.categories = categories;
			return this;
		}

		public ItemBuilder setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
			return this;
		}

		public ItemBuilder setUrl(String url) {
			this.url = url;
			return this;
		}

		public Item build() {
			return new Item(this);
		}

	}

	public double getRating() {
		// TODO Auto-generated method stub
		return rating;
	}

	public double getDistance() {
		// TODO Auto-generated method stub
		return distance;
	}

	public Set<String> getCategories() {
		// TODO Auto-generated method stub
		return categories;
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
}
