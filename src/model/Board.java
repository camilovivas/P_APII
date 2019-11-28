package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */

public class Board {
	public static int COLUMNA_LEVEL_1 = 4;
	public static int FILA_LEVEL_1 = 4;
	public static int COLUMNA_LEVEL_2 = 5;
	public static int FILA_LEVEL_2 = 5;
	public static int COLUMNA_LEVEL_3 = 6;
	public static int FILA_LEVEL_3 = 6;
	private Box[][] box;
	private int level;
	
	
	public Board(int level){
		this.level = level;
		inicilized();
		chargeTXT();
	}
	
	
	
	public AsignableBox[][] getBox() {
		return (AsignableBox[][]) box;
	}



	public void setBox(AsignableBox[][] box) {
		this.box =  box;
	}

	public void inicilized() {
		if(level == 1) {
			box = new AsignableBox[FILA_LEVEL_1][COLUMNA_LEVEL_1];
			createMatriz();
		}
		if(level == 2) {
			box = new AsignableBox[FILA_LEVEL_2][COLUMNA_LEVEL_2];
			createMatriz();
		}
		if(level == 3) {
			box = new AsignableBox[FILA_LEVEL_3][COLUMNA_LEVEL_3];
			createMatriz();
		}
	}

	public void createMatriz() {
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if(box[i][j] == null) {
					box[i][j] = new AsignableBox(i,j);
				}
			}
		}
	}
	
	public void conquerBox(int i, int j, Shape shape) {
		((AsignableBox) box[i][j]).setShape(shape);
		 
	}
	
	public  void chargeTXT() {
		try {
			String txt = "";
			BufferedReader br =null;
			if(level == 1) {
				br = new BufferedReader(new FileReader(new File("data/txt_File/level1.txt")));	
			}
			if(level == 2) {				
				br = new BufferedReader(new FileReader(new File("data/txt_File/level2.txt")));	
			}
			if(level == 3) {
				br = new BufferedReader(new FileReader(new File("data/txt_File/level3.txt")));		
			}
			int j2 = 0;
			while((txt= br.readLine())!= null) {
				String [] t = txt.split(",");
				for (int i = 0; i < t.length; i++) {
					int parse = Integer.parseInt(t[i]);
					((AsignableBox) box[j2][i]).setScore(parse); 
				}
			j2++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
