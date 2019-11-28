package application;

import controller.MenuController;
import controller.SelectLevelController;
import controller.UserRegisterController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterUsersScreen extends Screen {

	private VBox root, wrapperInputsA, wrapperInputsB;
	private HBox wrapperInputs,wrapperTitles,sideATitles;
	private TextField namePlayerOne, namePlayeTwo;
	private Label labelPlayerOne, labelPlayerTwo;
	private Button btnRegister,btnBack;
	private Image userTitle,title;
	private ImageView wrapperTitleUser,wrapperTitleH;
	private UserRegisterController userRegisterController;

	public RegisterUsersScreen(Stage stage) {
		root = new VBox();
		root.setPrefSize(800, 497);
		root.getStyleClass().add("mainPane");
		root.setAlignment(Pos.CENTER);
		
		btnBack = new Button();
		btnBack.setPrefSize(40, 40);
		btnBack.getStyleClass().add("backButton");
		
		sideATitles  = new HBox(30);
		sideATitles.setAlignment(Pos.TOP_CENTER);
		sideATitles.setTranslateX(-150);
		
		wrapperTitles = new HBox(40);
		wrapperTitles.setAlignment(Pos.TOP_CENTER);
		wrapperTitles.setTranslateX(-50);
		wrapperTitles.setTranslateY(-120);
		
		userTitle = new Image("file:../../data/image/usuarios.png",136, 65,false,false);
		wrapperTitleUser = new ImageView(userTitle);
		wrapperTitleUser.setTranslateX(-20);
		wrapperTitleUser.setTranslateY(-10);
		
		title = new Image("file:../../data/image/titulo.png",134, 45,false,false);
		wrapperTitleH = new ImageView(title);
		wrapperTitleH.setTranslateX(240);
		
		
		btnRegister = new Button("Continuar");
		btnRegister.setPrefSize(124,47);
		btnRegister.getStyleClass().add("btnYellow");
		btnRegister.setTranslateY(30);
		
		labelPlayerOne = new Label("Juagdor 1");
		labelPlayerTwo = new Label("Juagdor 2");

		namePlayerOne = new TextField();
		namePlayerOne.setPrefWidth(250);
		
		namePlayeTwo = new TextField();
		namePlayeTwo.setPrefWidth(250);
	
		wrapperInputsA = new VBox();
		wrapperInputsB = new VBox();
		
		wrapperInputs = new HBox(50);
		wrapperInputs.setAlignment(Pos.CENTER);
		
		userRegisterController = new UserRegisterController(stage);
		btnRegister.setOnAction(e->{
			userRegisterController.search1(namePlayerOne.getText());
			userRegisterController.search2(namePlayeTwo.getText());
		});
		
		drawHeader();
		draw();
		goToMenu();

	}

	private void draw() {
		drawBody();
	}
	
	private void drawHeader() {
		sideATitles.getChildren().add(btnBack);
		sideATitles.getChildren().add(wrapperTitleUser);
		sideATitles.getStyleClass().add("sideATitles");
		
		wrapperTitles.getChildren().add(sideATitles);
		wrapperTitles.getChildren().add(wrapperTitleH);
	}
	

	private void drawBody() {
		wrapperInputsA.getChildren().add(labelPlayerOne);
		wrapperInputsA.getChildren().add(namePlayerOne);

		wrapperInputsB.getChildren().add(labelPlayerTwo);
		wrapperInputsB.getChildren().add(namePlayeTwo);

		wrapperInputs.getChildren().add(wrapperInputsA);
		wrapperInputs.getChildren().add(wrapperInputsB);
		
		root.getChildren().add(wrapperTitles);
		root.getChildren().add(wrapperInputs);
		root.getChildren().add(btnRegister);
	}
	
	public void goToMenu() {
		btnBack.setOnAction(e -> {
			userRegisterController.goScreens("menu");
		});	
	}

	public Pane getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}

}
