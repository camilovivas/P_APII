package model;

public class ListUser {
	private User firstUser;
	private User lastUser1;
	
	private User firstUser2;
	
	public ListUser() {
		
	}
	
	
	
	public User getFirstUser() {
		return firstUser;
	}



	public void setFirstUser(User firstUser) {
		this.firstUser = firstUser;
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
	
	public void organizeByName() {
		if(firstUser != null){
			UserRegistered u = (UserRegistered) firstUser;
			while(u.getNext() != null) {
				UserRegistered inserted = (UserRegistered) u.getNext();
				if(u.getFirstName().compareTo(inserted.getFirstName())>0) {
					if(((UserRegistered) firstUser).getFirstName().compareTo(inserted.getFirstName())>0) {
						UserRegistered sig = (UserRegistered) inserted.getNext();
						firstUser.setPrior(inserted);
						inserted.setNext(firstUser);
						u.setNext(sig);
						if(sig !=null) {
							sig.setPrior(u);
						}
						firstUser = inserted;
						firstUser.setPrior(null);
					}
					else {
						UserRegistered search = (UserRegistered) firstUser;
						boolean modi = false;
						while(search.getNext() != null && !modi) {
							if(((UserRegistered) search.getNext()).getFirstName().compareTo(inserted.getFirstName())>0) {
								User sigui = inserted.getNext();
								User aux = search.getNext();
								search.setNext(inserted);
								inserted.setPrior(search);
								aux.setPrior(inserted);
								inserted.setNext(aux);
								u.setNext(sigui);
								if(sigui != null) {
									sigui.setPrior(u);
								}
								modi = true;
							}
							else {
								search = (UserRegistered) search.getNext();
							}
					}
				}
			}
			else {
				u = (UserRegistered) u.getNext();
			}
		}
		lastUser1 = u;
	}
	}
	
	
}
