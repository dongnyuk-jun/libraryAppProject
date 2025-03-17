package LogIn;

import java.util.*;
import java.io.*;
import GUI.ErrorFrame;

public class JoinMember {
	public JoinMember() {}
	Scanner scanner = new Scanner(System.in);
	
	public void run(String id, String passWord, String name, String phone) {
	File file = new File("../LibraryApp/src/회원 정보.txt");
	try {
		FileWriter filewriter = new FileWriter(file, true);
		if(file.isFile() && file.canWrite()) {
			filewriter.append(id);
			filewriter.append(" ");
			filewriter.append(passWord);
			filewriter.append(" ");
			filewriter.append(name);
			filewriter.append(" ");
			filewriter.append(phone);
			filewriter.append("\n");
			filewriter.close();
		}
	}catch(IOException e) {
		new ErrorFrame("파일 열기 실패","파일을 확인해주세요.",15);
	}

  }
}