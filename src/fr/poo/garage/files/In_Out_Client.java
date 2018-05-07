package fr.poo.garage.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import fr.poo.garage.Client;
import fr.poo.garage.Garage;

/**
 * Class used to import and export the file with the clients used in the garage.
 * <p>
 * Dec 13, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */

public final class In_Out_Client {

	/**
	 * Input stream.
	 */
	static ObjectInputStream ois;
	
	/**
	 * Output stream.
	 */
    static ObjectOutputStream oos;
	
	/**
	 * Save some client inside a file. (Called one time if the file doesn't exist yet.)
	 * @see In_Out_Client#loadClients()
	 * @see Garage#clientList
	 */
	public static void addClients()
	{
		try //Save some clients inside a file. 
		{
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Client.txt"))));
			Garage.getClientList().put("10", new Client("10", "Pierre", "yo"));
			oos.writeObject(Garage.getClientList());
			oos.close();
		}
		catch(FileNotFoundException e) //If the file isn't found.
		{
			try //Try to create a file and then add the clients.
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Client.txt")));
				writer.close();
				In_Out_Client.addClients();
			} 
			catch (IOException e1) //If an error has appeared during the output stream.
			{
				e1.printStackTrace();
			}
		}
		catch(IOException e) //If an error has appeared during the output stream.
		{
			//e.printStackTrace();
		}
	}
	
	/**
	 * Add a client to the file.
	 * @see Garage#clientList
	 */
	public static void addClient()
	{
		try //Save a client inside the file.
		{
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Client.txt"))));
			oos.writeObject(Garage.getClientList());
			oos.close();
		}
		catch(FileNotFoundException e) //If the file isn't find.
		{
			try //Try to create a file and then add the client.
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Client.txt")));
				writer.close();
				In_Out_Client.addClient();
			}
			catch(IOException e1) //If an error has appeared during the output stream.
			{
				e1.printStackTrace();
			}
		}
		catch(IOException e) //If an error has appeared during the output stream.
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Update the file with all the clients if one client rented a vehicle during a previous using of the program.
	 */
	public static void update()
	{
		try //Update the client inside the file.
		{
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Client.txt"))));
			oos.reset();
			oos.writeObject(Garage.getClientList());
			oos.close();
		}
		catch(FileNotFoundException e) //If the file doesn't exist.
		{
			e.printStackTrace();
		}
		catch(IOException e) //If an error has appeared during the output stream.
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Load the list of clients from a file and enter them inside a hash table.
	 * @see Garage#clientList
	 * @see In_Out_Client#addClients()
	 */
	@SuppressWarnings("unchecked")
	public static void loadClients()
	{
		try //Open an input stream to load the file.
		{
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Client.txt")))); 
			try //Load the vehicles from the file and save them in the List.
			{
				Garage.setClientList((Hashtable<String, Client>) ois.readObject());
			}
			catch(ClassNotFoundException e) //If the class isn't found.
			{
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) //If the file isn't found : create one.
		{
			In_Out_Client.addClients();
		}
		catch(IOException e) //If an error has appeared during the input stream.
		{
			e.printStackTrace();
		}
	}
}
