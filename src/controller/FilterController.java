package controller;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Geometrico;


public class FilterController extends Controller {

	private String option;
	private Stage primaryStage;
	private Scene scene;
	private Geometrico model;
	private String result;
	
	public FilterController(Stage primaryStage) {
		super(primaryStage);
		model = Geometrico.getSingletonInstance();
		result = "";
	}

//	me trae los resultados pero no se donde ponerlo en la Screen
	public void setOption(String option, String text) {
		this.option = option;
		if(option.compareTo("Usuarios")==0) {
			result += model.foundUser(text);
		}
		else {
			result += model.searchMatch(text);
		}
	}
	
	
	
}
