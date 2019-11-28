package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListMatchTest {

	@Test
	void addMatchTest() {
		ListMatch lm = new ListMatch();
		UserRegistered s1 = new UserRegistered("c", "v");
		UserRegistered s2 = new UserRegistered("a", "v");
		Match m = new Match(s1, s2,1);
		UserRegistered s3 = new UserRegistered("m", "v");
		s3.setRankingUser(20);
		UserRegistered s4 = new UserRegistered("n", "v");
		Match m2 = new Match(s3, s4,1);
		lm.addMatch(m);
		lm.addMatch(m2);
		assertEquals(20, m.getNext().getPlayer1().getRankingUser());
		
	}
	
	@Test
	void siseTest() {
		ListMatch lm = new ListMatch();
		UserRegistered s1 = new UserRegistered("c", "v");
		UserRegistered s2 = new UserRegistered("a", "v");
		Match m = new Match(s1, s2,1);
		UserRegistered s3 = new UserRegistered("m", "v");
		s3.setRankingUser(20);
		UserRegistered s4 = new UserRegistered("n", "v");
		Match m2 = new Match(s3, s4,1);
		lm.addMatch(m);
		lm.addMatch(m2);
		int actual = lm.size();
		assertEquals(2, actual);
	}
	
	@Test
	void halfNext() {
		ListMatch lm = new ListMatch();
		UserRegistered s1 = new UserRegistered("c", "v");
		UserRegistered s2 = new UserRegistered("a", "v");
		UserRegistered im = new UserRegistered("a", "v");
		im.setRankingUser(40);
		Match m = new Match(s1, s2,1);
		Match m1 = new Match(s1, s2,1);
		Match m2 = new Match(im, s2,1);
		Match m3 = new Match(s1, s2,1);
		Match m4 = new Match(s1, s2,1);
		Match m5 = new Match(s1, s2,1);
		lm.addMatch(m);
		lm.addMatch(m1);
		lm.addMatch(m2);
		lm.addMatch(m3);
		lm.addMatch(m4);
		lm.addMatch(m5);
		Match actual = lm.halfNext(m, m.size());
		assertEquals(40, actual.getPlayer1().getRankingUser());
	}
	
	@Test
	void halfPrior() {
		ListMatch lm = new ListMatch();
		UserRegistered s1 = new UserRegistered("c", "v");
		UserRegistered s2 = new UserRegistered("a", "v");
		UserRegistered im = new UserRegistered("a", "v");
		im.setRankingUser(40);
		Match m = new Match(s1, s2,1);
		Match m1 = new Match(s1, s2,1);
		Match m2 = new Match(im, s2,1);
		Match m3 = new Match(s1, s2,1);
		Match m4 = new Match(s1, s2,1);
		Match m5 = new Match(s1, s2,1);
		lm.addMatch(m);
		lm.addMatch(m1);
		lm.addMatch(m2);
		lm.addMatch(m3);
		lm.addMatch(m4);
		lm.addMatch(m5);
		Match actual = lm.halfPrior(m5, 6);
		assertEquals(40, actual.getPlayer1().getRankingUser());
	}
	

}
