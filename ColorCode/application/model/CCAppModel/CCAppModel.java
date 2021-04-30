package application.model.CCAppModel;

import java.util.Optional;
import application.QuizController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CCAppModel {

	public static void redBtnPressed(boolean redToggle, boolean yellowToggle, boolean blueToggle, Button redBtn) {
    	QuizController.setRedToggle(!redToggle);
    	if(redToggle) {
    		redBtn.setStyle("-fx-background-color: darkred;");
    		QuizController.setRedBtn(redBtn);
    	}
    	if(!redToggle) {
    		redBtn.setStyle("-fx-background-color: red;");
    		QuizController.setRedBtn(redBtn);
    	}
    	evalColors(redToggle, yellowToggle, blueToggle);
	}
	
	public static void yellowBtnPressed(boolean redToggle, boolean yellowToggle, boolean blueToggle, Button yellowBtn) {
    	yellowToggle = !yellowToggle;
    	if(yellowToggle) yellowBtn.setStyle("-fx-background-color: darkred;");
    	if(!yellowToggle) yellowBtn.setStyle("-fx-background-color: red;");
    	evalColors(redToggle, yellowToggle, blueToggle);
	}
	
	public static void blueBtnPressed(boolean redToggle, boolean yellowToggle, boolean blueToggle, Button blueBtn) {
    	blueToggle = !blueToggle;
    	if(blueToggle) blueBtn.setStyle("-fx-background-color: darkred;");
    	if(!blueToggle) blueBtn.setStyle("-fx-background-color: red;");
    	evalColors(redToggle, yellowToggle, blueToggle);
	}
	
	public static void submit(Rectangle randomColor) {// If no colors are chosen -
    	if(QuizController.getColorAnswer() == null) {
    		Alert a = new Alert(AlertType.ERROR);
    		a.setTitle("Oops");
	    	a.setHeaderText("There is no color here! O.o");
	    	a.setContentText("HEY! It looks like you haven't chosen any colors. Try and choose some! :)");
	    	a.show();
	    	return;
    	}
    	// If colors chosen are equal to random color generated -
    	if(QuizController.getColorAnswer().contentEquals(QuizController.getRngColor().toString())) {
    		Alert a = new Alert(AlertType.INFORMATION);
    		Image smileImage = new Image("application/smile.png");
    		ImageView smileView = new ImageView(smileImage);
    		
    		a.setTitle("Good Job");
	    	a.setHeaderText("AWESOME! :D");
	    	a.setGraphic(smileView);
	    	a.setContentText("Way to go! You sure know you're colors! Try and guess the next one!");
	    	Optional<ButtonType> result = a.showAndWait();
	    	
	    	if(!result.isPresent() || result.get() == ButtonType.OK) {
	    		resetValues(QuizController.getRedBtn(), QuizController.getYellowBtn(), QuizController.getBlueBtn(), QuizController.getRedToggle(), QuizController.getYellowToggle(), QuizController.getBlueToggle(), QuizController.getColorAnswer());
				Color[] colors = QuizController.getColors();
	    		QuizController.setRngColor(colors[QuizController.getRng().nextInt(colors.length)]);
				randomColor.setFill(QuizController.getRngColor());
				QuizController.setRandomColor(randomColor);
	    	}
	    // If colors chosen are not equal to random generated color - 
    	} else {
    		String color = "";
    		switch(QuizController.getRngColor().toString()) {
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
	
	 /*evalColors method:
     *	Evaluate colors chosen based buttons toggled and assign value to colorAnswer to return.*/
	static String evalColors(boolean red, boolean yellow, boolean blue) {
    	if (red == true) {
    		QuizController.setColorAnswer("0xff0000ff");//Red
			if(blue == true) {
				QuizController.setColorAnswer("0x800080ff");//Purple
				if(yellow == true) {
					QuizController.setColorAnswer("0x8b4513ff");//Brown
				}
			} else if(yellow == true) {
				QuizController.setColorAnswer("0xffa500ff");//Orange
			}
		} else if (blue == true) {
			QuizController.setColorAnswer("0x0000ffff");//Blue
			if (yellow == true) {
				QuizController.setColorAnswer("0x008000ff");//Green
			}
		} else if(yellow == true) {
			QuizController.setColorAnswer("0xffff00ff");//Yellow
		} else {
			QuizController.setColorAnswer(null);
		}
    	return QuizController.getColorAnswer();
    }
	
	/*resetValues method:
     *	Reset button colors, color toggles, and colorAnswer to initial values.*/
    static public void resetValues(Button redBtn, Button yellowBtn, Button blueBtn, boolean redToggle, boolean yellowToggle, boolean blueToggle, String colorAnswer) {
    	redBtn.setStyle("-fx-background-color: red;");
    	yellowBtn.setStyle("-fx-background-color: yellow;");
    	blueBtn.setStyle("-fx-background-color: blue;");
    	redToggle = false;
    	yellowToggle = false;
    	blueToggle = false;
    	colorAnswer = null;
    	QuizController.setRedBtn(redBtn);
    	QuizController.setYellowBtn(yellowBtn);
    	QuizController.setBlueBtn(blueBtn);
    	QuizController.setRedToggle(redToggle);
    	QuizController.setYellowToggle(yellowToggle);
    	QuizController.setBlueToggle(blueToggle);
    }
}
