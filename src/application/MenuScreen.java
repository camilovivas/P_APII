package application;

import controller.MenuController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuScreen extends Screen{
	private GameScreen gs;
	private MenuController menuController;
	private VBox root;
	
	private VBox menuPane;
	
	private Button btnPlay,btnIns,btnRanking;
	private Image title;
	private ImageView  wrapperTitle;
	
	public MenuScreen(Stage stage) {
		root = new VBox();
		root.setPrefSize(800,497);
		root.getStyleClass().add("mainPane");
		
		title = new Image("file:../../data/image/titulo.png");
		wrapperTitle = new ImageView(title);
		
		
		btnPlay = new Button("Jugar!");
		btnPlay.setPrefSize(124,47);
		btnPlay.getStyleClass().add("btnYellow");
		btnPlay.setTranslateY(50);
	
		
		btnRanking = new Button("Historia");
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
	}
	
	private void drawBody() {
		menuPane.getChildren().add(btnPlay);
		menuPane.getChildren().add(btnRanking);
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
			
		});
	}
	
	public void goToInInstructions() {
		btnIns.setOnAction(e -> {

		});
	}
	
	public void goToRanking() {
		btnRanking.setOnAction(e -> {
			menuController.goScreenRanking();
		});
	}
	
}
