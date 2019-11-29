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
	
	
	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

	
	public Score getRight() {
		return right;
	}


	public void setRight(Score right) {
		this.right = right;
	}


	public Score getLeft() {
		return left;
	}


	public void setLeft(Score left) {
		this.left = left;
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
	
	public void add(Score s) {
		if(s.getScore() < this.score) {
			if(left == null) {
				setLeft(s);
			}else {
				left.add(s);
			}
		}else if(s.getScore() > this.score) {
			if(right==null) {
				setRight(s);
			}else {
				right.add(s);
			}
		}else {
			if(left == null) {
				setLeft(s);
			}else {
				left.add(s);
			}
		}
	}
	
}
