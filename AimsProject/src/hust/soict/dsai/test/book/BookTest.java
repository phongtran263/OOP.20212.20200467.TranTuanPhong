package hust.soict.dsai.test.book;

import java.util.Arrays;

import hust.soict.dsai.aims.media.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book = new Book("phong", Arrays.asList("p1,p2,p3,p4".split(",")), "dfsd ghjjh.jygjh     ...... d d d sdfsd wef wds", "pp", 12);
		
		System.out.println(book.toString());
	}

}
