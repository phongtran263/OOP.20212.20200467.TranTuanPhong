package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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
			s+= ("\nLength: " + this.length);
		}
		s+= ("\nCost: " + this.getCost() + "$\n");
		
		return s;
	}
	
	@Override
	public void play() throws PlayerException{
		if(this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.length);
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-possitive!");
		}
	}
	
	@Override
	public String playString() throws PlayerException {
		if(this.getLength() > 0) {
			String result = "";
			
			result+= ("Playing DVD: " + this.getTitle() + "\n");
			result+= ("DVD length: " + this.getLength());
			
			return result;
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-possitive!");
		}
	}

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	@Override
	public String playStringForGUISwing() {
		return "<html>Playing DVD: " + this.getTitle() + "<br>" + "DVD length: " + this.length + "</html>";
	}
}

