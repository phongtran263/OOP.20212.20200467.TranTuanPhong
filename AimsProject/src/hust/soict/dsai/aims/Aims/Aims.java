package hust.soict.dsai.aims.Aims;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class Aims {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Store store = new Store();
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addDigitalVideoDisc(dvd1);
		store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addDigitalVideoDisc(dvd2);
		store.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addDVD(dvd3);
		
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
						int p = 0;
						DigitalVideoDisc dvd = null;
						while(p == 0) {
							System.out.println("Enter your disc's title");
							String optionDetail = scanner.nextLine();
							dvd = store.SearchByTitle(optionDetail);
							if(dvd!=null) {
								p = 1;
							}
							System.out.println("Do you want to try again?(y/n)");
							String pp = scanner.nextLine();
							if(pp.equals("n")) {
								p = 1;
							}
						}
						if(dvd!=null) {
							System.out.println("Do you want to add this disc to cart?(y/n)");
							String answer = scanner.nextLine();
							if(answer.equals("y")) {
								cart.addDigitalVideoDisc(dvd);
							}
						}
					}
					
					else if(optionStoreMenu == 2) {
						int p = 0;
						DigitalVideoDisc dvd = null;
						while(p == 0) {
							System.out.println("Enter your disc's title");
							String title = scanner.nextLine();
							dvd = store.SearchByTitle(title);
							if(dvd!=null) {
								p = 1;
							}
							System.out.println("Do you want to try again?(y/n)");
							String pp = scanner.nextLine();
							if(pp.equals("n")) {
								p = 1;
							}
						}
						if(dvd!=null) {
							cart.addDigitalVideoDisc(dvd);
						}
					}
					
					else if(optionStoreMenu == 3) {
						cart.print();
					}
					
					else if(optionStoreMenu == 0) {
						break;
					}		
				}
			}
			
			else if(optionShowMenu == 2) {
				while(true) {
					System.out.println("1. Add a DVD"); 
					System.out.println("2. Remove a DVD"); 
					System.out.println("0. Back"); 
					System.out.println("Please choose a number: 0-1-2"); 
					
					int optionUpdate = scanner.nextInt();
					scanner.nextLine();
					if(optionUpdate == 1) {
						int p = 0;
						DigitalVideoDisc dvd = null;
						while(p == 0) {
							System.out.println("Enter your disc's title");
							String optionDetail = scanner.nextLine();
							dvd = store.SearchByTitle(optionDetail);
							if(dvd!=null) {
								p = 1;
							}
							System.out.println("Do you want to try again?(y/n)");
							String pp = scanner.nextLine();
							if(pp.equals("n")) {
								p = 1;
							}
						}
						if(dvd!=null) {
							store.addDVD(dvd);
						}
					}
					
					else if(optionUpdate == 2) {
						int p = 0;
						DigitalVideoDisc dvd = null;
						while(p == 0) {
							System.out.println("Enter your disc's title");
							String optionDetail = scanner.nextLine();
							dvd = store.SearchByTitle(optionDetail);
							if(dvd!=null) {
								p = 1;
							}
							System.out.println("Do you want to try again?(y/n)");
							String pp = scanner.nextLine();
							if(pp.equals("n")) {
								p = 1;
							}
						}
						if(dvd!=null) {
							store.removeDVD(dvd);
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
							System.out.println("Please choose a number: 0-1-2-3"); 
							
							int option = scanner.nextInt();
							scanner.nextLine();
							if(option == 1) {
								System.out.println("enter id: ");
								int id = scanner.nextInt();
								cart.Search(id);
							}
							else if(option == 2) {
								System.out.println("enter title: ");
								String title = scanner.nextLine();
								DigitalVideoDisc[] result = cart.SearchByTitle(title);
							}
							else if(option == 0) {break;}
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
						int p = 0;
						cart.print();
						while(p == 0) {
							System.out.println("Enter id of DVD you want to remove:");
							int index = scanner.nextInt();
							scanner.nextLine();
							int b = cart.removeDigitalVideoDisc(index);
							if(b == 1){
								p = 1;
							}
							System.out.println("Do you want to continue?(y/n)");
							String pp = scanner.nextLine();
							if(pp.equals("n")) {
								p = 1;
							}
						}
					}
					
					else if(optionCartMenu == 4) {
						System.out.println("An order is created");
						cart.Empty();
					}
					
					else if(optionCartMenu == 0) {
						break;
					}
				}
			}
			
			else if(optionShowMenu == 0) {
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
		System.out.println("1. See a DVD’s details"); 
		System.out.println("2. Add a DVD to cart"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3");
	}
		
	public static void cartMenu() { 
		System.out.println("Options: ");
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter DVDs in cart"); 
		System.out.println("2. Sort DVDs in cart"); 
		System.out.println("3. Remove DVD from cart"); 
		System.out.println("4. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
}
