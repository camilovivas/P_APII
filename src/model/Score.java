package model;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */

public class Score {
	private Score right;
	private Score left;
	private int score;
	
	public Score(int score) {
		this.score = score;
	}
	
	public String inOrden() {
		String msj = "";
		if(left != null) {
			msj += left.inOrden();
		}
		msj += this.score+",";
		if(right != null) {
			msj += right.inOrden();
		}
		return msj;
	}
	
}
