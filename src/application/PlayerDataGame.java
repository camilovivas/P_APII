package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PlayerDataGame {
	
	private VBox wrapperData;
	private HBox wrapperName,wrapperScore;
	private Label timePlayer,score,namePlayer;
	
	public PlayerDataGame(String namePlayerS) {
		wrapperData = new VBox();
		
		wrapperName = new HBox();
		wrapperName.getStyleClass().add("wrapperTitlePlayer");
		wrapperName.setPrefSize(210, 42);
		
		wrapperScore = new HBox();
		wrapperScore.getStyleClass().add("wrapperScore");
		wrapperScore.setPrefSize(102, 44);
		
		timePlayer  = new Label("10:30");
		score  = new Label("");
		namePlayer  = new Label(namePlayerS);
		namePlayer.getStyleClass().add("namePlayer");
		
		
		draw();
	}
	
	public void draw() {
		namePlayer.setTranslateY(-7);
		wrapperName.getChildren().add(namePlayer);
		wrapperName.setAlignment(Pos.CENTER);
		
		wrapperData.getChildren().add(wrapperName);
		
		
		wrapperData.getChildren().add(timePlayer);
		
		wrapperScore.getChildren().add(score);
		wrapperData.getChildren().add(wrapperScore);
		wrapperData.setAlignment(Pos.CENTER);
	}

	public Label getTimePlayer() {
		return timePlayer;
	}

	public void setTimePlayer(String timePlayerS) {
		timePlayer.setText(timePlayerS);
	}

	public Label getScore() {
		return score;
	}

	public void setScore(String scoreS) {
		score.setText(scoreS);
	}

	public VBox getWrapperData() {
		return wrapperData;
	}
	

}
