package hust.soict.dsai.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Media{
	
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
		this.dateAdded = LocalDate.now();
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		this.dateAdded = LocalDate.now();
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.setDirector(director);
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
		this.dateAdded = LocalDate.now();
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.setDirector(director);
		this.setCategory(category);
		this.setTitle(title);
		this.setLength(length);
		this.setCost(cost);
		this.dateAdded = LocalDate.now();
	}
	
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
	}
	
	private String director;
	private int length;
	private LocalDate dateAdded;
	
	public boolean isMatch(String title) {
		String[] myTitle = this.getTitle().split(" ");
		String[] yourTitle = title.split(" ");
		
		for(int i = 0; i < myTitle.length; i++) {
			for(int j = 0; j < yourTitle.length; j++) {
				String str1 = myTitle[i].toLowerCase();
				String str2 = yourTitle[j].toLowerCase();
				if(str1.equals(str2)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String getDirector() {
		return this.director;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public LocalDate getDateAdded() {
		return this.dateAdded;
	}
	
}

