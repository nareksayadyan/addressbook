package addressbook;

import java.util.List;

public class Controller {
	
	static User logedOnUser;
	
	private boolean runAddressBook;
	private boolean runUserProgram;
	
	FromConsol fromConsol = FromConsol.getInstance();
	DAO dao = DAO.getInstance();
	Masage msg = Masage.getInstance();
	
	public void start(boolean start) {
		runAddressBook = start;
		while (runAddressBook) {
			String input;
			
			input = fromConsol.getInput("Please write down one of this commands Sign In or Sign Up __ ");
			
			switch (input) {
			
			case "Sign Up":
				signUp();
				break;
				
			case "Sign In":
				signIn();
				break;
				
			case "Help":
				msg.startHelp();
				break;
				
			default:
				System.out.println("Invalid command. Please write < Help > command for see command list __ ");
				break;
			}
			
		}
		
	}
	
	public void userProgram(boolean start) {
		runUserProgram = start;
		String input;
		while (runUserProgram) {
			
			input = fromConsol.getInput("Now you can write down one of this commands < Add Tel. Number > or < Show Tel. Numbers > __ ");
			
			switch (input) {
			
			case "Sign Out":
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
				msg.userProgramHelp();
				break;
				
			default:
				System.out.println("Invalid command. Please write < Help > command for see command list __ ");
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
