package model;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class ListMatchTest {

	@Test
	public void addMatchTest() {
		ListMatch lm = new ListMatch();
		UserRegistered s1 = new UserRegistered("c");
		UserRegistered s2 = new UserRegistered("a");
		Match m = new Match(s1, s2,1);
		UserRegistered s3 = new UserRegistered("m");
		s3.setRankingUser(20);
		UserRegistered s4 = new UserRegistered("n");
		Match m2 = new Match(s3, s4,1);
		lm.addMatch(m);
		lm.addMatch(m2);
		assertEquals(20, m.getNext().getPlayer1().getRankingUser());
		
	}
	
	@Test
	public void siseTest() {
		ListMatch lm = new ListMatch();
		UserRegistered s1 = new UserRegistered("c");
		UserRegistered s2 = new UserRegistered("a");
		Match m = new Match(s1, s2,1);
		UserRegistered s3 = new UserRegistered("m");
		s3.setRankingUser(20);
		UserRegistered s4 = new UserRegistered("n");
		Match m2 = new Match(s3, s4,1);
		lm.addMatch(m);
		lm.addMatch(m2);
		int actual = lm.size();
		assertEquals(2, actual);
	}
	
	@Test
	public void halfNext() {
		ListMatch lm = new ListMatch();
		UserRegistered s1 = new UserRegistered("c");
		UserRegistered s2 = new UserRegistered("a");
		UserRegistered im = new UserRegistered("a");
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
	public Date parse(String date) {
		Date datefind = null;
		try {
			SimpleDateFormat change = new SimpleDateFormat("dd/MM/yyyy");
			datefind = change.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datefind;
	}
	@Test
	public void search() {
		ListMatch lm = new ListMatch();
		UserRegistered s1 = new UserRegistered("c");
		UserRegistered s2 = new UserRegistered("a");
		UserRegistered im = new UserRegistered("a");
		im.setRankingUser(40);
		Match m = new Match(s1, s2,1);
//		m.setTime(parse("28/11/2019"));
		Match m1 = new Match(s1, s2,1);
//		m1.setTime(parse("28/11/2019"));
		Match m2 = new Match(im, s2,1);
//		m2.setTime(parse("28/11/2019"));
		lm.addMatch(m);
		lm.addMatch(m1);
		lm.addMatch(m2);
		ArrayList<Match> actual = lm.search("28/11/2019");
		assertEquals(3, actual.size());
		
	}
	
	
	

}
