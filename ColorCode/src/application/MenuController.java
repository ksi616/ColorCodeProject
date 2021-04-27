package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
	
    @FXML
    private Button learnButton;

    @FXML
    private Button quizButton;

    @FXML
    private Button listButton;
    
    
	@FXML
	void onLearn(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("Learn.fxml"));
		Stage window = (Stage) learnButton.getScene().getWindow();
		window.setScene(new Scene(menu, 900, 800));
	}
	
	@FXML
	void onList(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("List.fxml"));
		Stage window = (Stage) listButton.getScene().getWindow();
		window.setScene(new Scene(menu, 900, 800));
	}
	
	@FXML
	void onQuiz(ActionEvent event) throws IOException {
		Parent menu = FXMLLoader.load(getClass().getResource("Quiz.fxml"));
		Stage window = (Stage) quizButton.getScene().getWindow();
		window.setScene(new Scene(menu, 900, 800));
	}
}
