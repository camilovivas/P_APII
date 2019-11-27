package controller;
import application.FilterScreen;
import application.MenuScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FilterController extends Controller {

	private MenuScreen menuScreen;
	private Stage primaryStage;
	
	public FilterController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void goScreenMenu() {
		
		menuScreen = new MenuScreen(primaryStage);
		
		Scene scene = new Scene(menuScreen.getRoot());
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}
}
