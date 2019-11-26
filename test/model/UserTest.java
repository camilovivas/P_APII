package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void calculateRanking() {
		User s = new User();
		Board b = new Board();
		s.getBoxes().add(b.getBox()[0][0]);
		s.getBoxes().add(b.getBox()[1][1]);
		s.getBoxes().add(b.getBox()[1][2]);
		
		assertEquals(40, s.calculateRanking());
	}

}
