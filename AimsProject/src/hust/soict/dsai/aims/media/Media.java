package hust.soict.dsai.aims.media;

public class Media {

	private static int nbMedia = 0;
	private int id = nbMedia;
	private String title; 
	private String category;
	private float cost;
	
	public Media() {
		nbMedia++;
		this.id = nbMedia;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

}
