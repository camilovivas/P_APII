package model;

public class Board {
	public static int COLUMNA = 8;
	public static int FILA = 8;
	private Box[][] box;
	
	
	public Board(){
		box = new Box[COLUMNA][FILA];
	}
}
