package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListUserTest {

	@Test
	void addTest() {
		ListUser lu= new ListUser();
		UserRegistered s1 = new UserRegistered("c");
		UserRegistered s2 = new UserRegistered("a");
		UserRegistered s3 = new UserRegistered("b");
		UserRegistered s4 = new UserRegistered("e");
		UserRegistered s5 = new UserRegistered("d");
		lu.addUserRegistered(s1);
		lu.addUserRegistered(s2);
		lu.addUserRegistered(s3);
		lu.addUserRegistered(s4);
		lu.addUserRegistered(s5);
		lu.organizeByName();
		String actual = "";
		UserRegistered next = (UserRegistered) lu.getFirstUser();
		while(next != null) {
			actual += next.getFirstName();
			next = (UserRegistered) next.getNext();
		}
		assertEquals("abcde", actual);
	}
	
	@Test
	void SearchUser() {
		ListUser lu= new ListUser();
		UserRegistered s1 = new UserRegistered("c");
		UserRegistered s2 = new UserRegistered("a");
		UserRegistered s3 = new UserRegistered("b");
		UserRegistered s4 = new UserRegistered("e");
		UserRegistered s5 = new UserRegistered("d");
		lu.addUserRegistered(s1);
		lu.addUserRegistered(s2);
		lu.addUserRegistered(s3);
		lu.addUserRegistered(s4);
		lu.addUserRegistered(s5);
		lu.organizeByName();
		UserRegistered actual = lu.search("a");
		assertEquals("a", actual.getFirstName());
	}
}
