package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import exception.ExceptionDateError;
/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */
public class ListMatch implements Serializable {
	private Match firstMatch;
	
	public ListMatch() {
		
	}
	

	public void addMatch(Match a) {
		if(firstMatch == null) {
			firstMatch = a;
		}
		else {
			Match last = firstMatch.lastMatch();
			last.setNext(a);
			a.setPrior(last);
		}
		
	}
	
//	recursivo
	public int size() {
		int size = 0;
		if(firstMatch != null) {
			size += (1+ firstMatch.size());
		}
		return size;
	}
	
	public Match halfNext(Match half, int size) {
		int tam = size/2;
		int contador = 0;
		Match next = half;
		Match retorno = null;
		boolean ya = false;
		while(!ya) {
			if(contador == tam) {
				retorno = next;
				ya = true;
			}
			else {
				if(next.getNext() != null) {
					next = next.getNext();
					contador++;
				}
			}
		}
		
		return retorno;
	}
	
	
	public ArrayList<Match> search(String date) throws ExceptionDateError {
		Date datefind = null;
		ArrayList<Match> retorno = new ArrayList<>();
		Match half  = firstMatch;
		try {
			SimpleDateFormat change = new SimpleDateFormat("dd/MM/yyyy");
			datefind = change.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ExceptionDateError("NO EXISTE JUEGO EN ESTA FECHA. POR FAVOR VERIFIQUE LA FECHA INGRESADA.");
		}
		
		while(half != null) {			
			if(datefind.equals(half.getTime())) {
				retorno.add(half);
				half = half.getNext();
			}
			else {
					half = half.getNext();
			}
		}
		return retorno;
	}
	
	public String printFound(String date) {
		ArrayList<Match> e;
		String msj = null;
		try {
			e = search(date);
			if(e.size()>0) {
				for (int i = 0; i < e.size(); i++) {
					msj = e.get(i).toString();
				}
			}
		} catch (ExceptionDateError e1) {
			System.out.println("POR FAVOR DIGITE BIEN EL FORMATO:" +"DD/MM/YYYY");;
		}
		
		return msj;
	}
	
	
	
	
	
	
	
}
