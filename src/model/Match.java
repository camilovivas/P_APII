package model;

import java.io.Serializable;
import java.util.Date;
/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */
public class Match implements Serializable{
//	RELATIONS
	private Board matchBoard;
	private User player1;
	private User player2;
	
//	LIST
	private Match next;
	private Match prior;
	
//	ATTRIBUTES
	private long dateTime;
	private Date time;
	
	public Match(User player1, User player2) {
		time= new Date();
		matchBoard = new Board();
		this.player1 = player1;
		this.player2 = player2;
		dateTime = time.getTime();
		time = new Date(dateTime);
	}
	
	
	public User getPlayer1() {
		return player1;
	}


	public void setPlayer1(User player1) {
		this.player1 = player1;
	}


	public User getPlayer2() {
		return player2;
	}


	public void setPlayer2(User player2) {
		this.player2 = player2;
	}


	public Date getTime() {
		return time;
	}


	public void setTime(Date time) {
		this.time = time;
	}


	public Match getNext() {
		return next;
	}


	public void setNext(Match next) {
		this.next = next;
	}


	public Match getPrior() {
		return prior;
	}


	public void setPrior(Match prior) {
		this.prior = prior;
	}


	public void conquerBox(int i, int j, Shape shape) {
		matchBoard.conquerBox(i, j, shape);
		if(player1.isTurn() == true) {
			player1.getBoxes().add(matchBoard.getBox()[i][j]);
			player1.setRankingUser(player1.calculateRanking());
			player1.setTurn(false);
			player2.setTurn(true);
		}
		else {
			player2.getBoxes().add(matchBoard.getBox()[i][j]);
			((UserRegistered) player2).setRankingUser(player2.calculateRanking());
			player2.setTurn(false);
			player1.setTurn(true);
		}
	}
	
	
	public int size() {
		int size = 0;
		if(next != null) {
			size +=(1+ next.size());
		}
		return size;
	}
	
//	recursivo
	public Match lastMatch() {
		Match retorno = null;
		if(next == null) {
			retorno = this;
		}
		else {
			retorno = next.lastMatch();
		}
		return retorno;
		
	}
	
	public void calculateScoreByPlayer(User s) {
		
	}
	
	
}
