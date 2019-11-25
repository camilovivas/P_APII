package model;

public abstract class Box {
	private int posX;
	private int posY;
	
	public Box(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
