package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private CheckBox orange;

    @FXML
    private CheckBox green;

    @FXML
    private CheckBox purple;
    
    @FXML
    private Button add;
    
    int pattern = (red.isSelected() ? 0b0001 : 0)
    			| (blue.isSelected() ? 0b0010 : 0)
    			| (yellow.isSelected() ? 0b0100 : 0);
    @FXML
    void createColor(ActionEvent event) {
    	switch (pattern) {
    	case 0b0011:
    		
    		break;
    		
    	case 0b0101:
    		
    		break;
    		
    	case 0b0110:
    		
    		break;
    	}
    	
    }

    @FXML
    void onHome(ActionEvent event) throws IOException {
    	Parent needGive = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage window = (Stage) home.getScene().getWindow();
		window.setScene(new Scene(needGive, 900, 800));
    }
}
