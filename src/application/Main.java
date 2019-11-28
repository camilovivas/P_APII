package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	private MenuScreen ms;
	

	@Override
	public void start(Stage stage) {

		MenuScreen menuScreen = new MenuScreen(stage);
		
		Scene scene = new Scene(menuScreen.getRoot());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Thread tOneMusic = new Thread(menuScreen,"threadMusic");
		tOneMusic.start();
		
		stage.setScene(scene);
		stage.setTitle("Geometrico");
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
