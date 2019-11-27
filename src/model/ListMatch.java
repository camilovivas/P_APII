package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public Match halfPrior(Match half, int size) {
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
				if(next.getPrior() != null) {
					next = next.getPrior();
					contador++;
				}
			}
		}
		
		return retorno;
	}
	
	
//	search binary in list
	public Match search(String date) {
		boolean ya = false;
		Date datefind = null;
		Match retorno = null;
		int size = size();
		int inicio = 0;
		Match half  = halfNext(firstMatch, size);
		try {
			SimpleDateFormat change = new SimpleDateFormat("dd/MM/yyyy");
			datefind = change.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		while(!ya) {			
			if(datefind.equals(half.getTime())) {
				retorno = half;
				ya = true;
			}
			else if(datefind.compareTo(half.getTime())>0){
				size = size/2;
				half = halfPrior(half, size);
			}
			else {
				size = size/2;
				half = halfNext(half, size);
			}
		}
		
		
		return retorno;
	}
	
	
	
	
	
}
