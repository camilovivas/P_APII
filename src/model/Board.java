package model;

public class Board {
	public static int COLUMNA = 8;
	public static int FILA = 8;
	private Box[][] box;
	
	
	public Board(){
		box =  new AsignableBox[COLUMNA][FILA];
		createMatriz();
	}
	
	
	
	public AsignableBox[][] getBox() {
		return (AsignableBox[][]) box;
	}



	public void setBox(AsignableBox[][] box) {
		this.box =  box;
	}



	public void createMatriz() {
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if(box[i][j] == null) {
					box[i][j] = new AsignableBox(i,j);
				}
			}
		}
	}
}
