package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		int l1 = o1.getTitle().length();
		int l2 = o2.getTitle().length();
		
		int lenMin = Math.min(l1, l2);
		for(int i = 0; i < lenMin; i++) {
			int num1 = (int)o1.getTitle().charAt(i);
			int num2 = (int)o2.getTitle().charAt(i);
			if(num1 != num2) {
				return (int) ((num1 - num2)/Math.abs(num1 - num2));
			}
		}
		if(l1 != l2) {
			return (int) ((l1 - l2)/Math.abs(l1 - l2));
		}
		
		if(o1.getCost() > o2.getCost()) {
			return -1;
		}
		
		else if(o1.getCost() < o2.getCost()) {
			return 1;
		}
		
		return 0;
	}
	
}
