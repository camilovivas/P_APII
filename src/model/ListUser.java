package model;

import java.io.Serializable;

public class ListUser implements Serializable {
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

//	recursivo
	public int size() {
		int size = 0;
		if(firstUser != null) {
			size += (1+ firstUser.size());
		}
		return size;
	}
	
//	search binary semi
	public UserRegistered search(String name) {
		organizeByName();
		boolean ya = false;
		UserRegistered retorno = null;
		if(firstUser != null) {			
			int size = size();
			UserRegistered half  = halfNext((UserRegistered) firstUser, size);
			while(!ya) {			
				if(name.compareTo(half.getFirstName())==0) {
					retorno = half;
					ya = true;
				}
				else if(name.compareTo(half.getFirstName())<0){
					if(half.getPrior()!= null) {
						half =(UserRegistered) half.getPrior();					
					}
					else {
						ya=true;
					}
				}
				else {
					if(half.getNext()!= null) {
						
						half = (UserRegistered) half.getNext();
					}
					else {
						ya=true;
					}
				}
			}
		}
		return retorno;
	}
	
	public UserRegistered halfNext(UserRegistered half, int size) {
		int tam = size/2;
		int contador = 0;
		UserRegistered next = half;
		UserRegistered retorno = null;
		boolean ya = false;
		while(!ya) {
			if(contador == tam) {
				retorno = next;
				ya = true;
			}
			else {
				if(next.getNext() != null) {
					next = (UserRegistered) next.getNext();
					contador++;
				}
			}
		}
		return retorno;
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
	
//	ordenamiento insercion
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
