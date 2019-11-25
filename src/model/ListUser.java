package model;

public class ListUser {
	private User firstUser;
	
	public ListUser() {
		
	}
	
	public void addUser(UserRegistered u) {
		 UserRegistered next = (UserRegistered) firstUser;
		 if(next == null) {
			 firstUser = u;
		 }
		 else {
			 firstUser = u;
			 u.setNext(next);
			 next.setPrior(u);
		 }
	}
}
