package addressbook;

import java.util.List;

public class Controller {
	
	static User logedOnUser;
	
	private boolean runAddressBook;
	private boolean runUserProgram;
	
	FromConsol fromConsol = FromConsol.getInstance();
	DAO dao = DAO.getInstance();
	Message msg = Message.getInstance();
	
	public void start(boolean start) {
		runAddressBook = start;
		String input;
		msg.selectLng();
		input = fromConsol.getInput(msg.getMessage(".S.I.or.S.U"));
		while (runAddressBook) {
			
			switch (input) {
			
			case "Sign Up":
				signUp();
				input = fromConsol.getInput(msg.getMessage(".Successfully.S.U"));
				break;
				
			case "Sign In":
				signIn();
				userProgram(true);
				break;
				
			case "Exit":
				System.exit(0);
				break;
				
			case "Help":
				System.out.println(msg.getMessage("Start." + input));
				break;
				
			default:
				input = fromConsol.getInput(msg.getMessage(".Invalid.Command"));
				break;
			}
			
		}
		
	}
	
	public void userProgram(boolean start) {
		runUserProgram = start;
		String input;
		input = fromConsol.getInput("");
		while (runUserProgram) {
			
			input = fromConsol.getInput("");
			
			switch (input) {
			
			case "Sign Out":
				msg.lng = "";
				start(true);
				break;
				
			case "Add Number":
				addNumber();
				break;
				
			case "Show Numbers":
				showNumbers();
				break;
				
			case "Add Friend":
				addFriend();
				break;
				
			case "Delete Friend":
				deleteFriend();
				break;
				
			case "Show Friends":
				showFriends();
				break;
				
			case "Exit":
				System.exit(0);
				break;
				
			case "Help":
				System.out.println(msg.getMessage("User.Program." + input));
				break;
				
			default:
				input = fromConsol.getInput(msg.getMessage(".Invalid.Command"));
				break;
			}
			
		}
		
	}
	
/**
 * Done!
 */
	public void signUp() {
		String inputedUserName;
		inputedUserName = fromConsol.getInput(msg.getMessage(".Input.UserName"));
		
		while (checkUserName(inputedUserName)) {
			System.out.println(msg.getMessage(".UserName.Used"));
			inputedUserName = fromConsol.getInput(msg.getMessage(".Input.UserName"));
		}
		String inputedPassword;
		inputedPassword = encriptPassword(fromConsol.getInput(msg.getMessage(".Input.Password > ")));
		
		User user = new User(inputedUserName, inputedPassword);
		dao.addUser(user);
	}

/**
 * Done!
 */
	public boolean checkUserName(String userName) {
		boolean used = false;
		List<User> users = dao.getUsersList();
		
		for (User tempUser : users) {
			if (userName.equals(tempUser.getUserName())) {
				return used = true;
			} 
		}
		return used;
	}
	
	public String encriptPassword(String password) {
		String p = password;
		
		
		
		
		return p;
	}

/**
 * Done!
 */
	public void signIn() {
		int badUserCount = 1;
		boolean login = false;
		List<User> users = dao.getUsersList();
		
		String inputedUserName;
		String inputedPassword;
		
		inputedUserName = fromConsol.getInput(msg.getMessage(".Input.UserName"));
		inputedPassword = encriptPassword(fromConsol.getInput(msg.getMessage(".Input.Password")));
		
		while (!login) {
			badUserCount++;
			if (badUserCount == 3){
				System.exit(0);
			}
			for (User tmpUser : users) {
				if (inputedUserName.equals(tmpUser.getUserName()) && inputedPassword.equals(tmpUser.getPassword())) {
					login = true;
				}
			}
			inputedUserName = fromConsol.getInput(msg.getMessage(".Input.UserName"));
			inputedPassword = encriptPassword(fromConsol.getInput(msg.getMessage(".Input.Password")));
		}
		
		logedOnUser = dao.getUser(inputedUserName, inputedPassword);
	}

	public void addNumber() {
		
		
	}

/**
 * Done!
 */
	@SuppressWarnings("null")
	public void showNumbers() {
		List<PhoneNumber> myNumbers = null;
		
		myNumbers.addAll(dao.getPhoneNumbersList(logedOnUser.getUserID()));
		
		for (User tmpUser : dao.getIAmFriendForList(logedOnUser.getUserID())) {
			myNumbers.addAll(dao.getPhoneNumbersList(tmpUser.getUserID()));	
		}
		
		for (PhoneNumber tmpPhoneNumber : myNumbers) {
			System.out.println(tmpPhoneNumber.getNumberType() + " __ " + tmpPhoneNumber.getNumber());
		}
		
//		for (PhoneNumber tmpPhoneNumber : dao.getPhoneNumbers(logedOnUser.getUserID())) {
//			System.out.println(tmpPhoneNumber.getNumberType() + " __ " + tmpPhoneNumber.getNumber());
//		}
//		
//		for (User tmpUser : dao.getIAmFriendFor(logedOnUser.getUserID())) {
//			
//			for (PhoneNumber tmpPhoneNumber : dao.getPhoneNumbers(tmpUser.getUserID())) {
//				System.out.println(tmpPhoneNumber.getNumberType() + " __ " + tmpPhoneNumber.getNumber());
//			}
//			
//		}
		
	}

	public void addFriend() {
		
		
	}

	public void deleteFriend() {
		
		
	}
	
	public void showFriends() {
		
		
	}
}
