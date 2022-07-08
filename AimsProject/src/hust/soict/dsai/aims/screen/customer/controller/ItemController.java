package hust.soict.dsai.aims.screen.customer.controller;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.ExistException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	private Media media;
	private Cart cart;
	
	public ItemController(Cart cart) {
		this.cart = cart;
	}
	
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event){
    	try {
			cart.addMedia(media);
		} catch (LimitExceededException e) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("ERROR");
	    	alert.setHeaderText(null);
	    	alert.setContentText("The cart is almost full");
	    	alert.showAndWait();
		} catch (ExistException e) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("ERROR");
	    	alert.setHeaderText(null);
	    	alert.setContentText("This media has been already in the cart");
	    	alert.showAndWait();
		}
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
    	try {
	    	Alert alert = new Alert(AlertType.INFORMATION);
	    	alert.setTitle("Play Media");
	    	alert.setHeaderText(null);
	    	alert.setContentText(((Playable) media).playString());
	    	alert.showAndWait();
    	} catch(PlayerException e) {
	    	Alert alert = new Alert(AlertType.ERROR);
	    	alert.setTitle("Illegal length");
	    	alert.setHeaderText(null);
	    	alert.setContentText(e.getMessage());
	    	alert.showAndWait();
    	}
    }

    public void setData(Media media) {
    	this.media = media;
    	lblTitle.setText(media.getTitle());
    	lblCost.setText(media.getCost() + " $");
    	if(media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else {
    		btnPlay.setVisible(false);
    		HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 108));
    	}
    }
}
