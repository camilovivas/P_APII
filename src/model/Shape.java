package model;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */

public class Shape {
	
	private Shape next;
	private Shape prior;
	private boolean used;	
	private int score;
	
	public Shape() {
		used = false;
		
	}
	
	
	public Shape getPrior() {
		return prior;
	}
	public void setPrior(Shape prior) {
		this.prior = prior;
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
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
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
	
	public int quantityFree() {
		int retorno = 0;
		if(next!=null) {
			if(next.isUsed()== false) {
				retorno += next.getScore();
				retorno += next.quantityFree();
			}
		}
		return retorno;
	}
	
	public int shapeFree() {
		int retorno = 0;
		if(next != null) {
			if(next.isUsed() == false) {
				retorno += (1+next.shapeFree());
			}
		}
		return retorno;
	}
	
}
