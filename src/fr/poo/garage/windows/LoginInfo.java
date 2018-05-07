package fr.poo.garage.windows;

/**
 * Class representing a 
 * <p>
 * Dec 14, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */

public final class LoginInfo {

	private String name;
	
	public LoginInfo() {}
	
	public LoginInfo(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		String str = "";
		if(this.name != null)
		{
			str = "Successfully logged as " +  this.name;		
		}
		else
		{
			str = "No information.";
		}
		return str;
	}
}