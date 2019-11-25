package model;

public class BenefitBox extends Box{
	
	private boolean opened;
	
	public BenefitBox(int posX, int posY) {
		super(posX, posY);
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	
	
}
