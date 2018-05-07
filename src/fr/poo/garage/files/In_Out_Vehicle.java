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
import java.util.List;

import fr.poo.garage.Car;
import fr.poo.garage.Motorbike;
import fr.poo.garage.Truck;
import fr.poo.garage.Vehicle;

/**
 * Class used to import and export the file with the vehicles used in the garage.
 * <p>
 * Dec 13, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */

public final class In_Out_Vehicle {

	/**
	 * Input stream.
	 */
	static ObjectInputStream ois;
	
	/**
	 * Output stream.
	 */
    static ObjectOutputStream oos;
    
	/**
	 * Save some vehicles inside a file. (Called one time if the file doesn't exist yet.)
	 * @see In_Out_Vehicle#loadVehicles()
		/*for(int i = 0 ; i < listContent.size() ; i++)
		{
			System.out.println("Vehicle test" + i);
	 * @see Vehicle#listVehicle
	 */
	public static void addVehicles()
	{
		try //Save some vehicles inside a file.
		{
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Vehicles.txt"))));
			Vehicle.getListVehicle().add(new Truck("CZ75", false, 120));
			Vehicle.getListVehicle().add(new Car("AB95", false,  "Peugeot", "305", 2007));
			Vehicle.getListVehicle().add(new Motorbike("HG10", false, "Citroen", 100));
			oos.writeObject(Vehicle.getListVehicle());
			oos.close();
		}
		catch(FileNotFoundException e) //If the file isn't find.
		{
			try //Try to create a file and then add the vehicles.
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Vehicles.txt")));
				writer.close();
				In_Out_Vehicle.addVehicles();
			} 
			catch (IOException e1) //If an error has appeared during the output stream.
			{
				//e1.printStackTrace();
			}
		}
		catch(IOException e) //If an error has appeared during the output stream.
		{
			//e.printStackTrace();
		}
	}
	
	/**
	 * Update the file with all the vehicles if one vehicle has been rented during a previous using of the program.
	 */
	public static void update()
	{
		try //Update the vehicles inside the file.
		{
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Vehicles.txt"))));
			oos.reset();
			oos.writeObject(Vehicle.getListVehicle());
			oos.close();
		}
		catch(FileNotFoundException e) //If the file isn't found.
		{
			e.printStackTrace();
		}
		catch(IOException e) //If an error has appeared during the output stream.
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Load the list of vehicles from a file and enters them inside a List.
	 * @see Vehicle#listVehicle
	 * @see In_Out_Vehicle#addVehicles()
	 */
	@SuppressWarnings("unchecked")
	public static void loadVehicles()
	{
		try
		{
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Vehicles.txt")))); //Open an input stream to load the file.
			try //Load the vehicles from the file and save them in the List.
			{
				Vehicle.setListVehicle((List<Vehicle>) ois.readObject());
			}
			catch(ClassNotFoundException e) //If the class isn't found.
			{
				e.printStackTrace();
			}
		}
		catch(FileNotFoundException e) //If the file isn't found : create one.
		{
			In_Out_Vehicle.addVehicles();
		}
		catch(IOException e) //If an error has appeared during the input stream.
		{
			e.printStackTrace();
		}
	}
}
