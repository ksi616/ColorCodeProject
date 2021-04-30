package application;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import application.model.CCAppModel.*;

public class QuizController implements Initializable {
	// initializing values for quiz logic
	private static boolean redToggle, yellowToggle, blueToggle = false;	//color toggles to evaluate submitted answer
	private static Color[] colors = new Color[] { 						//array of colors to choose from randomly
			Color.ORANGE, Color.GREEN,
			Color.PURPLE, Color.SADDLEBROWN };
	private static Random rng = new Random();							//random value to choose from colors array
	private static Color rngColor;										//color chosen randomly
	private static String colorAnswer = null;							//answer from user
	
	@FXML
    private Button homeBtn;
	@FXML
	private static Button redBtn;
	@FXML
	private static Button yellowBtn;
	@FXML
	private static Button blueBtn;
	@FXML
	private Button submitBtn;
	@FXML
    private static Rectangle randomColor;

	public static boolean getRedToggle() 				{ return redToggle; }
	public static void setRedToggle(boolean toggle) 	{ redToggle = toggle; }
	public static boolean getYellowToggle() 			{ return yellowToggle; }
	public static void setYellowToggle(boolean toggle) 	{ yellowToggle = toggle; }
	public static boolean getBlueToggle() 				{ return blueToggle; }
	public static void setBlueToggle(boolean toggle)	{ blueToggle = toggle; }
	public static Color[] getColors() 					{ return colors; }
	public static Random getRng() 						{ return rng; }
	public static Color getRngColor() 					{ return rngColor; }
	public static void setRngColor(Color color) 		{ rngColor = color; }
	public static String getColorAnswer() 				{ return colorAnswer; }
	public static void setColorAnswer(String color) 	{ colorAnswer = color; }
	public static Button getRedBtn() 					{ return redBtn; }
	public static void setRedBtn(Button button) 		{ redBtn = button; }
	public static Button getYellowBtn() 				{ return yellowBtn; }
	public static void setYellowBtn(Button button) 		{ yellowBtn = button; }
	public static Button getBlueBtn() 					{ return blueBtn; }
	public static void setBlueBtn(Button button) 		{ blueBtn = button; }
	public static Rectangle getRandomColor() 			{ return randomColor; }
	public static void setRandomColor(Rectangle rec)	{ randomColor = rec; }
	
	@Override
	/*initialize method :
	*	Use rng to get random value from colors array and assign to rngColor.
	 	Fill randomColor with random color chosen to display to user.*/
	public void initialize(URL location, ResourceBundle resources) {
		//setRngColor(getColors()[getRng().nextInt(getColors().length)]);
		//getRandomColor().setFill(getRngColor());
		rngColor = colors[rng.nextInt(colors.length)];
		randomColor.setFill(rngColor);
	}
	
    @FXML
    /*onHome method:
     *	Return to home view.*/
    void onHome(ActionEvent event) throws IOException {
    	Parent needGive = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage window = (Stage) homeBtn.getScene().getWindow();
		window.setScene(new Scene(needGive, 900, 800));
    }
    
    /*redBtnToggle, yellowBtnToggle, and blueBtnToggle methods:
    *	Toggle buttons to set either redToggle, yellowToggle, or blueToggle values.
    *	Set redBtn, yellowBtn, or blueBtn to either original or darkened color to simulate button
    *	pressed based on toggle.
    *	Call evalColors method to evaluate which buttons are currently chosen.*/
    @FXML
    void redBtnToggle(ActionEvent event) {
    	CCAppModel.redBtnPressed(redToggle, yellowToggle, blueToggle, redBtn);
//    	redToggle = !redToggle;
//    	if(redToggle) redBtn.setStyle("-fx-background-color: darkred;");
//    	if(!redToggle) redBtn.setStyle("-fx-background-color: red;");
//    	evalColors(redToggle, yellowToggle, blueToggle);
    }
    @FXML
    void yellowBtnToggle(ActionEvent event) {
    	CCAppModel.yellowBtnPressed(redToggle, yellowToggle, blueToggle, redBtn);
//    	yellowToggle = !yellowToggle;
//    	if(yellowToggle) yellowBtn.setStyle("-fx-background-color: #CCCC00;");
//    	if(!yellowToggle) yellowBtn.setStyle("-fx-background-color: yellow;");
//    	evalColors(redToggle, yellowToggle, blueToggle);
    }
    @FXML
    void blueBtnToggle(ActionEvent event) {
    	CCAppModel.blueBtnPressed(redToggle, yellowToggle, blueToggle, redBtn);
//    	blueToggle = !blueToggle;
//    	if(blueToggle) blueBtn.setStyle("-fx-background-color: darkblue;");
//    	if(!blueToggle) blueBtn.setStyle("-fx-background-color: blue;");
//    	evalColors(redToggle, yellowToggle, blueToggle);
    }
    
