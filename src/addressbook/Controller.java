package addressbook;

import java.util.List;

public class Controller {
	
	static User logedOnUser;
	static int badUserCount;
	
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
				break;
				
			case "Sign In":
				signIn();
				break;
				
			case "Help":
//				startHelp();
				break;
				
			default:
				System.out.println("ssss");
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
				
			case "Help":
//				userProgramHelp();
				break;
				
			default:
				input = fromConsol.getInput(msg.getMessage("Invalid.Command"));
				break;
			}
			
		}
		
	}
	
/**
 * Done!
 */
	public void signUp() {
		String inputedUserName;
		inputedUserName = fromConsol.getInput("Please provide your username > ");
		for (User tmpUser : dao.getUsersList()) {

			while (inputedUserName.equals(tmpUser.getUserName())) {
				inputedUserName = fromConsol.getInput("Please provide your username >");
			}
			
		}
		
		String inputedPassword;
		inputedPassword = fromConsol.getInput("Please provide your password > ");
		User user = new User(inputedUserName, inputedPassword);
		dao.addUser(user);
	}
	
	public void signIn() {
		
		
		
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
