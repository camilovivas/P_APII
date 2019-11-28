package application;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class Screen {
	protected VBox root;
	
	public Screen() {
		root = new VBox();
		root.setPrefSize(800,497);
		root.getStyleClass().add("mainPane");
		root.setAlignment(Pos.CENTER);
	}
	
	public abstract void drawHeader();
	
	public Pane getRoot() {
		return root;
	}

	public void setRoot(VBox root) {
		this.root = root;
	}
}
