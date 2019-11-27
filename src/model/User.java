package model;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */
public class User implements Serializable{
	
//	LISTA DOBLE
	private User prior;
	private User next;
	
//	RELACIONES
	private Shape firstShape; 
	private ArrayList<Box> boxes;
	
//	ATTRIBUTES
	private boolean turn;
	private int rankingUser;
	
	public User() {
		boxes = new ArrayList<>();
		turn = true;

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

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(ArrayList<Box> boxes) {
		this.boxes = boxes;
	}
	
	public int getRankingUser() {
		return rankingUser;
	}

	public void setRankingUser(int rankingUser) {
		this.rankingUser = rankingUser;
	}

	public int calculateRanking() {
		int ranking = 0;
		for (int i = 0; i < boxes.size(); i++) {
			ranking += ((AsignableBox) boxes.get(i)).getScore();
		}
		return ranking;
	}
	
	
}
