package controller;

import javafx.stage.Stage;
import model.Geometrico;

public class GameController extends Controller {

	private Geometrico model;
	
	public GameController(Stage primaryStage) {
		super(primaryStage);
		model = new Geometrico();
	}
	
	public int getSizeArrayBox() {
		switch (model.getLeveMatch()) {
		case 1:
			return 4;
		case 2:
			return 5;
		case 3:
			return 6;
		default:
			return 4;
		}
	}

}
