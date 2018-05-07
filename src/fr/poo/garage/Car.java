package fr.poo.garage;

import java.util.Calendar;
import java.util.Date;

import fr.poo.garage.exceptions.RentException;
import fr.poo.garage.files.In_Out_Client;
import fr.poo.garage.files.In_Out_Vehicle;

/**
 * Class representing a Car. It extends the class Vehicle.
 * <p>
 * Dec 1, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */
@SuppressWarnings("serial")
public final class Car extends Vehicle {

	/**
	 * The brand of the car.
	 * @see Car#Car()
	 * @see Car#Car(String, boolean, String, String, int)
	 */
	protected String brand;
	
	/**
	 * The name of the car.
	 * @see Car#Car()
	 * @see Car#Car(String, boolean, String, String, int)
	 */
	protected String name;
	
	/**
	 * The year of the car.
	 * @see Car#Car()
	 * @see Car#Car(String, boolean, String, String, int)
	 */
	protected int year;
	
	/**
	 * Constructor without parameters. The brand and the name are initialized at Unknown, the year at 0. The car license plate is initialized at Unknown and the vehicle isn't rented.	 
	 * @see Vehicle#carLicense
	 * @see Vehicle#rented
	 * @see Car#brand
	 * @see Car#name
	 * @see Car#year
	 */
	public Car()
	{
		super();
		this.brand = "Unknown";
		this.name = "Unknown";
		this.year = 0;
	}
	
	/**
	 * Constructor with parameters.
	 * @param carLicense
	 * 						The license plate of the car.
	 * @param rented
	 * 						Boolean indicating if the car is already rented or not.
	 * @param brand
	 * 						The brand of the car.
	 * @param name
	 * 						The name of the car.
	 * @param year
	 * 						The year of the car.
	 */
	public Car(String carLicense, boolean rented, String brand, String name, int year)
	{
		super(carLicense, rented);
		this.brand = brand;
		this.name = name;
		this.year = year;
	}

	/**
	 * Method allowing a client to rent a vehicle.
	 * @param c
	 * 				The client who is trying to rent a vehicle.
	 * @throws RentException
	 * 				Exception thrown if the vehicle is already rented.
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
			calendar.add(Calendar.DAY_OF_MONTH, 7); //Give the client 1 week to return the vehicle.
			this.deadLineRent = calendar.getTime();
			c.rentedVehicle.add(this);
			In_Out_Vehicle.update();
			In_Out_Client.update();
			System.out.println("The car is now rented by " + c.name + " on the " + this.rentDate + ". The return dead line is " + this.deadLineRent + ".");
		}
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
