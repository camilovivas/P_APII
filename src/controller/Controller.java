package controller;

import application.FilterScreen;
import application.GameScreen;
import application.MenuScreen;
import application.RankingScreen;
import application.RegisterUsersScreen;
import application.SelectLevelScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class Controller{
	
	

	private Stage primaryStage;
	private Scene scene;
	
	
	public Controller(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
	public  void goScreens(String screen) {
		switch (screen) {
		case "menu":
				MenuScreen menuScreen = new MenuScreen(primaryStage);
				scene = new Scene(menuScreen.getRoot());
			break;
		case "play":
			SelectLevelScreen gameLevelScreen = new SelectLevelScreen(primaryStage);
			scene = new Scene(gameLevelScreen.getRoot());
		break;
		
		case "ranking":
			RankingScreen rankingScreen = new RankingScreen(primaryStage);
			scene = new Scene(rankingScreen.getRoot());
		break;
		case "search":
			FilterScreen filterScreen = new FilterScreen(primaryStage);
			scene = new Scene(filterScreen.getRoot());
		break;
		
		case "registerUser":
			RegisterUsersScreen registerUserScreen = new RegisterUsersScreen(primaryStage);
			scene = new Scene(registerUserScreen.getRoot());
		break;
		
		case "game":
			GameScreen gameUserScreen = new GameScreen(primaryStage);
			scene = new Scene(gameUserScreen.getRoot());
		break;



		default:
			break;
		}
		scene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		primaryStage.setScene(scene);
	}
}
