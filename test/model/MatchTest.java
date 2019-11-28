package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatchTest {

	@Test
	public void conquerBoxtest() {
		UserAnonymous s1 = new UserAnonymous();
		s1.setTurn(true);
		UserRegistered s2 = new UserRegistered("andres");
		Shape sh = new Shape();
		sh.setScore(10);
		Match m = new Match(s1, s2,1);
		m.conquerBox(0, 0, sh);
		
		assertEquals(20, s1.getRankingUser()); 
	}
	
	@Test
	public void conquerBoxtest2() {
		UserRegistered s1 = new UserRegistered("camilo");
		s1.setTurn(true);
		UserRegistered s2 = new UserRegistered("andres");
		Shape sh = new Shape();
		sh.setScore(10);
		Match m = new Match(s1, s2,1);
		m.conquerBox(0, 0, sh);
		
		assertEquals(20, s1.getRankingUser()); 
	}
	
	@Test
	void lastMatch() {
		UserRegistered s1 = new UserRegistered("camilo");
		UserRegistered s2 = new UserRegistered("andres");
		UserRegistered im = new UserRegistered("funciona");
		im.setRankingUser(30);
		Match m1 = new Match(s1, s2,1);
		Match m2 = new Match(s1, s2,1);
		Match m3 = new Match(im, s2,1);
		m1.setNext(m2);
		m2.setNext(m3);
		m3.setPrior(m2);
		m3.setNext(null);
		Match actual = m1.lastMatch();
		assertEquals(30, actual.getPlayer1().getRankingUser());
	}

}
