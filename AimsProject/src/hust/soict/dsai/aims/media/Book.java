package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Book extends Media{

	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens = new ArrayList<String>();
	private Map<String, Integer> wordFrequency = new TreeMap<String, Integer>();
	
	public Book(String title, List<String> authors, String content, String category, float cost) {
		super();
		this.setTitle(title);
		this.content = content;
		this.setCategory(category);
		this.setCost(cost);
		this.authors = authors;
		this.processContent();
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
		
		String FreqString = "";	
		int size = this.wordFrequency.size();
		int i = 0;
		for (Entry<String, Integer> entry : this.wordFrequency.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			FreqString+= (key + ": " + value);
			if(i < size - 1) {
				FreqString+=", ";
			}
			i++;
		}
		
		return "Book" + "\nTitle: " + this.getTitle() + "\nCategory: " + this.getCategory() + "\nContent: " + this.content + "\nLength: " + this.contentTokens.size() + "\nWord frequency: " + FreqString + "\nAuthors: " + authorsString + "\nCost: " + this.getCost() + "$\n";
	}
	
	public void processContent() {
		this.contentTokens = Arrays.asList(this.content.toLowerCase().split("\\P{L}+"));
						
		Collections.sort(this.contentTokens);
		
		for(String s: this.contentTokens) {
			this.wordFrequency.compute(s, (k, v) -> v == null ? 1 : v + 1);
		}
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
