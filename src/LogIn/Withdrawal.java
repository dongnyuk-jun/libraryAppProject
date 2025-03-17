package LogIn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import GUI.ErrorFrame;

public class Withdrawal {
	private Vector<UserInformation> list= new UserInformationRead().userInformationRead();
	private UserInformation ui;
	
	public Withdrawal(UserInformation ui) {
		this.ui = ui;
	}
	
	public void withdrawal() {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(ui.getId()))
				list.remove(i);
		}
		File file = new File("../LibraryApp/src/회원 정보.txt");
		try {
			FileWriter filewriter = new FileWriter(file,false);
			if(file.isFile() && file.canWrite()) {
				for(int i=0; i<list.size(); i++) {
					filewriter.append(list.get(i).getId());
					filewriter.append(" ");
					filewriter.append(list.get(i).getPassword());
					filewriter.append(" ");
					filewriter.append(list.get(i).getName());
					filewriter.append(" ");
					filewriter.append(list.get(i).getPhone());
					filewriter.append("\n");
				}
				filewriter.close();
			}
		}catch(IOException e) {
			new ErrorFrame("파일 열기 실패","파일을 확인해주세요.",15);
		}
	}
	
}
