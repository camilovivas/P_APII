package model;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS;

public class Geometrico {
//	RELATIONS
	private TreeRanking treeRanking;
	private ListUser listUser;
	private ListMatch listMatch;
	
	public Geometrico() {
		
	}
	
	public void addUserRegistered(UserRegistered u) {
		listUser.addUserRegistered(u);
	}
	
	public void addUserAnonimous(UserAnonymous u) {
		listUser.addUserAnonimos(u);
	}
}
