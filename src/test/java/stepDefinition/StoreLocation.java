package stepDefinition;

public class StoreLocation {

	private int zip;
	private String city;
	private String city1;
	
	public StoreLocation(int zip, String city, String city1) {
		super();
		this.zip = zip;
		this.city = city;
		this.city1 = city1;
	}
	
	@Override
	public String toString() {
		return "StoreLocation [zip=" + zip + ", city=" + city + ", city1=" + city1 + "]";
	}

	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	
	
	
}
