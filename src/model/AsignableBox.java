package model;

public class AsignableBox extends Box{
	private boolean conquered;
	private int score;
	private Shape shape;
	
	public AsignableBox(int posX, int posY) {
		super(posX, posY);
		conquered = false;
		setScore();
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

	public void setScore() {
		if(this.getPosX() == 1 || this.getPosX() == Board.FILA-2){
			
			if(this.getPosY() < Board.COLUMNA -1 && this.getPosY() >0) {
				this.score = 15;
			
			}
			else {
				this.score = 10;
			}
		}
		else if((this.getPosY() == 1 &&(this.getPosX()> 0 && this.getPosX() < Board.FILA-1)) || (this.getPosY() == Board.FILA-2 &&(this.getPosX()> 0 && this.getPosX() < Board.FILA-1))) {
			this.score = 15;
		}
		else {
			this.score = 10;
		}
		
		
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
