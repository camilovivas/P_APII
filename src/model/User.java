package model;

import java.util.ArrayList;

public class User {
	
//	LISTA DOBLE
	private User prior;
	private User next;
	
//	RELACIONES
	private Shape firstShape; 
	private ArrayList<Box> boxes;
	
	public User() {

	}

	public User getPrior() {
		return prior;
	}

	public void setPrior(User prior) {
		this.prior = prior;
	}

	public User getNext() {
		return next;
	}

	public void setNext(User next) {
		this.next = next;
	}
	
	
	
}
