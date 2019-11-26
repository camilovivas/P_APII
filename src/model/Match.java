package model;

import java.io.Serializable;
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
	
	public Match(User player1, User player2) {
		matchBoard = new Board();
		this.player1 = player1;
		this.player2 = player2;
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
	
	public void calculateScoreByPlayer(User s) {
		
	}
	
	
}
