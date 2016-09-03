package addressbook;

public class User {
	
	private static int id = 99;

	public User() {
		
	}
	
	public User(String userName, String password) {
		setUserID();
		setUserName(userName);
		setPassword(password);
	}
	
	private int userID;
	private String userName;
	private String password;
	
	private void setUserID() {
		this.userID = id + 1;
		id++;
	}

	public int getUserID() {
		return this.userID;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
}
