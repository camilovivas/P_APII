package application;

import java.util.ArrayList;

import controller.RankingController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RankingScreen extends Screen{
	
	private HBox header,wrapperTitleRanking;
	private VBox body;
	private ArrayList<HBox> wrapperResult;
	
	private Image imgTitlePage,imgTitleGame,imgPosition,imgName,imgScore;
	private ImageView wImgTitlePage,wImgTitleGame,wImgPosition,wImgName,wImgScore;
	
	private Button btnBack;
	
	private RankingController rankingController;

	public RankingScreen(Stage stage) {
		header= new HBox();
		wrapperTitleRanking = new HBox(100);
		wrapperResult = new  ArrayList<HBox>();
		body = new VBox();
		
		btnBack = new Button();
		btnBack.setPrefSize(40, 40);
		btnBack.getStyleClass().add("backButton");
		btnBack.setTranslateX(-230);
		
		imgTitlePage = new Image("file:../../data/image/ranking.png",136, 65,false,false);
		imgTitleGame = new Image("file:../../data/image/titulo.png",134, 45,false,false);
		imgPosition = new Image("file:../../data/image/position.png",136, 65,false,false);
		imgName= new Image("file:../../data/image/user.png",136, 65,false,false);
		imgScore = new Image("file:../../data/image/score.png",136, 65,false,false);
		
		wImgTitlePage = new ImageView(imgTitlePage);
		wImgTitlePage.setTranslateX(-230);
		wImgTitleGame = new ImageView(imgTitleGame);
		wImgTitleGame.setTranslateX(230);
		wImgPosition = new ImageView(imgPosition);
		wImgName = new ImageView(imgName);
		wImgScore = new ImageView(imgScore);
		
		rankingController = new RankingController(stage);
		
		draw(); 
	}
	
	public void draw() {
		drawHeader();
		drawBody();
		goToMenu(); 
		
		root.getChildren().add(header);
		root.getChildren().add(body);
		root.setAlignment(Pos.TOP_CENTER);
	}

	public void drawHeader() {
		header.getChildren().add(btnBack);
		header.getChildren().add(wImgTitlePage);
		header.getChildren().add(wImgTitleGame);
		header.setAlignment(Pos.CENTER);
	}
	
	public void drawBody() {
		wrapperTitleRanking.getChildren().addAll(wImgPosition,wImgName,wImgScore);
		wrapperTitleRanking.setAlignment(Pos.CENTER);
		
		body.getChildren().add(wrapperTitleRanking);
		body.getChildren().addAll(wrapperResult);
	}
	
	public void goToMenu() {
		btnBack.setOnAction(e -> {
			System.out.println("Entro");
			rankingController.goScreens("menu");
		});	
	}
	


}
