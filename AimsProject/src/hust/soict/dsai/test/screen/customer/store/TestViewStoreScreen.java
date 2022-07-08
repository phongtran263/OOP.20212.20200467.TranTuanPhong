package hust.soict.dsai.test.screen.customer.store;

import java.util.ArrayList;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.ExistException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Cart cart;
	
	public static void main(String[] args) throws LimitExceededException, ExistException {
		store = new Store();
		cart = new Cart();
		
		DigitalVideoDisc media1 = new DigitalVideoDisc("the Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media1);
//		cart.addMedia(media1);
		
		DigitalVideoDisc media2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media2);
//		cart.addMedia(media2);
		
		DigitalVideoDisc media10 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(media10);
//		cart.addMedia(media10);
		
		DigitalVideoDisc media11 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 114.95f);
		store.addMedia(media11);
		cart.addMedia(media11);
		
		DigitalVideoDisc media12 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 124.95f);
		store.addMedia(media12);
		cart.addMedia(media12);
		
		DigitalVideoDisc media13 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 134.95f);
		store.addMedia(media13);
		cart.addMedia(media13);
		
		DigitalVideoDisc media14 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 144.95f);
		store.addMedia(media14);
		cart.addMedia(media14);
		
		DigitalVideoDisc media15 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 154.95f);
		store.addMedia(media15);
		cart.addMedia(media15);
		
		DigitalVideoDisc media16 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 164.95f);
		store.addMedia(media16);
		cart.addMedia(media16);
		
		DigitalVideoDisc media17 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 174.95f);
		store.addMedia(media17);
		cart.addMedia(media17);
		
		DigitalVideoDisc media3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(media3);
		cart.addMedia(media3);
		
		DigitalVideoDisc media4 = new DigitalVideoDisc("lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media4);
		cart.addMedia(media4);

		DigitalVideoDisc media5 = new DigitalVideoDisc("Te King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media5);
		cart.addMedia(media5);

		DigitalVideoDisc media6 = new DigitalVideoDisc("The Kng", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media6);
		cart.addMedia(media6);

		DigitalVideoDisc media7 = new DigitalVideoDisc("The Kig", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media7);
		cart.addMedia(media7);

		DigitalVideoDisc media8 = new DigitalVideoDisc("he King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media8);
		cart.addMedia(media8);

		DigitalVideoDisc media9 = new DigitalVideoDisc("The Ki", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(media9);
		cart.addMedia(media9);

		CompactDisc cd = new CompactDisc("p", "p", "p", new ArrayList<Track>(), 10);
		Track tr1 = new Track("p1", 1);
		Track tr2 = new Track("p2", 9);
		Track tr3 = new Track("p3", -1);
		cd.addTrack(tr1);
		cd.addTrack(tr2);
		cd.addTrack(tr3);
		store.addMedia(cd);
		cart.addMedia(cd);

		Book book = new Book("phong", new ArrayList<String>(), "this is a test class!!!", "book", 99);
		book.addAuthor("person1");
		book.addAuthor("person2");
		store.addMedia(book);
		cart.addMedia(book);

		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store, cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}
