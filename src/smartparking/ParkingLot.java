package smartparking;

public class ParkingLot {
	private String latitude;
	private String longitude;
	private String name;
	private int lotID;
	private int distance;
	
	public ParkingLot(String latitude, String longitude, int lotID, String name){
		this.latitude = latitude;
		this.longitude = longitude;
		this.lotID = lotID;
		this.name = name;
		distance = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}


	public int getLotID() {
		return lotID;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}
	
}
