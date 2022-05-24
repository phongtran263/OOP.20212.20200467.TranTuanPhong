package hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.time.LocalDate;

public class DigitalVideoDisc {
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.category = category;
		this.title = title;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String director, String category, String title, float cost) {
		super();
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.director = director;
		this.category = category;
		this.title = title;
		this.length = length;		
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
	}
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded;
	private static int nbDigitalVideoDiscs = 0;
	private int id = nbDigitalVideoDiscs;
	
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
	
	public String getTitle() {
		return this.title;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public String getDirector() {
		return this.director;
	}
	
	public int getLength() {
		return this.length;
	}
	
	public float getCost() {
		return this.cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public LocalDate getDateAdded() {
		return this.dateAdded;
	}

	public int getId() {
		return id;
	}
	
}

