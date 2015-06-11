package smartparking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DB {
	public static User getUser(String phoneNum) throws SQLException, IOException {
		Connection con = getConnection();
		User user = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT name, userID FROM user WHERE user.userID='" + phoneNum + "';");			
			while(rs.next()){
				user = new User(rs.getString(1), rs.getString(2));
			}
			rs.close();
		}
		finally {
			con.close();
		}
		return user;
	}
	
	public static User addUser(String name, String userID) throws SQLException, IOException {
		Connection con = getConnection();
		User res = null;
		try {
			Statement st = con.createStatement();
			String duplication = null;
			
			ResultSet rs = st.executeQuery("SELECT userID FROM user WHERE user.userID='" + userID + "';");
			while(rs.next())
				duplication = rs.getString(1);
			
			
			if(duplication == null){
				st.executeUpdate("INSERT INTO user VALUES('" + name + "','" + userID + "')");
				res = new User(name,userID);
			}else{
				System.out.println("Join Faild id("+userID+") is already exist");
			}
			
			st.close();
		}
		finally {
			con.close();
		}
		return res;
	}
	
	
	public static ArrayList<ParkingLot> getParkingLots() throws SQLException, IOException {
		Connection con = getConnection();
		ArrayList<ParkingLot> list = new ArrayList<ParkingLot>();
		int lotID;
		String latitude;
		String longitude;
		String name;
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(
					"select latitude, longitude, parkingLotID, parkingLotName, validSpace from parking_lot;");
			while(rs.next()){
				latitude = rs.getString(1);
				longitude = rs.getString(2);
				lotID = rs.getInt(3);
				name = rs.getString(4);
				int validSpace = rs.getInt(5);
				list.add(new ParkingLot(latitude, longitude, lotID, name, validSpace));
			}
			rs.close();
		}
		finally {
			con.close();
		}
		return list;
	}
	
	public static ParkingLot getLotInfo(String lotID) throws SQLException, IOException {
		Connection con = getConnection();
		ParkingLot lot = null;
		int tmplotID;
		String latitude;
		String longitude;
		String name;
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT latitude, longitude, parkingLotID, parkingLotName,validSpace FROM parking_lot "
					+ "where parking_lot.parkingLotID='" + lotID + "';");
			while(rs.next()){
				latitude = rs.getString(1);
				longitude = rs.getString(2);
				tmplotID = rs.getInt(3);
				name = rs.getString(4);
				int validSpace = rs.getInt(5);
				lot = new ParkingLot(latitude, longitude, tmplotID, name,validSpace);
			}
			rs.close();
		}
		finally {
			con.close();
		}
		return lot;
	}
	
	private static String keyGenerator(){
		String key = "";
		Double k = (Math.random()*10);
		for(int i = 0;i<4;i++){
			key += k.toString();
			k = (Math.random()*10);
		}
		return key;
	}
	
	public static AuthInfo makeReservation(String lotID, String userID) throws SQLException, IOException{
		Connection con = getConnection();
		String authKey = null;
		Timestamp resvTime = null;
		AuthInfo ret = null;
		Calendar cal = Calendar.getInstance();
		try{
			Statement st = con.createStatement();
			ResultSet rs;
			ParkingLot lot = getLotInfo(lotID);
			st.executeUpdate("update parking_lot set validSpace="+(lot.getValidSpace()-1)+" where parkingLotID="+lotID+";");
			st.executeUpdate("insert into reservation (parkingLotID, userID, expired) value ('"+lotID+"', '"+userID+"', 'false');",Statement.RETURN_GENERATED_KEYS);
			rs = st.getGeneratedKeys();
			String reservationID = null;
			while(rs.next()){
				reservationID = rs.getString(1);
			}
			System.out.println("resvID : "+reservationID);
			authKey = keyGenerator();
			st.executeUpdate("insert into authkey (authKey, reservationID) value("+authKey+","+reservationID+");");
			rs = st.executeQuery("select timestamp from reservation where reservationID="+reservationID+";");
			while(rs.next()){
				resvTime = rs.getTimestamp(1, cal);
			}
			ret = new AuthInfo(cal,authKey);
		}
		finally {
			con.close();
		}
		return ret;
	}
	
	public static void cancelReservation(String userID) throws SQLException, IOException{
		Connection con = getConnection();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select reservationID from reservation where userID='"+userID+"';");
			String resvID = null;
			while(rs.next()){
				resvID = rs.getString(1);
			}
			if(resvID!=null){
				st.executeUpdate("delete from reservation where reservationID="+resvID+";");
				st.executeUpdate("delete from authkey where reservationID="+resvID+";");
			}
		}
		finally {
			con.close();
		}
	}
	
	public static AuthInfo checkResv(String userID) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		String authKey = null;
		Timestamp resvTime = null;
		AuthInfo ret = null;
		Calendar cal = Calendar.getInstance();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select timestamp, authKey from authkey, reservation where userID='"+userID+"';");
			while(rs.next()){
				resvTime = rs.getTimestamp(1, cal);
				authKey = rs.getString(2);
			}
			if(authKey!=null){
				ret = new AuthInfo(cal,authKey);
			}
		}
		finally {
			con.close();
		}
		return ret;
	}
	

	public static boolean checkPW(String pw) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		boolean ret = false;
		String resvID = null;
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select reservationID from authkey where authKey='"+pw+"';");
			while(rs.next()){
				resvID = rs.getString(1);
			}
			if(resvID!=null){
				ret=true;
			}
		}
		finally {
			con.close();
		}
		return ret;
	}
	
	public static Connection getConnection() throws SQLException, IOException {
		String url = "jdbc:mysql://localhost:3306/smartparking?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "asdf1234";
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, username, password);
	}

	public static void updateMote(String moteID, boolean status) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		String res = null;
		boolean exStatus = false;
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select status from parking_space where parkingSpaceID='"+moteID+"';");
			while(rs.next()){
				res = rs.getString(1);
			}
			if(res != null){
				exStatus = res.equals("true");
				if(exStatus && !status){
					st.executeUpdate("update parking_space set status='false' where parkingSpaceID='"+moteID+"'");
					rs = st.executeQuery("select reservationID from reservation,parking_space where parking_space.parkingSpaceID='"+moteID+"' and parking_space.parkingLotID=reservation.parkingLotID;");
					String resvID = null;
					if(rs.next()){
						resvID = rs.getString(1);
					}
					if(resvID == null) return;
					st.executeUpdate("insert into occupy(enterTime,userID)select (timestamp,userID) from reservation where reservationID="+resvID+"';",Statement.RETURN_GENERATED_KEYS);
					rs = st.getGeneratedKeys();
					String id=null;
					if(rs.next()){
						id = rs.getString(1);
					}
					if(id==null) System.out.println("id=null");
					st.executeUpdate("update occupy set parkingSpaceID ='"+moteID+"' where _ID='"+id+"';");
					st.executeUpdate("delete from reservation where reservationID="+resvID+";");
					st.executeUpdate("delete from authkey where reservationID="+resvID+";");
				}else if(!exStatus && status){
					st.executeUpdate("update parking_space set status='true' where parkingSpaceID='"+moteID+"'");
					
				}
			}
		}
		finally {
			con.close();
		}
	}

	public static ParkingLot getLotLoc(String authKey) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select latitude, longitude from parking_lot, authkey,reservation where authkey.authKey='"+authKey+"' and authkey.reservationID=reservation.reservationID and reservation.parkingLotID=parking_lot.parkingLotID");
			while(rs.next()){
				return new ParkingLot(rs.getString(1),rs.getString(2),0	,"",0);
			}
		}
		finally {
			con.close();
		}
		return null;
	}


	
	
	
}

