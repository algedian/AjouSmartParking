package smartparking;

import java.util.Calendar;

public class AuthInfo {
	public Calendar cal;
	private String authKey;
	
	public AuthInfo(Calendar cal, String authKey){
		this.cal = cal;
		this.authKey = authKey;
	}
	
	public Calendar getCal() {
		return cal;
	}
	public void setCal(Calendar cal) {
		this.cal = cal;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	
}
