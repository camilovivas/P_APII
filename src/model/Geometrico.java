package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS;
/**
 * @author Jhon Stiven Arboleda - Camilo Vivas - Felipe Garcia
 *
 */
public class Geometrico {
//	RELATIONS
	private TreeRanking treeRanking;
	private ListUser listUser;
	private ListMatch listMatch;
	
	public Geometrico() {
		
	}
	
	public void addUserRegistered(UserRegistered u) {
		listUser.addUserRegistered(u);
	}
	
	public void addUserAnonimous(UserAnonymous u) {
		listUser.addUserAnonimos(u);
	}
	
	public void serializedMatch() {
		try {
			FileOutputStream file = new FileOutputStream("files/Hall.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(listMatch);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void serializedUser() {
		try {
			FileOutputStream file = new FileOutputStream("files/Hall.arc");
			ObjectOutputStream object = new ObjectOutputStream(file);
			object.writeObject(listUser);
			object.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ReadSerializedMatch() {
		try {
			FileInputStream f = new FileInputStream(new File("files/Hall.arc"));
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
			f = new FileInputStream(new File("files/Hall.arc"));
			ObjectInputStream object = new ObjectInputStream(f);
			listUser = (ListUser) object.readObject();
			object.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("no se encontro el archivo");
		}
	}

	public void setInitMatch(int level) {
		System.out.println("Level" + " "+level);
	}
}
