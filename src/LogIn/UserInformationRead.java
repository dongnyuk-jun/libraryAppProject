package LogIn;

import GUI.ErrorFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class UserInformationRead {
	Vector<UserInformation> v = new Vector<>();
	public Vector<UserInformation> userInformationRead() {
		File file = new File("../LibraryApp/src/회원 정보.txt");
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line;
			try {
				while((line = bufReader.readLine())!=null) {
					String s[]=line.split(" ");
					UserInformation ui = new UserInformation();
					ui.setId(s[0]);
					ui.setPassword(s[1]);
					ui.setName(s[2]);
					ui.setPhone(s[3]);
					v.add(ui);
				}
				filereader.close();
				bufReader.close();
			}catch(IOException e) {
				filereader.close();
				bufReader.close();
			}
		}catch(IOException e) {
			new ErrorFrame("파일 오류", "파일을 확인해주세요.", 60);
		}
	
		return v;
	}
}
