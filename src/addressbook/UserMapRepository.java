package addressbook;

import java.util.List;

public interface UserMapRepository {
	
	public void addFriend(int logedUserID, int friendUserID);
	
	public void deleteFriend(int logedUserID, int friendUserID);
	
	public List<User> getMyFriendsList(int logedUserID);
	
	public List<User> getIAmFriendForList(int logedUserID);
	
}
