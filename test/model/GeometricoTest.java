package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeometricoTest {

	@Test
	void addRankingTest() {
		Geometrico doe = Geometrico.getSingletonInstance();
		UserRegistered c = new UserRegistered("camilo");
		c.setWin(true);
		c.setRankingUser(80);
		doe.addRanking(c);
		
	}
	
	

}
