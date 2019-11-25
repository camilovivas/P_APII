package model;

public class UserRegistered extends User {
	
	private String firstName;
	private String lastName;
	private int rankingUser;
	private Score historyScore;
	
	public UserRegistered(String firstName, String lastName ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRankingUser() {
		return rankingUser;
	}

	public void setRankingUser(int rankingUser) {
		this.rankingUser = rankingUser;
	}

	public Score getHistoryScore() {
		return historyScore;
	}

	public void setHistoryScore(Score historyScore) {
		this.historyScore = historyScore;
	}
	
	

}
