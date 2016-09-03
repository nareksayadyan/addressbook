package addressbook;

import java.util.List;

public interface UserRepository {
	
	public void addUser(User user);
	
	public void deleteUser(int userID);
	
	public User getUser(int userID);
	
	public List<User> getUsersList();
	
	public void editUser(User user);
	
}
