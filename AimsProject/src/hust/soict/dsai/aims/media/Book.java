package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	
	private List<String> authors = new ArrayList<String>();
	
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public Book() {
		
	}
	
	public void addAuthor(String authorName) {
		
	}

	public void removeAuthor(String authorName) {
		
	}

	public List<String> getAuthors() {
		return authors;
	}
}
