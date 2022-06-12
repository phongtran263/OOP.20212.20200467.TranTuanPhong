package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(String title) {
		super();
		this.setTitle(title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.director = director;
		this.setCategory(category);
		this.setTitle(title);
		this.setCost(cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.director = director;
		this.setCategory(category);
		this.setTitle(title);
		this.length = length;
		this.setCost(cost);
	}
	
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
	}
	
	private String director;
	private int length;
		
	public String getDirector() {
		return this.director;
	}
	
	public int getLength() {
		return this.length;
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}

