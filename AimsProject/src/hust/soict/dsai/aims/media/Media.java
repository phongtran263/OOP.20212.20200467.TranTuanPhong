package hust.soict.dsai.aims.media;

import java.time.LocalDate;

public class Media {

	private static int nbMedia = 0;
	private int id = nbMedia;
	private String title;
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	public Media() {
		nbMedia++;
		this.id = nbMedia;
		this.dateAdded = LocalDate.now();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

}
