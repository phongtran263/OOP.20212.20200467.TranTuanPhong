package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private int id;
	private String title; 
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("This author has been already existed.");
		}
		
		else {
			authors.add(authorName);
			System.out.println("This author has been added.");
		}
	}
	
	public void removeAuthor(String authorName) {
		if(!authors.contains(authorName)) {
			System.out.println("This author hasn't been existed.");
		}
		
		else {
			authors.remove(authorName);
			System.out.println("This author has been removed.");
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

}
