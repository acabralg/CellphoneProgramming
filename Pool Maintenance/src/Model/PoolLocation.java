package Model;

public class PoolLocation {

	private int latitude;
	private int longitude;
	private String category;
	private String name;
	private String comments;
	
	public PoolLocation()
	{
		
	}
	
	public PoolLocation(int lat, int lon, String cat, String nam, String com)
	{
		this.latitude = lat;
		this.longitude = lon;
		this.category = cat;
		this.name = nam;
		this.comments = com;
	}
	
	public int GetLatitude()
	{
		return this.latitude;
	}
	
	public int GetLongitude()
	{
		return this.longitude;
	}

	public String GetCategory()
	{
		return this.category;
	}
	
	public String GetName()
	{
		return this.name;
	}
	
	public String GetComments()
	{
		return this.comments;
	}
	
}
