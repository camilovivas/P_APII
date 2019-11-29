package controller;

import org.hamcrest.core.IsInstanceOf;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import javafx.stage.Stage;
import model.Geometrico;
import model.UserRegistered;

public class GameController extends Controller {

	private Geometrico model;
	
	public GameController(Stage primaryStage) {
		super(primaryStage);
		model = Geometrico.getSingletonInstance();
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
	
	public String namePlayer1() {
		String ret = "";
		try {			
			ret +=((UserRegistered) model.getMatch().getPlayer1()).getFirstName();
			
		}
		catch (Exception e) {
			ret += "UserAnonymous";
		}
		return ret;
	}
	
	public String namePlayer2() {
		String ret = null;
//		try {			
			ret = ((UserRegistered) model.getMatch().getPlayer2()).getFirstName();
			System.out.println(ret);
//		}
//		catch (Exception e) {
//			ret += "UserAnonymous";
//		}
		return ret;
	}
	
	public int scoreplayer1() {
		return model.getMatch().getPlayer1().getRankingUser();
	}

	public int scoreplayer2() {
		return model.getMatch().getPlayer2().getRankingUser();
	}

}
