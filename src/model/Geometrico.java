package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		ReadSerializedUsers();
		ReadSerializedMatch();
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
	
//	busqueda________________________________________________________________________________________
	
	//si no lo encuentra lo agrega
	public UserRegistered searchUser(String name) {
		UserRegistered s1 = listUser.search(name);
		if(s1 == null) {
			s1 = new UserRegistered(name);
			addUserRegistered(s1);
		}
		return s1;
	}
	
//	EXEPTION: SI NO SE ENCONTRO ES POR QUE NO EXISTE
	public String foundUser(String name) {
		UserRegistered s1 = listUser.search(name);
		String msj = "";
		if(s1 == null) {
//			TODO
		}
		else {
			msj += s1.toString();
		}
		return msj;
	}
	
	//EXCEPTION: SI ES NULL ES POR QUE NO EXISTE UNA PARTIDA EN ESA FECHA, OTRA: ESCRIBIO MAL LA FECHA
	public String searchMatch(String date) {
		String retorno = listMatch.printFound(date);
		if(retorno == null) {
			//TODO
		}
		return retorno;
	}
	
	public void initMatch() {
		Match mt= new Match(player1, player2, level);
		listMatch.addMatch(mt);
		System.out.println("bien");
		this.match = mt;
		serializedMatch();
	}

	//-----------------------------------
	//-----------------------------------
	//TODO HACER MÉTODO PARA RETORNAR LEVEL DEL JUEGO
	public int getLeveMatch() {
		return this.level;
	}
}
