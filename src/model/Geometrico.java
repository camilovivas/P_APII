package model;

public class Geometrico {
//	RELATIONS
	private TreeRanking treeRanking;
	private ListUser listUser;
	private ListMatch listMatch;
	
	public Geometrico() {
		
	}
	
	public void addUser(UserRegistered u) {
		listUser.addUser(u);
	}
}
