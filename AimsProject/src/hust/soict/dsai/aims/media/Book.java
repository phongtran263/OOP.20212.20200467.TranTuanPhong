package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();
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

	public List<String> getAuthors() {
		return authors;
	}

	public String toString() {		
		String authorsString = this.authors.get(0);
		
		for(int i = 1; i < this.authors.size(); i++) {
			authorsString+=", ";
			authorsString+=this.authors.get(i);
		}
		
		return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + authorsString + ": " + this.getCost() + "$";
	}
}
