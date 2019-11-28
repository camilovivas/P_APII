package application;

import controller.MenuController;
import controller.SelectLevelController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectLevelScreen extends Screen{
	private GameScreen gs;
	private MenuController menuController;
	private VBox root;
	
	private VBox menuPane;
	
	private Button btnEasy,btnInter,btnPro;
	private Image title;
	private ImageView  wrapperTitle;
	
	private SelectLevelController selectLevelController;
	
	public SelectLevelScreen(Stage stage) {
		root = new VBox();
		root.setPrefSize(800,497);
		root.getStyleClass().add("mainPane");
		
		title = new Image("file:../../data/image/titulo.png");
		wrapperTitle = new ImageView(title);
		
		
		btnEasy = new Button("Fácil");
		btnEasy.setPrefSize(124,47);
		btnEasy.getStyleClass().add("btnYellow");
		btnEasy.setTranslateY(40);
	
		btnInter = new Button("Intermedio");
		btnInter.setPrefSize(124,47);
		btnInter.getStyleClass().add("btnGreen");
		btnInter.setTranslateY(40);
		
		btnPro = new Button("Profesional");
		btnPro.setPrefSize(124,47);
		btnPro.getStyleClass().add("btnBlue");
		btnPro.setTranslateY(40);
		
		menuPane = new VBox(10);
		menuPane.setPrefSize(339,349);
		menuPane.setTranslateY(10);
		menuPane.getStyleClass().add("nivelPane");
		
		selectLevelController = new SelectLevelController(stage);
		
		draw();
	}
	
	private void draw() {
		drawBody();
		selectLevelGame();
	}
	
	private void drawBody() {
		menuPane.getChildren().add(btnEasy);
		menuPane.getChildren().add(btnInter);
		menuPane.getChildren().add(btnPro);
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
	
	public void selectLevelGame() {
		btnEasy.setOnAction(e -> {
			selectLevelController.setLevel(1);
			selectLevelController.goScreens("registerUser");
			
		});
		
		btnInter.setOnAction(e -> {
			selectLevelController.setLevel(2);
			selectLevelController.goScreens("registerUser");

		});
		
		btnPro.setOnAction(e -> {
			selectLevelController.setLevel(3);
			selectLevelController.goScreens("registerUser");
		});
	}
}
