package model;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */

public class UserRegistered extends User {
	
	private String firstName;
	private Score historyScore;
	
	public UserRegistered(String firstName) {
		super();
		this.firstName = firstName;
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Score getHistoryScore() {
		return historyScore;
	}

	public void setHistoryScore(Score historyScore) {
		this.historyScore = historyScore;
	}
	
	public void setwinner() {
		addScore(getRankingUser());
		setRankingUser(0);
	}
	
//		recursivo
	public int bestScore() {
		String msj = "";
		if(historyScore != null) {
			msj += historyScore.inOrden();
		}
		String[] s = msj.split(",");
		int best = Integer.parseInt(s[s.length]);
		return best;
	}
	
//	recursivo
	public void addScore(int score) {
		Score s = new Score(score);
		if(historyScore == null) {
			historyScore = s;
		}
		else {
			historyScore.add(s);
		}
	}
	
	public String toString() {
		String msj = firstName+"su mejor puntaje"+bestScore();
		return msj;
		
	}
	
	

}
