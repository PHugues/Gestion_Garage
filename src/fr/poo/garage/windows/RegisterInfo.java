package fr.poo.garage.windows;

/**
 * Class representing a 
 * <p>
 * Dec 14, 2017
 * @author Pierre Hugues - L2 Computer Science Group G11
 * @version 1.0
 */

public final class RegisterInfo {

	private String name;
	private String ID;
	private String pass;
	
	public RegisterInfo() {}
	
	public RegisterInfo(String name, String ID, String pass)
	{
		this.name = name;
		this.ID = ID;
		this.pass = pass;
	}
	
	public String toString()
	{
		String str = "";
		if(this.name != null && this.ID != null && this.pass != null)
		{
			str += "Name : " + this.name + "\n";
			str += "ID : " + this.ID + "\n";
			str += "Password : " + this.pass + "\n";
		}
		else
		{
			str = "No information.";
		}
		return str;
	}
}
