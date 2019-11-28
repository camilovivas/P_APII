package controller;

import javafx.stage.Stage;
import model.Geometrico;
import model.User;
import model.UserAnonymous;


public class UserRegisterController extends Controller {

	private Geometrico model;
	private User user1;
	private User user2;

	
	public UserRegisterController(Stage primaryStage) {
		super(primaryStage);
		model = Geometrico.getSingletonInstance();
	}
	
	
	public void setLevel(int level) {
		model.setLevel(level);
	}
	
	public void search1(String name) {
		if(name == null) {
			user1 = new UserAnonymous();
		}
		else {
			user1= model.searchUser(name);
		}
		model.setPlayer1(user1);
	}
	
	public void search2(String name) {
		if(name == null) {
			user2 = new UserAnonymous();
		}
		else {
			user2= model.searchUser(name);
		}
		model.setPlayer2(user2);
		model.initMatch();
	}


}
