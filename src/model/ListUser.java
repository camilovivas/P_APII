package model;

public class ListUser {
	private User firstUser;
	private User firstUser2;
	
	public ListUser() {
		
	}
	
	public void addUserRegistered(UserRegistered u) {
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
	
	public void addUserAnonimos(UserAnonymous u) {
		 UserAnonymous next = (UserAnonymous) firstUser2;
		 if(next == null) {
			 firstUser2 = u;
		 }
		 else {
			 firstUser2 = u;
			 u.setNext(next);
			 next.setPrior(u);
		 }
	}
}
