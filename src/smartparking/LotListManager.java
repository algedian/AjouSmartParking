package smartparking;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LotListManager {
	
	private static double calDistance(double lat1, double lon1, double lat2, double lon2){  
	    double theta, dist;  
	    theta = lon1 - lon2;  
	    dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1))   
	          * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));  
	    dist = Math.acos(dist);  
	    dist = rad2deg(dist);  
	      
	    dist = dist * 60 * 1.1515;   
	    dist = dist * 1.609344;  
	    dist = dist * 1000.0;
	  
	    return dist;  
	}
	private static double deg2rad(double deg){  
	    return (double)(deg * Math.PI / (double)180d);  
	} 
	private static double rad2deg(double rad){  
	    return (double)(rad * (double)180d / Math.PI);  
	} 
	
	public static ArrayList<ParkingLot> getNearestLot(String latitude, String longitude) {
		ArrayList<ParkingLot> ret = new ArrayList<ParkingLot>();
		double lat1 = Double.parseDouble(latitude);
		double lon1 = Double.parseDouble(longitude);
		try {
			ret = DB.getParkingLots();
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("cannot road parkint lot list");
			e.printStackTrace();
		}
		for(ParkingLot p : ret){
			p.setDistance((int)calDistance(lat1,lon1,Double.parseDouble(p.getLatitude()),Double.parseDouble(p.getLongitude())));
		}
		ret.sort(new ParkingLotComparator());
		return (ArrayList<ParkingLot>) ret.subList(0, Math.min(ret.size()-1,4));
	}
}
