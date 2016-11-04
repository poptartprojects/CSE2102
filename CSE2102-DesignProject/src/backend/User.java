package backend;
public class User extends Location {
	Double latitude;
	Double longitude;
	public static void main(String[] args) {
		
	}
	public Double getLatitude()
	{
		return latitude;
	}
	public Double getLongitude()
	{
		return longitude;
	}
	public void setLatitude(Double lat)
	{
		latitude = lat;
	}
	public void setLongitude(Double longi)
	{
		longitude = longi;
	}
}
