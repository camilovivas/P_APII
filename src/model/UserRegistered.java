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
	
	public String toString() {
		String msj = firstName+"su mejor puntaje"+bestScore();
		return msj;
		
	}
	
	

}
