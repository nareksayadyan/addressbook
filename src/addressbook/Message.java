package addressbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Message {
	
	private static Message instance = null;
	
	private Message(){};
	
	public static Message getInstance() {
		if (instance == null) {
			instance = new Message();
		}
		return instance;
	}
	
	String lng = "";
	public Properties messages = new Properties();
	FromConsol fromConsol = FromConsol.getInstance();
	
	public void selectLng() {
		while (!this.lng.equals("armenian") && !this.lng.equals("english")) {
			this.lng = fromConsol.getInput("please select language, write armenian or english __ ");
		}
	}
	
	public String getMessage(String key){
		InputStream inMessages = null;
		inMessages = this.getClass().getClassLoader().getResourceAsStream("resource//messages.properties");
//		inMessages = this.getClass().getClassLoader().getResourceAsStream("resource//" + lng + "_messages.properties");
		try {
			messages.load(inMessages);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return messages.getProperty(this.lng + key);
	}
	
}
