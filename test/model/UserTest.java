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
	
	
	@Test
	void ordenarBox() {
		User s = new User();
		Shape sh = new Shape();
		sh.setScore(10);
		Shape sh2 = new Shape();
		sh2.setScore(20);
		Shape sh3 = new Shape();
		sh3.setScore(13);
		Shape sh4 = new Shape();
		sh4.setScore(40);
		AsignableBox a1 = new AsignableBox(0, 0);
		a1.setShape(sh);
		AsignableBox a2 = new AsignableBox(0, 0);
		a2.setShape(sh2);
		AsignableBox a3 = new AsignableBox(0, 0);
		a3.setShape(sh3);
		AsignableBox a4 = new AsignableBox(0, 0);
		a4.setShape(sh4);
		s.getBoxes().add(a2);
		s.getBoxes().add(a1);
		s.getBoxes().add(a4);
		s.getBoxes().add(a3);
		s.ordenarBoxByScore();
		String actual = "";
		for (int i = 0; i < s.getBoxes().size(); i++) {
			actual += ((AsignableBox) s.getBoxes().get(i)).getScore();
		}
		
		assertEquals("20233050", actual);
	}

}
