package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Starts the program
 * @author Jeevan Vasanthan, Noah Young
 *
 */
public class Main extends Application {
	
	/**
	 * sets up initial primary stage
	 * @param primaryStage stage that will be set up
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainView.fxml"));
			Scene scene = new Scene(root,700,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * launches the program
	 * @param args arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
