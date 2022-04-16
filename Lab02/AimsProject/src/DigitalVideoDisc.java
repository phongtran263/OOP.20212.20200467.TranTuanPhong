
public class DigitalVideoDisc {
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	
	public DigitalVideoDisc(String category, String title, float cost) {
		super();
		this.title = title;
	}
	
	public DigitalVideoDisc(String director, String category, String title, float cost) {
		super();
		this.title = title;
	}
	
	public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
		super();
		this.title = title;
	}
	
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	public String getTitle() {
		return title;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	public float getCost() {
		return cost;
	}
	
}
