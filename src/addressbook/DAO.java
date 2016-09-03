package addressbook;

import java.util.ArrayList;
import java.util.List;

public class DAO implements UserRepository, PhoneRepository, UserMapRepository {
	
	private static DAO instance = new DAO();
	private DAO(){};
	
	public static DAO getInstance() {
		return instance;
	}

	@Override
	public void addFriend(int logedUserID, int friendUserID) {
		
		
	}

	@Override
	public void deleteFriend(int logedUserID, int friendUserID) {
		
		
	}

	@Override
	public List<User> getMyFriendsList(int logedUserID) {
		
		return null;
	}

	@Override
	public List<User> getIAmFriendForList(int logedUserID) {
		
		return null;
	}

	@Override
	public void addPhoneNumber(PhoneNumber phoneNumber) {
		
		
	}

	@Override
	public void deletePhoneNumber(int phoneNumberID) {
		
		
	}

	@Override
	public List<PhoneNumber> getPhoneNumbersList(int userID) {
		
		return null;
	}

	@Override
	public void editPhoneNumber(int phoneNumberID) {
		
		
	}

	@Override
	public void addUser(User user) {
		
		
	}

	@Override
	public void deleteUser(int userID) {
		
		
	}

	@Override
	public User getUser(String userName, String password) {
		
		return null;
	}

	@Override
	public List<User> getUsersList() {
		List<User> users = new ArrayList<>();
		
		return users;
	}

	@Override
	public void editUser(User user) {
		
		
	}
	
}
