package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	private int length;
		
	
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
		String s = "DVD" + "\nTitle: " + this.getTitle() + "\nCategory: " + this.getCategory();
		if(this.director != null) {
			s+= ("\nDirector: " + this.director);
		}
		if(this.length != 0) {
			s+= ("\nDirector: " + this.length);
		}
		s+= ("\nCost: " + this.getCost());
		
		return s;
	}
	
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}

