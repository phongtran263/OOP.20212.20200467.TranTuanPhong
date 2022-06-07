package hust.soict.dsai.aims.Aims;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.MemoryDaemon;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store.Store;

public class Aims {

	public static void main(String[] args) {

//		MemoryDaemon daemon = new MemoryDaemon();
//		daemon.run();
		
//		Thread thread = new Thread(new MemoryDaemon());
//		thread.setDaemon(true);
//		thread.start();
		
		Scanner scanner = new Scanner(System.in);
		Store store = new Store();
		Cart cart = new Cart();
		
		DigitalVideoDisc media1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media1);
		cart.addMedia(media1);
		
		DigitalVideoDisc media2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media2);
		cart.addMedia(media2);
		
		DigitalVideoDisc media3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(media3);
		cart.addMedia(media3);
		
		DigitalVideoDisc media4 = new DigitalVideoDisc("Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media4);
		cart.addMedia(media4);

		DigitalVideoDisc media5 = new DigitalVideoDisc("The King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media5);
		cart.addMedia(media5);

		System.out.println("Hello!!! Welcome to AIMS.");
		while(true) {
			showMenu();
			int optionShowMenu = scanner.nextInt();
			scanner.nextLine();
			if(optionShowMenu == 1) {
				while(true) {
					storeMenu();
					int optionStoreMenu = scanner.nextInt();
					scanner.nextLine();
					if(optionStoreMenu == 1) {
						Media media = null;
						while(true) {
							System.out.println("Please enter your media title:");
							String optionDetail = scanner.nextLine();
							media = store.SearchByTitle(optionDetail);
							if(media!=null) {
								System.out.println("Would you like to add this media to your cart?(y/n)");
								String answer = scanner.nextLine();
								if(answer.equals("y")) {
									cart.addMedia(media);
								}
							}
							System.out.println("Would you like to see another one?(y/n)");
							String searchAgain = scanner.nextLine();
							if(searchAgain.equals("n")) {
								break;
							}
						}
					}
					
					else if(optionStoreMenu == 2) {
						Media media = null;
						while(true) {
							System.out.println("Please enter your media title:");
							String title = scanner.nextLine();
							media = store.SearchByTitle(title);
							if(media!=null) {
								cart.addMedia(media);
							}
							System.out.println("Would you like to add another one to your cart?(y/n)");
							String addMore = scanner.nextLine();
							if(addMore.equals("n")) {
								break;
							}
						}
					}
					
					else if(optionStoreMenu == 3) {
						cart.print(false);
					}
					
					else if(optionStoreMenu == 0) {
						break;
					}		
				}
			}
			
			else if(optionShowMenu == 2) {
				while(true) {
					System.out.println("1. Add a media"); 
					System.out.println("2. Remove a media"); 
					System.out.println("0. Back"); 
					System.out.println("Please choose a number: 0-1-2"); 
					
					int optionUpdate = scanner.nextInt();
					scanner.nextLine();
					if(optionUpdate == 1) {
						while(true) {
							System.out.println("1. Add a disc"); 
							System.out.println("2. Add a book"); 
							System.out.println("0. Back"); 
							System.out.println("Please choose a number: 0-1-2"); 
							
							int optionAdd = scanner.nextInt();
							scanner.nextLine();
							if(optionAdd == 1) {
								System.out.println("1. Add a CD"); 
								System.out.println("2. Add a DVD"); 
								System.out.println("0. Back"); 
								System.out.println("Please choose a number: 1-2-0"); 
								
								int optionDisc = scanner.nextInt();
								scanner.nextLine();
								if(optionDisc == 1) {
									System.out.println("Please enter your CD's title:");
									String titleCD = scanner.nextLine();
									System.out.println("Please enter your CD's category:");
									String category = scanner.nextLine();
									System.out.println("Please enter your CD's artist:");
									String artist = scanner.nextLine();
									System.out.println("Please enter your CD's cost:");
									float cost = scanner.nextFloat();
									scanner.nextLine();									

									System.out.println("Please enter number of tracks of your CD:");
									int num = scanner.nextInt();
									scanner.nextLine();
									ArrayList<Track> tracks = new ArrayList<Track>();
									for(int i = 0; i < num; i++) {
										System.out.println("Please enter your track's title:");
										String title = scanner.nextLine();
										System.out.println("Please enter your track's length:");
										int length = scanner.nextInt();
										scanner.nextLine();
										tracks.add(new Track(title, length));
									}
									CompactDisc CD = new CompactDisc(titleCD, category, artist, tracks, cost);
									System.out.println(CD.toString());
									store.addMedia(CD);
								}
								
								else if(optionDisc == 2) {
									System.out.println("1. Add title"); 
									System.out.println("2. Add title, category, cost"); 
									System.out.println("3. Add title, category, director, cost"); 
									System.out.println("4. Add title, category, director, length, cost"); 
									System.out.println("0. Back"); 
									System.out.println("Please choose a number: 1-2-3-4-0"); 
									int optionDVD = scanner.nextInt();
									scanner.nextLine();
									
									if(optionDVD == 1) {
										System.out.println("Please enter your dvd's title:");
										String title = scanner.nextLine();
										DigitalVideoDisc DVD = new DigitalVideoDisc(title);
										System.out.println(DVD.toString());
										store.addMedia(DVD);
									}
									
									else if(optionDVD == 2) {
										System.out.println("Please enter your dvd's title:");
										String title = scanner.nextLine();
										System.out.println("Please enter your dvd's category:");
										String category = scanner.nextLine();
										System.out.println("Please enter your dvd's cost:");
										float cost = scanner.nextFloat();
										scanner.nextLine();										
										DigitalVideoDisc DVD = new DigitalVideoDisc(title, category, cost);
										System.out.println(DVD.toString());
										store.addMedia(DVD);
									}
									
									else if(optionDVD == 3) {
										System.out.println("Please enter your dvd's title:");
										String title = scanner.nextLine();
										System.out.println("Please enter your dvd's category:");
										String category = scanner.nextLine();
										System.out.println("Please enter your dvd's director:");
										String director = scanner.nextLine();
										System.out.println("Please enter your dvd's cost:");
										float cost = scanner.nextFloat();
										scanner.nextLine();
										DigitalVideoDisc DVD = new DigitalVideoDisc(title, category, director, cost);
										System.out.println(DVD.toString());
										store.addMedia(DVD);
									}

									else if(optionDVD == 4) {
										System.out.println("Please enter your dvd's title:");
										String title = scanner.nextLine();
										System.out.println("Please enter your dvd's category:");
										String category = scanner.nextLine();
										System.out.println("Please enter your dvd's director:");
										String director = scanner.nextLine();
										System.out.println("Please enter your dvd's length:");
										int length = scanner.nextInt();
										System.out.println("Please enter your dvd's cost:");
										float cost = scanner.nextFloat();
										scanner.nextLine();
										DigitalVideoDisc DVD = new DigitalVideoDisc(title, category, director, length, cost);
										System.out.println(DVD.toString());
										store.addMedia(DVD);
									}

									else if(optionDVD == 0) {}
								}
								else if(optionDisc == 0) {}
							}
							
							else if(optionAdd == 2) {
								System.out.println("1. Add title, authors"); 
								System.out.println("2. Add title, authors, catagory, cost"); 
								System.out.println("0. Back"); 
								System.out.println("Please choose a number: 1-2-0"); 
								
								int optionArg = scanner.nextInt();
								scanner.nextLine();
								if(optionArg == 1) {
									System.out.println("Please enter your book's title:");
									String title = scanner.nextLine();
									System.out.println("Please enter your book's authors:");
									String authors = scanner.nextLine();
									List<String> Authors = (List<String>)Arrays.asList(authors.split(","));
									Book book = new Book(title, Authors);
									System.out.println(book.toString());
									store.addMedia(book);
								}
								
								else if(optionArg == 2) {
									System.out.println("Please enter your book's title:");
									String title = scanner.nextLine();
									System.out.println("Please enter your book's category:");
									String category = scanner.nextLine();
									System.out.println("Please enter your book's cost:");
									float cost = scanner.nextFloat();
									scanner.nextLine();
									System.out.println("Please enter your book's authors:");
									String authors = scanner.nextLine();
									List<String> Authors = (List<String>)Arrays.asList(authors.split(","));
									Book book = new Book(title, Authors, category, cost);
									System.out.println(book.toString());
									store.addMedia(book);									
								}
								else if(optionArg == 0) {}
							}
							else if(optionAdd == 0) {break;}
							System.out.println("Would you like to add another one to store?(y/n)");
							String addMore = scanner.nextLine();
							if(addMore.equals("n")) {
								break;
							}
						}
					}
					
					else if(optionUpdate == 2) {
						Media media = null;
						while(true) {
							System.out.println("Please enter your media title:");
							String optionDetail = scanner.nextLine();
							media = store.SearchByTitle(optionDetail);
							if(media!=null) {
								store.removeMedia(media);
							}
							System.out.println("Would you like to remove another one from store?(y/n)");
							String removeMore = scanner.nextLine();
							if(removeMore.equals("n")) {
								break;
							}
						}
					}
					
					else if(optionUpdate == 0) {
						break;
					}
				}
			}
			
			else if(optionShowMenu == 3) {
				while(true) {
					cartMenu();
					int optionCartMenu = scanner.nextInt();
					scanner.nextLine();
					if(optionCartMenu == 1) {
						while(true) {
							System.out.println("1. By id");
							System.out.println("2. By title");
							System.out.println("0. Back");
							System.out.println("Please choose a number: 0-1-2"); 
							
							int optionFilter = scanner.nextInt();
							scanner.nextLine();
							if(optionFilter == 1) {
								while(true) {
									System.out.println("Please enter your media id:");
									int id = scanner.nextInt();
									scanner.nextLine();
									cart.Search(id);
									System.out.println("Would you like to filter again?(y/n)");
									String filterAgain = scanner.nextLine();
									if(filterAgain.equals("n")) {
										break;
									}
								}
							}
							else if(optionFilter == 2) {
								while(true) {
									System.out.println("Please enter your media title:");
									String title = scanner.nextLine();
									ArrayList<Media> result = cart.SearchByTitle(title);
									System.out.println("Would you like to filter again?(y/n)");
									String filterAgain = scanner.nextLine();
									if(filterAgain.equals("n")) {
										break;
									}
								}
							}
							else if(optionFilter == 0) {break;}
						}
					}
					
					else if(optionCartMenu == 2) {
						while(true) {
							System.out.println("1. By title");
							System.out.println("2. By cost");
							System.out.println("0. Back");
							System.out.println("Please choose a number: 0-1-2"); 
							
							int option = scanner.nextInt();
							scanner.nextLine();
							if(option == 1) {
								cart.print("title");
							}
							else if(option == 2) {
								cart.print("cost");
							}
							else if(option == 0) {
								break;
							}
						}
					}
					
					else if(optionCartMenu == 3) {
						while(true) {
							cart.print(false);
							System.out.println("Please enter your media index:");
							int index = scanner.nextInt();
							scanner.nextLine();
							int b = cart.removeMedia(index - 1);
							System.out.println("Would you like to remove another one from your cart?(y/n)");
							String removeMore = scanner.nextLine();
							if(removeMore.equals("n")) {
								break;
							}
						}
					}
					
					else if(optionCartMenu == 4) {
						cart.print(true);
						System.out.println("An order is created.");
						cart.Empty();
					}
					
					else if(optionCartMenu == 0) {
						break;
					}
				}
			}
			
			else if(optionShowMenu == 0) {
				System.out.println("Goodbye!!! See you next time.");
	            System.exit(0);
			}
		}
		
	}

	public static void showMenu() { 
		System.out.println("AIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3"); 
	}
	
	public static void storeMenu() { 
		System.out.println("Options: ");
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media’s details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3");
	}
		
	public static void cartMenu() { 
		System.out.println("Options: ");
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove a media from cart"); 
		System.out.println("4. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
}
