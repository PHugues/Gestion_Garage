package fr.poo.garage;

import java.util.Calendar;
import java.util.Date;

import fr.poo.garage.exceptions.RentException;
import fr.poo.garage.files.In_Out_Client;
import fr.poo.garage.files.In_Out_Vehicle;

/**
 * Class representing a Motorbike. It extends the class Vehicle.
 * <p>
 * Dec 1, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */
@SuppressWarnings("serial")
public final class Motorbike extends Vehicle {
	
	/**
	 * The brand of the Motorbike
	 * @see Motorbike#Motorbike()
	 * @see Motorbike#Motorbike(String, boolean, String, int)
	 */
	protected String brand;
	
	/**
	 * The power of the engine within the Motorbike.
	 * @see Motorbike#Motorbike()
	 * @see Motorbike#Motorbike(String, boolean, String, int)
	 */
	protected int power;
	
	/**
	 * Constructor without parameters. The brand is initialized at Unknown and the power at 0. The car license plate is initialized at Unknown and the vehicle isn't rented.
	 * @see Vehicle#carLicense
	 * @see Vehicle#rented
	 * @see Motorbike#brand
	 * @see Motorbike#power
	 */
	public Motorbike()
	{
		super();
		this.brand = "Unknown";
		this.power = 0;
	}
	
	/**
	 * Constructor with parameters.
	 * @param carLicense
	 * 					The car license plate of the motorbike.
	 * @param rented
	 * 					Boolean indicating if the motorbike is rented.
	 * @param brand
	 * 					The brand of the motorbike.
	 * @param power
	 * 					The power of the motorbike.
	 */
	public Motorbike(String carLicense, boolean rented, String brand, int power)
	{
		super(carLicense, rented);
		this.brand = brand;
		this.power = power;
	}

	/**
	 * Method allowing a client to rent a vehicle.
	 * @param c
	 * 				The client who is trying to rent a vehicle.
	 * @throws RentException
	 * 						Exception thrown if the vehicle is already rented.
	 */
	@Override
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
			calendar.add(Calendar.DAY_OF_MONTH, 14); //Give the client 2 weeks to return the vehicle.
			this.deadLineRent = calendar.getTime();
			c.rentedVehicle.add(this);
			In_Out_Vehicle.update();
			In_Out_Client.update();
			System.out.println("The car is now rented by " + c.name + " on the " + this.rentDate + ". The return dead line is " + this.deadLineRent + ".");;
		}
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
