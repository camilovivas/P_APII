package model;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */

public class Shape {
	
	private Shape next;
	private Shape prior;
	
	public Shape getPrior() {
		return prior;
	}
	public void setPrior(Shape prior) {
		this.prior = prior;
	}
	private int score;
	public Shape() {

	}
	public Shape getNext() {
		return next;
	}
	public void setNext(Shape next) {
		this.next = next;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void shapeAdd(Shape s) {
		boolean added = false;
		if(next == null && !added) {
			setNext(s);
			s.setPrior(this);
			added = true;
		}else {
			next.shapeAdd(s);
		}
	}
	
}
