package application;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class ArrayBox {

	private Button box;
	private Pane wrapperBoxes;

	int xSize, ySize;
	private int posX, posY, sizeSquare;
	private Button[][] matrixButtons;

	public ArrayBox(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		wrapperBoxes = new Pane();
		sizeSquare = 50;
		matrixButtons = new Button[xSize][ySize];
		
		loadSquares();
		drawSquares();
	}

	public void loadSquares() {

		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				Button button = new Button();
				button.getStyleClass().add("btnBox");
				posX = (50 * j);
				posY = (50 * i);
				button.setPrefWidth(sizeSquare);
				button.setPrefHeight(sizeSquare);
				button.setTranslateX(posX);
				button.setTranslateY(posY);
				matrixButtons[i][j] = button;
			}
		}
	}

	public void drawSquares() {

		for (int i = 0; i < xSize; i++) {
			for (int j = 0; j < ySize; j++) {
				wrapperBoxes.getChildren().add(matrixButtons[i][j]);
			}
		}
	}

	public Pane getWrapperBoxes() {
		return wrapperBoxes;
	}

}
