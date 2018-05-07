package fr.poo.garage.exceptions;

/**
 * Exception raised when an user is trying to rent a vehicle already rented.
 * <p>
 * Dec 1, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */
public class RentException extends Exception {

	/**
	 * The serialVersionUID of the Exception.
	 */
	private static final long serialVersionUID = -7172739850459677072L;

	/**
	 * String generated when the Exception is raised.
	 * @return
	 * 			An error message.
	 */
	public String toString()
	{
		return("The vehicle is already rented, you have a to choose a different one.\n");
	}
}
