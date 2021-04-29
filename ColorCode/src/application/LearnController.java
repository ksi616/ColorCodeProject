package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LearnController {
	
    @FXML
    private Button home;

    @FXML
    private CheckBox red;

    @FXML
    private CheckBox blue;

    @FXML
    private CheckBox yellow;
    
    @FXML
    private Label color;

    
    @FXML
    void createColor(ActionEvent event) {
    		if (red.isSelected()) {
    			if(blue.isSelected()) {
    				color.setText("Purple");
    				color.setTextFill(Color.PURPLE);
    				if(yellow.isSelected()) {
    					color.setText("Brown");
    					color.setTextFill(Color.BROWN);
    				}
    			}
    			else if(yellow.isSelected()) {
    				color.setText("Orange");
    				color.setTextFill(Color.ORANGE);
    			}
    			else {
    				color.setText("Red");
    				color.setTextFill(Color.RED);
    			}
    		
    		}
    		else if (blue.isSelected()) {
    			if (yellow.isSelected()) {
    				color.setText("Green");
    				color.setTextFill(Color.GREEN);
    			}
    			else {
    				color.setText("Blue");
    				color.setTextFill(Color.BLUE);
    			}
    		}
    		else if(yellow.isSelected()) {
    			color.setText("Yellow");
    			color.setTextFill(Color.YELLOW);
    		}
	    	else {
	    		color.setText("No Color Selected");
	    		color.setTextFill(Color.BLACK);
	    	}
    	} 

    @FXML
    void onHome(ActionEvent event) throws IOException {
    	Parent needGive = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage window = (Stage) home.getScene().getWindow();
		window.setScene(new Scene(needGive, 900, 800));
    }
}
