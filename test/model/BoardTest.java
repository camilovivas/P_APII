package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	
	@Test
	public void createMatrizTest() {
		String text = "";
		Board b = new Board();
		for (int i = 0; i < b.getBox().length; i++) {
			for (int j = 0; j < b.getBox()[0].length; j++) {
				text += b.getBox()[i][j].getScore()+" ";
				if(j == b.getBox()[0].length-1 ) {
					text += "\n";
				}
			}
		}
		assertEquals("10 10 10 10 10 10 10 10 "+"\n"+
					 "10 15 15 15 15 15 15 10 "+"\n"+
				     "10 15 10 10 10 10 15 10 "+"\n"+
				     "10 15 10 10 10 10 15 10 "+"\n"+
				     "10 15 10 10 10 10 15 10 "+"\n"+
				     "10 15 10 10 10 10 15 10 "+"\n"+
				     "10 15 15 15 15 15 15 10 "+"\n"+
				     "10 10 10 10 10 10 10 10 "+"\n", text);
	}

}
