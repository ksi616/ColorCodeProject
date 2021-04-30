//Creates List scene
package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ListController {
	
    @FXML
    private Button home;

    @FXML
    void onHome(ActionEvent event) throws IOException {
    	Parent needGive = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Stage window = (Stage) home.getScene().getWindow();
		window.setScene(new Scene(needGive, 900, 800));
    }
}
