package smartparking;

public class User {
	private String name;
	private String userID;
	
	public User(String name, String userID){
		this.name = name;
		this.userID = userID;
	}
	public String getUserID() {
		return userID;
	}
	public String getName() {
		return name;
	}
}
