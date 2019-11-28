package controller;
import application.FilterScreen;
import application.MenuScreen;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Geometrico;


public class FilterController extends Controller {

	private String option;
	private Stage primaryStage;
	private Scene scene;
	private Geometrico model;
	
	public FilterController(Stage primaryStage) {
		super(primaryStage);
	}

	public void setOption(String option, String text) {
		this.option = option;
		if(option.compareTo("Usuarios")==0) {
			model.foundUser(text);
		}
		else {
			model.searchMatch(text);
		}
	}
	
	
	
}
