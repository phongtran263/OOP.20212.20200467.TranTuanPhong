public class DigitalVideoDisc {
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		this.category = category;
		this.title = title;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String director, String category, String title, float cost) {
		super();
		this.director = director;
		this.category = category;
		this.title = title;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
		super();
		this.director = director;
		this.category = category;
		this.title = title;
		this.length = length;		
		this.cost = cost;
	}
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
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
	
}

