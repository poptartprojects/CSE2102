
public class Location {

	int zipCode;
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

	public int getZipCode()
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
	public void setZipCode(int zip)
	{
		int length = String.valueOf(zip).length();
		if(length == 5){
			zipCode = zip;
		}
		else{
			System.out.println("Enter a valid zip code.");
		}

	}

}
