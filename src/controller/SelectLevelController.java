package controller;

import javafx.stage.Stage;
import model.Geometrico;


public class SelectLevelController extends Controller {

	private Geometrico model;

	
	public SelectLevelController(Stage primaryStage) {
		super(primaryStage);
		model = Geometrico.getSingletonInstance();
	}
	
	
	public void setLevel(int level) {
		model.setLevel(level);
	}

}

