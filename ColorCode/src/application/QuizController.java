package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class QuizController implements Initializable {
	boolean redToggle, yellowToggle, blueToggle = false;
	Color[] colors = new Color[] { Color.ORANGE, Color.GREEN, Color.PURPLE, Color.SADDLEBROWN };
	Random rng = new Random();
	Color rngColor;
	String colorAnswer = null;
	
	@FXML
    private Button homeBtn;
	@FXML
	private Button redBtn;
	@FXML
	private Button yellowBtn;
	@FXML
	private Button blueBtn;
	@FXML
	private Button submitBtn;
	@FXML
    private Rectangle randomColor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rngColor = colors[rng.nextInt(colors.length)];
		randomColor.setFill(rngColor);
	}
	
    @FXML
    void onHome(ActionEvent event) throws IOException {
    	Parent needGive = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage window = (Stage) homeBtn.getScene().getWindow();
		window.setScene(new Scene(needGive, 900, 800));
    }
    
    @FXML
    void redBtnToggle(ActionEvent event) {
    	redToggle = !redToggle;
    	if(redToggle) redBtn.setStyle("-fx-background-color: darkred;");
    	if(!redToggle) redBtn.setStyle("-fx-background-color: red;");
    	evalColors(redToggle, yellowToggle, blueToggle);
    }
    @FXML
    void yellowBtnToggle(ActionEvent event) {
    	yellowToggle = !yellowToggle;
    	if(yellowToggle) yellowBtn.setStyle("-fx-background-color: #CCCC00;");
    	if(!yellowToggle) yellowBtn.setStyle("-fx-background-color: yellow;");
    	evalColors(redToggle, yellowToggle, blueToggle);
    }
    @FXML
    void blueBtnToggle(ActionEvent event) {
    	blueToggle = !blueToggle;
    	if(blueToggle) blueBtn.setStyle("-fx-background-color: darkblue;");
    	if(!blueToggle) blueBtn.setStyle("-fx-background-color: blue;");
    	evalColors(redToggle, yellowToggle, blueToggle);
    }
    
    @FXML
    void submit(ActionEvent event) {
    	if(colorAnswer == null) {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setTitle("Oops");
	    	a.setHeaderText("There is no color here! O.o");
	    	a.setContentText("HEY! It looks like you haven't chosen any colors. Try and choose some! :)");
	    	a.show();
	    	return;
    	}
    	
    	if(colorAnswer.contentEquals(rngColor.toString())) {
    		Alert a = new Alert(AlertType.INFORMATION);
    		Image smileImage = new Image(getClass().getResource("smile.png").toExternalForm());
    		ImageView smileView = new ImageView(smileImage);
    		
    		a.setTitle("Good Job");
	    	a.setHeaderText("AWESOME! :D");
	    	a.setGraphic(smileView);
	    	a.setContentText("Way to go! You sure know you're colors! Try and guess the next one!");
	    	Optional<ButtonType> result = a.showAndWait();
	    	
	    	if(!result.isPresent() || result.get() == ButtonType.OK) {
	    		resetValues();
				rngColor = colors[rng.nextInt(colors.length)];
				randomColor.setFill(rngColor);
	    	}
    	} else {
    		String color = "";
    		switch(rngColor.toString()) {
    			case "0xffa500ff":
    				color = "orange";
    				break;
    			case "0x008000ff":
    				color = "green";
    				break;
    			case "0x800080ff":
    				color = "purple";
    				break;
    			case "0x8b4513ff":
    				color = "brown";
    				break;
    		}
    		
    		Alert a = new Alert(AlertType.ERROR);
    		a.setTitle("No worries");
	    	a.setHeaderText("Nice try.");
	    	a.setContentText("These colors don't mix to "+color+". Try again!");
	    	a.show();
    	}
    }
    
    String evalColors(boolean red, boolean yellow, boolean blue) {
    	if (red == true) {
    		colorAnswer = "0xff0000ff";//Red
			if(blue == true) {
				colorAnswer = "0x800080ff";//Purple
				if(yellow == true) {
					colorAnswer = "0x8b4513ff";//Brown
				}
			} else if(yellow == true) {
				colorAnswer = "0xffa500ff";//Orange
			}
		} else if (blue == true) {
			colorAnswer = "0x0000ffff";//Blue
			if (yellow == true) {
				colorAnswer = "0x008000ff";//Green
			}
		} else if(yellow == true) {
			colorAnswer = "0xffff00ff";//Yellow
		} else {
			colorAnswer = null;
		}
    	return colorAnswer;
    }
    
    void resetValues() {
    	redBtn.setStyle("-fx-background-color: red;");
    	yellowBtn.setStyle("-fx-background-color: yellow;");
    	blueBtn.setStyle("-fx-background-color: blue;");
    	redToggle = false;
    	yellowToggle = false;
    	blueToggle = false;
    	colorAnswer = null;
    }
}
