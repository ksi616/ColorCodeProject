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
    				if(yellow.isSelected()) {
    					color.setText("Brown");
    				}
    			}
    			else if(yellow.isSelected()) {
    				color.setText("Orange");
    			}
    			else {
    				color.setText("Red");
    			}
    		
    		}
    		else if (blue.isSelected()) {
    			if (yellow.isSelected()) {
    				color.setText("Green");
    			}
    			else {
    				color.setText("Blue");
    			}
    		}
    		else if(yellow.isSelected()) {
    			color.setText("Yellow");
    		}
    		/*if (red.isSelected() & blue.isSelected()) {
	    		color.setText("Purple");
    		}
    		else if (red.isSelected() & yellow.isSelected()) {	
	    		color.setText("Orange");
	    	}
	    		
	    	else if (blue.isSelected() & yellow.isSelected()) {
	    		color.setText("Green");
	    	}*/
	    	else {
	    		color.setText("No Color Selected");
	    	}
    	} 

    @FXML
    void onHome(ActionEvent event) throws IOException {
    	Parent needGive = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage window = (Stage) home.getScene().getWindow();
		window.setScene(new Scene(needGive, 900, 800));
    }
}
