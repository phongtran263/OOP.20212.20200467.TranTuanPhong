package hust.soict.dsai.aims.media;

import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book("phong", Arrays.asList("p1,p2,p3,p4".split(",")), "dfsd d d d: sdfsd wef wds", "pp", 12);
		
		System.out.println(book.toString());
	}

}
