package controller;
import application.FilterScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuController extends Controller {

	private FilterScreen filterScreen;
	private Stage primaryStage;
	
	public MenuController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void goScreenRanking() {
		
		filterScreen = new FilterScreen(primaryStage);
		
		Scene scene = new Scene(filterScreen.getRoot());
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}
}
