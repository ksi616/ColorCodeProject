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

public class QuizController implements Initializable {
	boolean redToggle, yellowToggle, blueToggle = false;
	
	Color[] colors = new Color[] { Color.ORANGE, Color.GREEN, Color.PURPLE };
	Random rng = new Random();
	
	@FXML
    private Button homeBtn;
	@FXML
	private Button redBtn;
	@FXML
	private Button yellowBtn;
	@FXML
	private Button blueBtn;
	@FXML
    private Rectangle randomColor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//randomColor.setFill(Color.GREEN);
		randomColor.setFill(colors[rng.nextInt(colors.length)]);
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
    }
    @FXML
    void yellowBtnToggle(ActionEvent event) {
    	yellowToggle = !yellowToggle;
    	if(yellowToggle) yellowBtn.setStyle("-fx-background-color: #CCCC00;");
    	if(!yellowToggle) yellowBtn.setStyle("-fx-background-color: yellow;");
    }
    @FXML
    void blueBtnToggle(ActionEvent event) {
    	blueToggle = !blueToggle;
    	if(blueToggle) blueBtn.setStyle("-fx-background-color: darkblue;");
    	if(!blueToggle) blueBtn.setStyle("-fx-background-color: blue;");
    }
}
//Orange, Green, Violet.
