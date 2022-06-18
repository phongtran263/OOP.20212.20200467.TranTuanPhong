package hust.soict.dsai.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{

	private static int nbMedia = 0;
	private int id = nbMedia;
	private String title; 
	private String category;
	private float cost;
	private LocalDate dateAdded;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media() {
		nbMedia++;
		this.id = nbMedia;
		this.dateAdded = LocalDate.now();
	}
	
	public boolean isMatch(String title2) {
		String[] titleSplit = this.getTitle().toLowerCase().split(" ");
		String[] title2Split = title2.toLowerCase().split(" ");
		
		for(String s: titleSplit) {
			for(String s2: title2Split) {
				if(s.equals(s2)) {
					return true;
				}
			}
		}
		
		return false;
	}
		
	@Override
	public boolean equals(Object o) {
		if(o instanceof Media) {
			return this.getId() == ((Media) o).getId();
		}
		
		return false;
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
	
	public LocalDate getDateAdded() {
		return dateAdded;
	}

	@Override
	public int compareTo(Media o) {
		int l1 = this.getTitle().length();
		int l2 = o.getTitle().length();
		
		int lenMin = Math.min(l1, l2);
		for(int i = 0; i < lenMin; i++) {
			if((int)this.getTitle().toLowerCase().charAt(i) != (int)o.getTitle().toLowerCase().charAt(i)) {
				return (int)this.getTitle().toLowerCase().charAt(i) - (int)o.getTitle().toLowerCase().charAt(i);
			}
		}
		if(l1 != l2) {
			return l1 - l2;
		}

		int cl1 = this.getCategory().length();
		int cl2 = o.getCategory().length();
		
		int clenMin = Math.min(cl1, cl2);
		for(int i = 0; i < clenMin; i++) {
			if((int)this.getCategory().toLowerCase().charAt(i) != (int)o.getCategory().toLowerCase().charAt(i)) {
				return (int)this.getCategory().toLowerCase().charAt(i) - (int)o.getCategory().toLowerCase().charAt(i);
			}
		}

		
		return cl1 - cl2;
	}
}
