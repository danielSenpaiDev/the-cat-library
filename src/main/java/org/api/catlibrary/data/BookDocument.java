package org.api.catlibrary.data;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="books")
public class BookDocument {
	@Id
	private String id;
	private String title;
	private String description;
	private String author;
	private int price;
	private HashMap<String, Boolean> votes;
	
	public HashMap<String, Boolean> getVotes() {
		return votes;
	}
	public void setVotes(HashMap<String, Boolean> votes) {
		this.votes = votes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
