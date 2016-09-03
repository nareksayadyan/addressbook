package addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAO implements UserRepository, PhoneRepository, UserMapRepository {
	
	private static DAO instance = new DAO();
	private DAO(){};
	
	public static DAO getInstance() {
		return instance;
	}
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String USERS_DB_FILE_HEADER = "userID,userName,password";
	private static final String PHONE_NUMBER_FILE_HEADER = "numberID,userID,number,numberType";
	private static final String USER_MAP_FILE_HEADER = "userID,friendUserID";
	
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
		File file = new File("src//resource//UsersDB.csv");
		FileWriter fw = null;
		
		try {
			if (file.createNewFile()) {
				fw = new FileWriter(file, true);
				fw.append(USERS_DB_FILE_HEADER.toString());
				fw.append(NEW_LINE_SEPARATOR);
			}
			fw = new FileWriter(file, true);
			fw.append(String.valueOf(user.getUserID()));
			fw.append(COMMA_DELIMITER);
			fw.append(user.getUserName());
			fw.append(COMMA_DELIMITER);
			fw.append(user.getPassword());
			fw.append(NEW_LINE_SEPARATOR);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.flush();
				fw.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void deleteUser(int userID) {
		
		
	}

	@Override
	public User getUser(int userID) {
		//erevi petq chi
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
