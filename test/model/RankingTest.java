package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankingTest {

	@Test
	public void testAdd() {
		User user1 = new User();
		User user2 = new User();
		user1.setRankingUser(10);
		user2.setRankingUser(12);
		RankingBestUser m1 = new RankingBestUser(user1); 
		RankingBestUser m2 = new RankingBestUser(user2);
		TreeRanking trt = new TreeRanking();
		trt.addRanking(m1);
		trt.addRanking(m2);
		
		assertEquals(12, m1.getRight().getPlayer().getRankingUser());
	}
	@Test
	public void testAdd1() {
		User user1 = new User();
		User user2 = new User();
		user1.setRankingUser(10);
		user2.setRankingUser(11);
		RankingBestUser m1 = new RankingBestUser(user1); 
		RankingBestUser m2 = new RankingBestUser(user2);
		TreeRanking trt = new TreeRanking();
		trt.addRanking(m1);
		trt.addRanking(m2);
		
		assertEquals(11, m1.getRight().getPlayer().getRankingUser());
	}
	@Test
	public void testInOrden() {
		UserRegistered user1 = new UserRegistered("camilo");
		UserRegistered user2 = new UserRegistered("felipe");
		UserAnonymous user3 = new UserAnonymous();
		UserRegistered user4 = new UserRegistered("jones");
		user1.setRankingUser(10);
		user2.setRankingUser(15);
		user3.setRankingUser(20);
		user4.setRankingUser(30);
		RankingBestUser m1 = new RankingBestUser(user1); 
		RankingBestUser m2 = new RankingBestUser(user2);
		RankingBestUser m3 = new RankingBestUser(user3); 
		RankingBestUser m4 = new RankingBestUser(user4);
		TreeRanking trt = new TreeRanking();
		trt.addRanking(m1);
		trt.addRanking(m2);
		trt.addRanking(m3);
		trt.addRanking(m4);
		String actual = trt.inOrden();
		assertEquals("camilo  10"+"\n"+ "felipe  15"+"\n"+"Anonymous  20"+"\n"+"jones  30"+"\n", actual);
	}
	@Test
	public void clasifiTest() {
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		User user4 = new User();
		user1.setRankingUser(10);
		user2.setRankingUser(9);
		user3.setRankingUser(8);
		user4.setRankingUser(5);
		RankingBestUser m1 = new RankingBestUser(user1); 
		RankingBestUser m2 = new RankingBestUser(user2);
		RankingBestUser m3 = new RankingBestUser(user3); 
		RankingBestUser m4 = new RankingBestUser(user4);
		TreeRanking trt = new TreeRanking();
		trt.addRanking(m1);
		trt.addRanking(m2);
		trt.addRanking(m3);
		
		assertEquals(false, trt.clasification(user4));
//		assertFalse(false);
	}
}
