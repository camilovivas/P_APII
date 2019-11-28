package model;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */

public class AsignableBox extends Box{
	
	private boolean conquered;
	private int score;
	private Shape shape;
	
	public AsignableBox(int posX, int posY) {
		super(posX, posY);
		conquered = false;
	}

	public boolean isConquered() {
		return conquered;
	}

	public void setConquered(boolean conquered) {
		this.conquered = conquered;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
		conquered = true;
		this.score = this.score+shape.getScore();
	}
	
	
	
	

}
