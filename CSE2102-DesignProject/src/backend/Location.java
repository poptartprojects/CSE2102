package backend;

public class Location {

	String zipCode;
	String name;
	String address;
	public static void main(String[] args) {

	}
	public String getAddress()
	{
		return address;
	}

	public String getName()
	{
		return name;
	}

	public String getZipCode()
	{
		return zipCode;
	}
	public void setAddress(String add)
	{
		address = add;
	}
	public void setName(String newName)
	{
		name = newName;
	}
	public void setZipCode(String zip)
	{
		int length = zip.length();
		if(length == 5){
			zipCode = zip;
		}
		else{
			System.out.println("Enter a valid zip code.");
		}

	}

}
