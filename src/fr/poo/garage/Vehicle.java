package fr.poo.garage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.poo.garage.exceptions.RentException;
import fr.poo.garage.files.In_Out_Client;
import fr.poo.garage.files.In_Out_Vehicle;

/**
 * Class representing a Vehicle. It can be a Motorbike or a Truck or a Car
 * <p>
 * Dec 1, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */

@SuppressWarnings("serial")
public abstract class Vehicle implements Serializable {

	/**
	 * The car license plate of the vehicle.
	 * @see Vehicle#Vehicle()
	 * @see Vehicle#Vehicle(String, boolean)
	 */
	protected String carLicense;
	
	/**
	 * Boolean that indicates if the vehicle is already rented or not.
	 * @see Vehicle#Vehicle()
	 * @see Vehicle#Vehicle(String, boolean)
	 */
	protected boolean rented;
	
	/**
	 * The date of the rent of the vehicle.
	 * @see Vehicle#Vehicle()
	 * @see Vehicle#rent(Client)
	 */
	protected Date rentDate;
	
	/**
	 * The dead line of the return of the vehicle.
	 * @see Vehicle#Vehicle()
	 * @see Vehicle#rent(Client)
	 */
	protected Date deadLineRent;
	
	/**
	 * List of all vehicles.
	 * @see Vehicle#vehicleList()
	 */
	private static List<Vehicle> listVehicle = new ArrayList<Vehicle>();
	
	/**
	 * Constructor without parameters. The car license plate is initialized at Unknown and the vehicle isn't rented.
	 * @see Vehicle#carLicense
	 * @see Vehicle#rented
	 */
	public Vehicle()
	{
		this.carLicense = "Unknown";
		this.rented = false;
	}
	
	/**
	 * Constructor with parameters.
	 * @param carLicense
	 * 					The car license plate of the vehicle.
	 * @param rented
	 * 					Indicates if the vehicle is rented or not.
	 */
	public Vehicle(String carLicense, boolean rented)
	{
		this.carLicense = carLicense;
		this.rented = rented;
	}
	
	/**
	 * Abstract method allowing a client to rent a vehicle.
	 * @param c
	 * 				The client who is trying to rent a vehicle.
	 * @throws RentException
	 * 						Exception thrown if the vehicle is already rented.
	 */
	public abstract void rent(Client c) throws RentException;
	
	/**
	 * Method called when the client is returning a car. It deletes the vehicle from his list of rented vehicles, and set the vehicle as not rented, without a rent date and a dead line for his return.
	 * @param c
	 * 			The client who is trying to return a vehicle.
	 * @param v
	 * 			The vehicle to remove from his rent list.
	 */
	public static void returnVehicle(Client c, Vehicle v)
	{
		v.rented = false;
		v.deadLineRent = null;
		v.rentDate = null;
		c.rentedVehicle.remove(v);
		if(!(Vehicle.getListVehicle().contains(v))) //If the vehicle isn't inside the list of vehicles. Meaning it has been doubled by the saving/loading of files.
		{
			int buffer = 0;
			while(!(Vehicle.getListVehicle().get(buffer).carLicense.equals(v.carLicense))) //Find the index of the car identical to the car entered.
			{
				buffer++;
			}
			Vehicle.getListVehicle().remove(buffer);
			Vehicle.getListVehicle().add(buffer, v);
		}
		In_Out_Vehicle.update();
		In_Out_Client.update();
	}

	/**
	 * @return the listVehicle
	 */
	public static List<Vehicle> getListVehicle() {
		return listVehicle;
	}

	/**
	 * @param listVehicle the listVehicle to set
	 */
	public static void setListVehicle(List<Vehicle> listVehicle) {
		Vehicle.listVehicle = listVehicle;
	}

	public String getCarLicense() {
		return carLicense;
	}

	public void setCarLicense(String carLicense) {
		this.carLicense = carLicense;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getDeadLineRent() {
		return deadLineRent;
	}

	public void setDeadLineRent(Date deadLineRent) {
		this.deadLineRent = deadLineRent;
	}
}
