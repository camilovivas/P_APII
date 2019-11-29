package application;

import java.io.File;

import controller.GameController;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class GameScreen extends Screen{
	
	private VBox wrapperPlayerOne,wrapperRectGame,wrapperPlayerTwo;
	private HBox header,body;

	private Image imgTitle;
	private ImageView  wrapperImgTitle;
	
	private PlayerDataGame dataPlayerOne,dataPlayerTwo;
	private ArrayBox arrayBox;
	
	private int sizeArrayBox;
	
	private GameController gameController;
	
	public GameScreen(Stage stage) { 
		header = new HBox();
		body  = new HBox();
		wrapperPlayerOne = new VBox();
		wrapperPlayerTwo = new VBox();
		wrapperRectGame = new VBox();
		imgTitle = new Image("file:../../data/image/titulo.png",136, 65,false,false);
		wrapperImgTitle = new ImageView(imgTitle);
		gameController = new GameController(stage);
		
		this.sizeArrayBox = gameController.getSizeArrayBox();
		
		dataPlayerOne = new PlayerDataGame(gameController.namePlayer1());
		dataPlayerOne.setScore(gameController.namePlayer1());
		dataPlayerTwo = new PlayerDataGame(gameController.namePlayer2());
		dataPlayerOne.setScore(gameController.namePlayer2());
		arrayBox = new ArrayBox(sizeArrayBox,sizeArrayBox);
		draw(); 
		
	}
	

	
	
	
	private void draw() {
		drawHeader();
		drawBody();
	}


	public void drawHeader() {
		header.getChildren().add(wrapperImgTitle);
		header.setAlignment(Pos.CENTER);
		header.setTranslateY(-150);
	}
	
	private int calculateTranslateX() {
		if(sizeArrayBox == 4) {
			return -80;
		}else if(sizeArrayBox == 5) {
			return -100;
		}
		
		return -120;
	}
	
	public void drawBody() {
		
		int marginArrayBox = calculateTranslateX();
	
		wrapperPlayerOne.getChildren().add(dataPlayerOne.getWrapperData());
		wrapperPlayerOne.setTranslateX(-180);
		
		wrapperRectGame.getChildren().add(arrayBox.getWrapperBoxes());
		wrapperRectGame.setTranslateX(marginArrayBox);
		
		wrapperPlayerTwo.getChildren().add(dataPlayerTwo.getWrapperData());
		wrapperPlayerTwo.setTranslateX(180);
		
		body.getChildren().add(wrapperPlayerOne);
		body.getChildren().add(wrapperRectGame);
		body.getChildren().add(wrapperPlayerTwo);
		body.setTranslateY(-100);
		
		body.setAlignment(Pos.CENTER);
		
		root.getChildren().add(header);
		root.getChildren().add(body);
	}
}
