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
	
	public Media(String title) {
		nbMedia++;
		this.id = nbMedia;
		this.setTitle(title);
	}
	
	public Media(boolean Null) {
		this.setTitle("Null media");
	}

	public boolean isMatch(String title2) {
		String[] titleSplit = this.getTitle().split(" ");
		String[] title2Split = title2.split(" ");
		
		for(String s: titleSplit) {
			for(String s2: title2Split) {
				if(s.equals(s2)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String toString() {
		if(this.getTitle().equals("Null media")) {
			return this.getTitle();
		}
		
		return "Media - " + this.getTitle();
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
