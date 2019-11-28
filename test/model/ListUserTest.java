package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListUserTest {

	@Test
	void test() {
		ListUser lu= new ListUser();
		UserRegistered s1 = new UserRegistered("c", "v");
		UserRegistered s2 = new UserRegistered("a", "v");
		UserRegistered s3 = new UserRegistered("b", "v");
		UserRegistered s4 = new UserRegistered("e", "v");
		UserRegistered s5 = new UserRegistered("d", "v");
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

}
