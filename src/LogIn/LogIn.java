package LogIn;

import java.io.*;
import GUI.ErrorFrame;

public class LogIn {
	private String id;
	private String password;
	
	public LogIn(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	
	public boolean checkLogIn(String faddress) {
		File file = new File(faddress);
		try {
			int pass = 0;
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line;
			String s[];
			
			try {
				while((line = bufReader.readLine())!=null) {
					s = line.split(" ");
					String passId = s[0];
					String passPw = s[1];
					if(passId.equals(id)&&passPw.equals(password)) {
						pass = 1;
						break;
					}
				}
			}catch(IOException e) {
				new ErrorFrame("파일오류","파일을 확인해주세요.",60);
				filereader.close();
				bufReader.close();
				return false;
			}
			if(pass==1) {
				filereader.close();
				bufReader.close();
				return true;
			}
			else {
				filereader.close();
				bufReader.close();
				return false;
			}
		}catch(IOException e) {	
			new ErrorFrame("파일오류","파일을 확인해주세요.",60);
			return false;
		}
   }
}	
