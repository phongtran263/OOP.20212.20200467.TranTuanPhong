package hust.soict.dsai.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class CartController {
	private Cart cart;
	private Store store;
	private boolean costIncrease = false;
	private boolean titleIncrease = true;
	
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private Label errorTypeLabel;
    
    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private TextField tfFilter;
    
    @FXML
    private ToggleGroup sortCategory;
    
    @FXML
    private RadioButton radioBtnSortCost;
    
    @FXML
    private RadioButton radioBtnSortTitle;
    
    @FXML
    private Button Sort;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	
    	if(cart.getItemsOrdered() != null) {
    		tblMedia.setItems(cart.getItemsOrdered());
    	}
    	
    	costLabel.setText(cart.totalCost(false) + " $");
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				updateButtonBar(newValue);
			}	
    	});
    	
    	tfFilter.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				changeWhenFilter(newValue);
			}
    	});
    	
    	filterCategory.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> changef, Toggle oldValue, Toggle newVlaue) {
				changeWhenFilter(tfFilter.getText());
			}
    	});
    }
    
    void updateButtonBar(Media media) {
    	if(media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if(media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else {
    			btnPlay.setVisible(false);
    		}
    	}
    }
    
    void showFilteredMedia(String s){
    	if(radioBtnFilterTitle.isSelected()) {
    		ObservableList<Media> result = cart.SearchByTitle(s);
    		if(result != null) {
    			tblMedia.setItems(result);
    		}
			errorTypeLabel.setText("");
    	}
    	else {
    		try {
    			errorTypeLabel.setText("");
    			int id = Integer.parseInt(s);
    			ObservableList<Media> result = FXCollections.observableArrayList(cart.Search(id));
    			if(result != null) {
    				tblMedia.setItems(result);
    			}
    		} catch(NumberFormatException e) {
    			errorTypeLabel.setText("PLEASE TYPE A NUMBER!");
    		}
    	}
    }
    
    void changeWhenFilter(String newValue) {
    	if(newValue.strip() != "") {
			showFilteredMedia(newValue);
		}
		else {
			errorTypeLabel.setText("");
	    	if(cart.getItemsOrdered() != null) {
	    		tblMedia.setItems(cart.getItemsOrdered());
	    	}
		}
    }
    
    @FXML
    void btnPlayPressed(ActionEvent event) {
    	try {
	    	Media media = tblMedia.getSelectionModel().getSelectedItem();
	    
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

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media  = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText(cart.totalCost(false) + " $");
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
    	try {
    		final String CART_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
    		fxmlLoader.setController(new ViewStoreController(store, cart));
    		Parent root = fxmlLoader.load();
    		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Store");
    		stage.show();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Place Order");
    	if(cart.getItemsOrdered().size() >= 5) {
    		alert.setHeaderText("Congratulation! A lucky item is in your cart.\nYou can get it for free.\n" + cart.getALuckyItem().toString());
    	}
    	else {
    		alert.setHeaderText(null);
    	}
    	alert.setContentText("Your order is created.\nTotal cost: " + cart.totalCost(true) + " $");
    	alert.showAndWait();
    }
    
    @FXML
    void btnSortPressed(ActionEvent event) {
    	if(radioBtnSortCost.isSelected()) {
	    	if(cart.getItemsOrdered() != null) {
	       		cart.CartSortByCostTitle(false, this.costIncrease);
	       		this.costIncrease = !this.costIncrease;
	    		tblMedia.setItems(cart.getItemsOrdered());
	    	}
    	}
    	else {
	    	if(cart.getItemsOrdered() != null) {
	       		cart.CartSortByTitleCost(false, this.titleIncrease);
	       		this.titleIncrease = !this.titleIncrease;
	    		tblMedia.setItems(cart.getItemsOrdered());
	    	}
    	}
    }
}
