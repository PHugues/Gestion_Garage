package fr.poo.garage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.poo.garage.files.In_Out_Client;

/**
 * Class representing a Client inside the database of the garage. He has to identify himself using his ID and his password if he wants to rent or return a vehicle previously rented.
 * <p>
 * Dec 1, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */
@SuppressWarnings("serial")
public final class Client implements Serializable {
	
	/**
	 * The ID of the client.
	 * @see Client#Client()
	 * @see Client#Client(String, String, String)
	 */
	protected String ID;
	
	/**
	 * The Name of the client.
	 * @see Client#Client()
	 * @see Client#Client(String, String, String)
	 */
	protected String name;
	
	/**
	 * The Password of the client.
	 * @see Client#Client()
	 * @see Client#Client(String, String, String)
	 */
	protected String pass;
	
	/**
	 * A List of all the vehicle rented by the client.
	 * @see Client#rentedVehicleList()
	 */
	protected List<Vehicle> rentedVehicle = new ArrayList<Vehicle>();
	
	/**
	 * Constructor without parameters. ID is initialized at Unknown, name and password at Unknown.
	 * @see Client#ID
	 * @see Client#name
	 * @see Client#pass
	 */
	public Client()
	{
		this.ID = "Unknown";
		this.name = "Unknown";
		this.pass = "Unknown";
	}
	
	/**
	 * Constructor with parameters.
	 * @param string
	 * 				The ID of the client.
	 * @param name
	 * 				The name of the client.
	 * @param pass
	 * 				The password of the client.
	 */
	public Client(String ID, String name, String pass)
	{
		this.ID = ID;
		this.name = name;
		this.pass = pass;
		Garage.clientList.put(ID, this);
		In_Out_Client.addClient();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<Vehicle> getRentedVehicle() {
		return rentedVehicle;
	}

	public void setRentedVehicle(List<Vehicle> rentedVehicle) {
		this.rentedVehicle = rentedVehicle;
	}

	@Override
	public String toString() {
		return "Client [ID=" + ID + ", name=" + name + ", pass=" + pass + ", rentedVehicle=" + rentedVehicle + "]";
	}
	
}