    @FXML
    /*submit method:
     *	Prompt user based on values submitted.*/
    void submit(ActionEvent event) {
    	CCAppModel.submit(randomColor);
//    	// If no colors are chosen -
//    	if(colorAnswer == null) {
//    		Alert a = new Alert(AlertType.ERROR);
//    		a.setTitle("Oops");
//	    	a.setHeaderText("There is no color here! O.o");
//	    	a.setContentText("HEY! It looks like you haven't chosen any colors. Try and choose some! :)");
//	    	a.show();
//	    	return;
//    	}
//    	// If colors chosen are equal to random color generated -
//    	if(colorAnswer.contentEquals(rngColor.toString())) {
//    		Alert a = new Alert(AlertType.INFORMATION);
//    		Image smileImage = new Image(getClass().getResource("smile.png").toExternalForm());
//    		ImageView smileView = new ImageView(smileImage);
//    		
//    		a.setTitle("Good Job");
//	    	a.setHeaderText("AWESOME! :D");
//	    	a.setGraphic(smileView);
//	    	a.setContentText("Way to go! You sure know you're colors! Try and guess the next one!");
//	    	Optional<ButtonType> result = a.showAndWait();
//	    	
//	    	if(!result.isPresent() || result.get() == ButtonType.OK) {
//	    		resetValues();
//				rngColor = colors[rng.nextInt(colors.length)];
//				randomColor.setFill(rngColor);
//	    	}
//	    // If colors chosen are not equal to random generated color - 
//    	} else {
//    		String color = "";
//    		switch(rngColor.toString()) {
//    			case "0xffa500ff":
//    				color = "orange";
//    				break;
//    			case "0x008000ff":
//    				color = "green";
//    				break;
//    			case "0x800080ff":
//    				color = "purple";
//    				break;
//    			case "0x8b4513ff":
//    				color = "brown";
//    				break;
//    		}
//    		
//    		Alert a = new Alert(AlertType.ERROR);
//    		a.setTitle("No worries");
//	    	a.setHeaderText("Nice try.");
//	    	a.setContentText("These colors don't mix to "+color+". Try again!");
//	    	a.show();
//    	}
    }
    
    /*evalColors method:
     *	Evaluate colors chosen based buttons toggled and assign value to colorAnswer to return.*/
//    String evalColors(boolean red, boolean yellow, boolean blue) {
//    	if (red == true) {
//    		colorAnswer = "0xff0000ff";//Red
//			if(blue == true) {
//				colorAnswer = "0x800080ff";//Purple
//				if(yellow == true) {
//					colorAnswer = "0x8b4513ff";//Brown
//				}
//			} else if(yellow == true) {
//				colorAnswer = "0xffa500ff";//Orange
//			}
//		} else if (blue == true) {
//			colorAnswer = "0x0000ffff";//Blue
//			if (yellow == true) {
//				colorAnswer = "0x008000ff";//Green
//			}
//		} else if(yellow == true) {
//			colorAnswer = "0xffff00ff";//Yellow
//		} else {
//			colorAnswer = null;
//		}
//    	return colorAnswer;
//    }
    
    /*resetValues method:
     *	Reset button colors, color toggles, and colorAnswer to initial values.*/
    void resetValues() {
    	CCAppModel.resetValues(redBtn, yellowBtn, blueBtn, redToggle, yellowToggle, blueToggle, colorAnswer);
//    	redBtn.setStyle("-fx-background-color: red;");
//    	yellowBtn.setStyle("-fx-background-color: yellow;");
//    	blueBtn.setStyle("-fx-background-color: blue;");
//    	redToggle = false;
//    	yellowToggle = false;
//    	blueToggle = false;
//    	colorAnswer = null;
    }
}
