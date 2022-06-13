package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		Collection collection = new ArrayList();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 19.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King", "Animation", 18.99f);

		
		collection.add(dvd2);
		collection.add (dvd1);
		collection.add (dvd3);
		Iterator iterator = collection.iterator();
		System.out.println("--------------------------------------");
		System.out.println ("The DVDs currently in the order are: ");
		
		while(iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc) iterator.next()).getTitle());
		}
		
		Collections.sort((List) collection, Media.COMPARE_BY_TITLE_COST);
		
		iterator = collection.iterator();
		
		System.out.println("--------------------------------------");
		System.out.println("The DVDs in sorted order are: ");
		
		while(iterator.hasNext()) {
			DigitalVideoDisc dvd = (DigitalVideoDisc) iterator.next();
			System.out.println(dvd.getTitle() + " " + dvd.getCost());
		}
		
		System.out.println("--------------------------------------");
	}

}
