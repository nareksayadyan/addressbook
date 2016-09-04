package addressbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAO implements UserRepository, PhoneRepository, UserMapRepository {
	
	private static DAO instance = null;
	private DAO(){};
	
	public static DAO getInstance() {
		if (instance == null) {
			instance = new DAO();
		}
		return instance;
	}
	
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	private static final String USERS_DB_FILE_HEADER = "userID,userName,password";
//	private static final String PHONE_NUMBER_FILE_HEADER = "numberID,userID,number,numberType";
//	private static final String USER_MAP_FILE_HEADER = "userID,friendUserID";
	
	private static final int USER_ID_IDX = 0;
	private static final int USER_USERNAME_IDX = 1;
	private static final int USER_PASSWORD_IDX = 2;
	
	
	
	
	
	
	
	@Override
	public void addFriend(int logedUserID, int friendUserID) {
		
		//TODO!
		
	}

	@Override
	public void deleteFriend(int logedUserID, int friendUserID) {
		
		//TODO!
		
	}

	@Override
	public List<User> getMyFriendsList(int logedUserID) {
		
		//TODO!
		return null;
	}

	@Override
	public List<User> getIAmFriendForList(int logedUserID) {
		
		//TODO!
		return null;
	}

	@Override
	public void addPhoneNumber(PhoneNumber phoneNumber) {
		
		//TODO!
		
	}

	@Override
	public void deletePhoneNumber(int phoneNumberID) {
		
		//TODO!
		
	}

	@Override
	public List<PhoneNumber> getPhoneNumbersList(int userID) {
		
		//TODO!
		return null;
	}

	@Override
	public void editPhoneNumber(int phoneNumberID, String userID) {
		
		//TODO!
		
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
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		}finally {
			try {
				fw.flush();
				fw.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing FileWriter !!!");
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void editUser(User user) {
		
		//TODO!
		
	}

	@Override
	public void deleteUser(int userID) {
		
		//TODO!
		
	}

	@Override
	public User getUser(int userID) {
		//erevi petq chi
		//TODO!
		return null;
	}
	
	@Override
	public List<User> getUsersList() {
		File file = new File("src//resource//UsersDB.csv");
		BufferedReader br = null;
		List<User> users = new ArrayList<>();
		try {
			String line = "";
			br = new BufferedReader(new FileReader(file));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					User user = new User(tokens[USER_USERNAME_IDX], tokens[USER_PASSWORD_IDX]);
					user.userID = Integer.parseInt(tokens[USER_ID_IDX]);
					users.add(user);
				}
			}
		} catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				System.out.println("Error while closing FileReader !!!");
				e.printStackTrace();
			}
		}
		return users;
	}

	@Override
	public boolean getUser(String userName) {
		
		// TODO!
		return false;
	}
	
}
