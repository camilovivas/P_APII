package application;



import controller.FilterController;
import exception.ExceptionNoGameDate;
import exception.ExceptionPlayerNotFound;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FilterScreen extends Screen {
	private InstructionScreen isc;
	private Pane wrapperMain;
	private VBox header;
	private HBox wrapperTitles,wrapperMenuSearch,sideATitles,sideAMenu;
	private ComboBox  listView;
	private Button btnSearch,btnBack;
	private Image title,historyTitle;
	private ImageView  wrapperTitleH,wrapperTitleHistory;
	private TextField inputSearch;
	private FilterController filterController;

	
	public FilterScreen(Stage stage) {
		wrapperTitles = new HBox(50);
		wrapperTitles.setAlignment(Pos.CENTER);
		
		sideATitles = new HBox(10);
		sideATitles.setAlignment(Pos.CENTER_LEFT);
		sideATitles.setTranslateX(-190);
		
		btnBack = new Button();
		btnBack.setPrefSize(40, 40);
		btnBack.getStyleClass().add("backButton");
		
		historyTitle = new Image("file:../../data/image/historia.png",136, 65,false,false);
		wrapperTitleHistory = new ImageView(historyTitle);
		
		title = new Image("file:../../data/image/titulo.png",134, 45,false,false);
		wrapperTitleH = new ImageView(title);
		wrapperTitleH.setTranslateX(200);
		//-------------------------------
		wrapperMenuSearch = new HBox(20);
		wrapperMenuSearch.setAlignment(Pos.CENTER);
		//-------------------------------
		header = new VBox(10);
		//-------------------------------
		sideAMenu = new HBox(10);
		sideAMenu.setAlignment(Pos.CENTER_LEFT);
		sideAMenu.setTranslateX(-10);
		
		inputSearch = new TextField();
		inputSearch.setPrefWidth(380);
		
		listView = new ComboBox<String>();
		listView.setPrefWidth(200);
		listView.getItems().addAll(
	            "Usuarios",
	            "Partidas"
	        );
		
		btnSearch = new Button("Buscar");
		btnSearch.setPrefSize(124,47);
		btnSearch.getStyleClass().add("btnYellow");
		btnSearch.setTranslateX(15);
		//-------------------------------
		wrapperMain = new Pane();
		//-------------------------------
		filterController = new FilterController(stage);
		//-------------------------------
		draw();
		
	}
	
	private void draw() {
		drawBody();
	}
	
	private void drawBody() {
		root.setAlignment(Pos.TOP_CENTER);
		drawHeader();
		drawMenu();
		drawMain();
		goToMenu();
		search();
		
	}
	
	private void drawMain() {
		sideATitles.getChildren().add(btnBack);
		sideATitles.getChildren().add(wrapperTitleHistory);
		sideATitles.getStyleClass().add("sideATitles");
		wrapperMenuSearch.getChildren().add(sideAMenu);
		wrapperMenuSearch.getChildren().add(btnSearch);
	}
	
	public void drawHeader() {
		root.getChildren().add(header);
	}
	
	private void drawMenu() {
		wrapperTitles.getChildren().add(sideATitles);
		wrapperTitles.getChildren().add(wrapperTitleH);
		header.getChildren().add(wrapperTitles);
		header.getChildren().add(wrapperMenuSearch);
		sideAMenu.getChildren().add(listView);
		sideAMenu.getChildren().add(inputSearch);
	}
	
	public void goToMenu() {
		btnBack.setOnAction(e -> {
			System.out.println("Entro");
			filterController.goScreens("menu");
		});	
	}
	
	public void search() {
		btnSearch.setOnAction(e->{
			try {
				filterController.setOption((String) listView.getValue(), inputSearch.getText());
			} catch (ExceptionPlayerNotFound e1) {
				e1.printStackTrace();
			} catch (ExceptionNoGameDate e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}

	public Pane getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}

	
}
