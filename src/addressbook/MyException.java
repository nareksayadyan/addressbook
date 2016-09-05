package addressbook;

import java.io.IOException;

public class MyException extends IOException {
	
	private static final long serialVersionUID = 4713910484958601732L;
	
	public MyException(String e) {
		super(e);
//		System.out.println(e + "\n");
//		printStackTrace();		
	}
	
}
