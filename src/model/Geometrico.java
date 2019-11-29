package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exception.ExceptionNoGameDate;
import exception.ExceptionPlayerNotFound;

/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */
public class Geometrico {
	private static Geometrico geo;
//	RELATIONS
	private TreeRanking treeRanking;
	private ListUser listUser;
	private ListMatch listMatch;
	private User player1;
	private User player2;
	private int level;
	private Match match;
	
	
	private Geometrico() {
		listUser = new ListUser();
		listMatch = new ListMatch();
		treeRanking = new TreeRanking();
		ReadSerializedUsers();
		ReadSerializedMatch();
		ReadSerializedRanking();
	}
	
	public static Geometrico getSingletonInstance() {
		if(geo == null) {
			geo = new Geometrico();
		}
		return geo;
	}
//	get and set____________________
	public void setPlayer1(User player1) {
		this.player1 = player1;
	}
	
	public void setPlayer2(User player2) {
		this.player2 = player2;
	}
	
	public void setLevel(int level) {
		System.out.println("R");
		this.level = level;
	}
	
	public Match getMatch() {
		return match;
	}
	
//	agregar _________________________________________________________________________________________

	public void addUserRegistered(UserRegistered u) {
		listUser.addUserRegistered(u);
		serializedUser();
	}
	

	public void addUserAnonimous(UserAnonymous u) {
		listUser.addUserAnonimos(u);
	}
	
	public void addMatch(Match u) {
		listMatch.addMatch(u);
		serializedMatch();
	}
	
//	cada vez que se agregue una figura a la matriz verificar esto 
	public void addRanking(User u) {
		RankingBestUser add = new RankingBestUser(u);
		if(u.isWin()) {
			treeRanking.addRanking(add);
			serializedRanking();
		}
	}
	
//	serializar ______________________________________________________________________________________
	
	public void serializedMatch() {
		try {
			FileOutputStream file = new FileOutputStream("data/serializable_File/Match.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(listMatch);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void serializedUser() {
		try {
			FileOutputStream file = new FileOutputStream("data/serializable_File/User.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(listUser);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void serializedRanking() {
		try {
			FileOutputStream file = new FileOutputStream("data/serializable_File/Ranking.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(treeRanking);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ReadSerializedMatch() {
		try {
			FileInputStream f = new FileInputStream(new File("data/serializable_File/Match.arc"));
			ObjectInputStream object = new ObjectInputStream(f);
			listMatch = (ListMatch) object.readObject();
			object.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("no se encontro el archivo");
		}
	}
	
	public void ReadSerializedUsers() {
		FileInputStream f;
		try {
			f = new FileInputStream(new File("data/serializable_File/User.arc"));
			ObjectInputStream object = new ObjectInputStream(f);
			listUser = (ListUser) object.readObject();
			object.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("no se encontro el archivo");
		}
	}
	
	public void ReadSerializedRanking() {
		FileInputStream f;
		try {
			f = new FileInputStream(new File("data/serializable_File/Ranking.arc"));
			ObjectInputStream object = new ObjectInputStream(f);
			treeRanking = (TreeRanking) object.readObject();
			object.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("no se encontro el archivo");
		}
	}
	
//	busqueda________________________________________________________________________________________
	
	//SI NO SE ENCUENTRA. SE AGREGA.
	public UserRegistered searchUser(String name) {
		UserRegistered s1 = listUser.search(name);
		if(s1 == null) {
			s1 = new UserRegistered(name);
			addUserRegistered(s1);
		}
		return s1;
	}
	
//	EXEPTION: SI NO SE ENCONTRÓ ES PORQUE NO EXISTE
	public String foundUser(String name) throws ExceptionPlayerNotFound {
		UserRegistered s1 = listUser.search(name);
		String msj = "";
		if(s1 == null) {
			throw new ExceptionPlayerNotFound("EL JUGADOR NO EXISTE. POR FAVOR VERIFIQUE EL NOMBRE");
		}
		else {
			msj += s1.toString();
		}
		return msj;
	}
	
	//EXCEPTION: SI ES NULL ES POR QUE NO EXISTE UNA PARTIDA EN ESA FECHA
	public String searchMatch(String date) throws ExceptionNoGameDate{
		String retorno = listMatch.printFound(date);
		if(retorno == null) {
			throw new ExceptionNoGameDate("NO EXISTE UNA PARTIDA EN ESTA FECHA. POR FAVOR VERIFIQUE LA FECHA INGRESADA.");
		}
		return retorno;
	}
	
	public void initMatch() {
		Match mt= new Match(player1, player2, level);
		listMatch.addMatch(mt);
		System.out.println("bien");
		this.match = mt;
	}

	public int getLeveMatch() {
		return this.level;
	}
}
