package application;

import java.io.File;

import controller.MenuController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MenuScreen extends Screen implements Runnable{
	private GameScreen gs;
	private MenuController menuController;
	
	private VBox menuPane;
	
	private Button btnPlay,btnIns,btnSearch,btnRanking;
	private Image title;
	private ImageView  wrapperTitle;
	
	public MenuScreen(Stage stage) {
		title = new Image("file:../../data/image/titulo.png");
		wrapperTitle = new ImageView(title);
		
		btnPlay = new Button("Jugar!");
		btnPlay.setPrefSize(124,47);
		btnPlay.getStyleClass().add("btnYellow");
		btnPlay.setTranslateY(50);
		
		btnSearch = new Button("Buscar");
		btnSearch.setPrefSize(124,47);
		btnSearch.getStyleClass().add("btnYellow");
		btnSearch.setTranslateY(50);
		
		btnRanking = new Button("Ranking");
		btnRanking.setPrefSize(124,47);
		btnRanking.getStyleClass().add("btnBlue");
		btnRanking.setTranslateY(50);
		
		btnIns = new Button("Instrucciones");
		btnIns.setPrefSize(124,47);
		btnIns.getStyleClass().add("btnGreen");
		btnIns.setTranslateY(50);
		
		menuPane = new VBox(10);
		menuPane.setPrefSize(339,349);
		menuPane.getStyleClass().add("menuPane");
		
		menuController = new MenuController(stage);
		
		draw();
	}
	
	private void draw() {
		drawBody();
		goToGame();
		goToInInstructions();
		goToRanking();
		goToSearch();
	}
	
	private void drawBody() {
		menuPane.getChildren().add(btnPlay);
		menuPane.getChildren().add(btnRanking);
		menuPane.getChildren().add(btnSearch);
		menuPane.getChildren().add(btnIns);
		menuPane.setAlignment(Pos.CENTER);
		//---------------------------------
		root.getChildren().add(wrapperTitle);
		root.getChildren().add(menuPane);
		root.setAlignment(Pos.CENTER);
	}

	public Pane getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}
	
	public void goToGame() {
		btnPlay.setOnAction(e -> {
			menuController.goScreens("play");
		});
	}
	
	public void goToInInstructions() {
		btnIns.setOnAction(e -> {
			menuController.goScreens("instruction");
		});
	}
	
	public void goToRanking() {
		btnRanking.setOnAction(e -> {
			menuController.goScreens("ranking");
		});
	}
	
	public void goToSearch() {
		btnSearch.setOnAction(e -> {
			menuController.goScreens("search");
		});
	}

	@Override
	public void drawHeader() {
		// TODO Auto-generated method stub
		
	}
	
	private void sound() {
		String musicFile = "data/sound/kahoot.mp3";     // For example
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}
	

	@Override
	public void run() {
		sound();
		
	}
	
}
