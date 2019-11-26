package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchTest {

	@Test
	public void conquerBoxtest() {
		UserAnonymous s1 = new UserAnonymous();
		s1.setTurn(true);
		UserRegistered s2 = new UserRegistered("andres", "v");
		Shape sh = new Shape();
		sh.setScore(10);
		Match m = new Match(s1, s2);
		m.conquerBox(0, 0, sh);
		
		assertEquals(20, s1.getRankingUser()); 
	}
	
	@Test
	public void conquerBoxtest2() {
		UserRegistered s1 = new UserRegistered("camilo", "v");
		s1.setTurn(true);
		UserRegistered s2 = new UserRegistered("andres", "v");
		Shape sh = new Shape();
		sh.setScore(10);
		Match m = new Match(s1, s2);
		m.conquerBox(0, 0, sh);
		
		assertEquals(20, s1.getRankingUser()); 
	}

}
