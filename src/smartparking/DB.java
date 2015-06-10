package smartparking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
					"select distinct latitude, longitude, parking_lot.parkingLotID, parking_lot.parkingLotName "
					+ "from parking_lot,parking_space "
					+ "where parking_space.parkingLotID=parking_lot.parkingLotID AND parking_space.status='true';");
			while(rs.next()){
				latitude = rs.getString(1);
				longitude = rs.getString(2);
				lotID = rs.getInt(3);
				name = rs.getString(4);
				list.add(new ParkingLot(latitude, longitude, lotID, name));
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
			
			ResultSet rs = st.executeQuery("SELECT latitude, longitude, parkingLotID, parkingLotName FROM parking_lot "
					+ "where parking_lot.parkingLotID='" + lotID + "';");
			while(rs.next()){
				latitude = rs.getString(1);
				longitude = rs.getString(2);
				tmplotID = rs.getInt(3);
				name = rs.getString(4);
				lot = new ParkingLot(latitude, longitude, tmplotID, name);
			}
			rs.close();
		}
		finally {
			con.close();
		}
		return lot;
	}
	
	
	public static ArrayList<String> getParkingSpace(String lotID) throws SQLException, IOException {
		Connection con = getConnection();
		ArrayList<String> ret = new ArrayList<String>();
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT parkingSpaceID FROM parking_space "
					+ "WHERE parking_space.parkingLotID='" + lotID + "';");			
			while(rs.next()){
				ret.add(rs.getString(1));
			}
			rs.close();
		}
		finally {
			con.close();
		}
		return ret;
	}
	
	/*
	public static void addMusicToServer(String userId, String title, String content) throws SQLException, IOException{
		Connection con = getConnection();
		
		Statement st = con.createStatement();
		
		st.executeUpdate("INSERT INTO music VALUES('0','" + userId 
				+ "', '" + title + "', '" + content + "')");
		
		st.close();
		con.close();
		
	}
	*/
	
	public static Connection getConnection() throws SQLException, IOException {
		String url = "jdbc:mysql://localhost:3306/smartparking?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "webclass";
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, username, password);
	}
	
	
}

