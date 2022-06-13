package hust.soict.dsai.test.polymorphism;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class PolymorphismTest {

	public static void main(String[] args) {
		List<Media> mediae = new ArrayList<Media>();
		
		CompactDisc cd = new CompactDisc("p", "p", "p", new ArrayList<Track>(), 10);
		Track tr1 = new Track("p1", 1);
		Track tr2 = new Track("p2", 9);
		Track tr3 = new Track("p3", 1);
		cd.addTrack(tr1);
		cd.addTrack(tr2);
		cd.addTrack(tr3);
		
		DigitalVideoDisc dvd = new DigitalVideoDisc("Avengers", "Movie", "phong", 1, 1);
		Book book = new Book("phong", new ArrayList<String>(), "this is a test class!!!", "book", 99);
		book.addAuthor("person1");
		book.addAuthor("person2");
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for(Media m: mediae) {
			System.out.println(m.toString());
		}
	}

}
