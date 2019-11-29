package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	private String dateTime;
	private Date time;
	private int level;
	
	public Match(User player1, User player2,int level) {
		time= new Date();
		matchBoard = new Board(level);
		this.level = level;
		this.player1 = player1;
		this.player2 = player2;
		dateTime = time.getDate()+"/"+(time.getMonth()+1)+"/"+2019;
		time = parse(dateTime);
	}
	
	public Date parse(String date) {
		Date datefind = null;
		try {
			SimpleDateFormat change = new SimpleDateFormat("dd/MM/yyyy");
			datefind = change.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datefind;
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
			cases(player1, player1);
			player1.setTurn(false);
			player2.setTurn(true);
		}
		else {
			player2.getBoxes().add(matchBoard.getBox()[i][j]);
			player2.setRankingUser(player2.calculateRanking());
			cases(player1, player1);
			player2.setTurn(false);
			player1.setTurn(true);
		}
	}
	
//	recursivo
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
	
	public void cases(User s, User s2) {
		int shapesFree1 = s.shapeFree();
		int shapesFree2 = s2.shapeFree();
		if(level == 1) {
			if(shapesFree1 <= 2|| shapesFree2 <=2){
				win(s,s2);
			}
		}
		if(level == 2) {
			if(shapesFree1 <= 3|| shapesFree2 <=3){
				win(s,s2);
			}
		}
		if(level == 3) {
			if(shapesFree1 <= 4|| shapesFree2 <=4){
				win(s,s2);
			}
		}
	}
	
	public void win(User s, User s2) {
		int boxFree = matchBoard.quantityFree();
		int shapefreeS1 = s.quantityShapesFree();
		int shapefreeS2 = s2.quantityShapesFree();
		
		int sum1 = boxFree+shapefreeS1;
		int sum2 = boxFree+shapefreeS2;
		if(sum1 > sum2) {
			s.setWin(true);
			try {
			((UserRegistered)s).setwinner();
			}
			catch (ClassCastException e) {
				
			}
		}
		else {
			s2.setWin(true);
			try {
				((UserRegistered)s2).setwinner();
			}
			catch (ClassCastException e) {
				
			}
		}
	}
	
	
	
	public String toString() {
		String ret = "Score player 1:"+player1.getRankingUser()+"  --  Score player 2:"+player2.getRankingUser()+"\n";
		return ret;
	}
	
	
}
