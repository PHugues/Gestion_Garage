package fr.poo.garage;

import java.util.Hashtable;

import fr.poo.garage.files.In_Out_Client;
import fr.poo.garage.files.In_Out_Vehicle;
import fr.poo.garage.windows.Window;

/**
 * Class representing a garage where people can rent different kinds of vehicles.
 * <p>
 * Dec 11, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 3.0
 */
public final class Garage {

	
	/**
	 * Hash table containing all the clients registered. The key is their ID and the value is a Object of the class Client.
	 * @see Client#Client
	 */
	protected static Hashtable<String, Client> clientList = new Hashtable<String, Client>();
	protected static Client user;
	
	/**
	 * Main Method.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		In_Out_Vehicle.loadVehicles();
		In_Out_Client.loadClients();
		new Window();
	}

	/**
	 * 
	 * @return
	 */
	public static Hashtable<String, Client> getClientList() 
	{
		return clientList;
	}

	/**
	 * 
	 * @param clientList
	 */
	public static void setClientList(Hashtable<String, Client> clientList) 
	{
		Garage.clientList = clientList;
	}

	public static Client getUser() 
	{
		return user;
	}

	public static void setUser(Client user) 
	{
		Garage.user = user;
	}
}
