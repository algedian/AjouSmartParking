package smartparking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB {
	public static String getUserPw(String id) throws SQLException, IOException {
		Connection con = getConnection();
		String pw = null;
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT password FROM user WHERE user.ID='" + id + "';");			
			while(rs.next())
				pw = rs.getString(1);
			rs.close();
		}
		finally {
			con.close();
		}
		return pw;
	}
	
	public static boolean addUserInfo(String id, String pw) throws SQLException, IOException {
		Connection con = getConnection();
		boolean res = false;
		try {
			Statement st = con.createStatement();
			String dbid = null;
			
			ResultSet rs = st.executeQuery("SELECT ID FROM user WHERE user.ID='" + id + "';");
			while(rs.next())
				dbid = rs.getString(1);
			
			System.out.println("dbid : " + dbid);
			if(dbid == null || dbid.equals("")){
				st.executeUpdate("INSERT INTO user VALUES('" + id + "','" + pw + "')");
				res = true;
			}
			st.close();
		}
		finally {
			con.close();
		}
		return res;
	}
	
	/*
	public static ArrayList<MusicPair> getMusicNameList(String userID) throws SQLException, IOException {
		Connection con = getConnection();
		ArrayList<MusicPair> list = new ArrayList<MusicPair>();
		String str = null;
		int id = 0;
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT title, musicID FROM music WHERE music.userID='" + userID + "';");	//문법 확인	
			while(rs.next()){
				str = rs.getString(1);
				id = rs.getInt(2);
				list.add(new MusicPair(str, id));
				//System.out.println("str : " + str + ", id : " + id);
			}
			rs.close();
		}
		finally {
			con.close();
		}
		return list;
	}
	*/
	
	public static String getMusicContent(String musicID) throws SQLException, IOException {
		Connection con = getConnection();
		String content = null;
		try {
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT content FROM music "
					+ "WHERE music.musicID='" + musicID + "';");			
			while(rs.next())
				content = rs.getString(1);
			rs.close();
		}
		finally {
			con.close();
		}
		return content;
	}
	
	public static void addMusicToServer(String userId, String title, String content) throws SQLException, IOException{
		Connection con = getConnection();
		
		Statement st = con.createStatement();
		
		st.executeUpdate("INSERT INTO music VALUES('0','" + userId 
				+ "', '" + title + "', '" + content + "')");
		
		st.close();
		con.close();
		
	}
	
	public static Connection getConnection() throws SQLException, IOException {
		String drivers = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/wmc?useUnicode=true&characterEncoding=UTF-8";
		String username = "root";
		String password = "webclass";
		System.setProperty("jdbc.drivers", drivers);
		return DriverManager.getConnection(url, username, password);
	}
	
	
}

