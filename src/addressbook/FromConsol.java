package addressbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FromConsol {
	
	private static FromConsol instance = null;
	private FromConsol(){};
	
	public static FromConsol getInstance() {
		if (instance == null) {
			instance = new FromConsol();
		}
		return instance;
	}
	
	public String getInput(String masage) {
		String string = null;
		System.out.print(masage);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			string = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return string;
	}
	
}
