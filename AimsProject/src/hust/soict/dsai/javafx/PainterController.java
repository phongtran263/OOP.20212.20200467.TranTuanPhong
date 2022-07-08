package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {
	private Color color = Color.BLACK;
	private int sizeCircle = 4;

    @FXML
    private ToggleGroup Identical;
	
	@FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	drawingAreaPane.setClip(new Rectangle(544, 464));
    	Circle newCircle = new Circle(event.getX(), event.getY(), this.sizeCircle, this.color);
    	drawingAreaPane.getChildren().add(newCircle);
    }


    @FXML
    void eraserChosen(ActionEvent event) {
    	this.color = color.WHITE;
    	this.sizeCircle = 10;
    }

    @FXML
    void penChosen(ActionEvent event) {
    	this.color = color.BLACK;
    	this.sizeCircle = 4;
    }
}
