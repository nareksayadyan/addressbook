package addressbook;

import java.util.List;

public interface PhoneRepository {
	
	public void addPhoneNumber(PhoneNumber phoneNumber);
	
	public void deletePhoneNumber(int phoneNumberID);
	
	public List<PhoneNumber> getPhoneNumbersList(int userID);
	
	public void  editPhoneNumber(int phoneNumberID, String userID);

}
