package addressbook;

public class PhoneNumber {
	
	private static int id = 999;
	
	private int numberID;
	private String number;
	private NumberType numberType;

	public PhoneNumber(String number, String type) {
		setNumberID();
		setNumber(number);
		setNumberType(type);
	}
		
	private void setNumberID() {
		this.numberID = id + 1;
		id++;
	}
	
	public int getNumberID() {
		return this.numberID;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber(){
		return this.number;
	}
	
	public void setNumberType(String type) {
		this.numberType = NumberType.valueOf(type);
	}
	
	public NumberType getNumberType(){
		return this.numberType;
	}
	
}
