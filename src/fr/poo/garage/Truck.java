package fr.poo.garage;

import java.util.Calendar;
import java.util.Date;

import fr.poo.garage.exceptions.RentException;
import fr.poo.garage.files.In_Out_Client;
import fr.poo.garage.files.In_Out_Vehicle;

/**
 * Class representing a Truck. It extends the class Truck.
 * <p>
 * Dec 1, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */
@SuppressWarnings("serial")
public final class Truck extends Vehicle {

	/**
	 * The length of the truck.
	 * @see Truck#Truck()
	 * @see Truck#Truck(String, boolean, double)
	 */
	protected double length;
	
	/**
	 * Constructor without parameters. Length is initialized at 0. The car license plate is initialized at Unknown and the vehicle isn't rented.
	 * @see Vehicle#carLicense
	 * @see Vehicle#rented
	 * @see Truck#length
	 */
	public Truck()
	{
		super();
		this.length = 0;
	}
	
	/**
	 * Constructor with parameters.
	 * @param carLicense
	 * 					The car license plate of the truck.
	 * @param rented
	 * 					Boolean indicating if the truck is rented.
	 * @param length
	 * 					The length of the truck.
	 */
	public Truck(String carLicense, boolean rented, double length)
	{
		super(carLicense, rented);
		this.length = length;
	}
	
	/**
	 * Method allowing a client to rent a vehicle.
	 * @param c
	 * 				The client who is trying to rent a vehicle.
	 * @throws RentException
	 * 						Exception thrown if the vehicle is already rented.
	 */
	public void rent(Client c) throws RentException 
	{
		if(this.rented == true)
		{
			throw new RentException();
		}
		else
		{
			this.rented = true;
			this.rentDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(rentDate);
			calendar.add(Calendar.MONTH, 1); //Give the client a month to return the vehicle.
			this.deadLineRent = calendar.getTime();
			c.rentedVehicle.add(this);
			In_Out_Vehicle.update();
			In_Out_Client.update();
			System.out.println("The car is now rented by " + c.name + " on the " + this.rentDate + ". The return dead line is " + this.deadLineRent + ".");
		}
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

}
