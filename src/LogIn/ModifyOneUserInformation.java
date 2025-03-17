package LogIn;

import java.util.Vector;

import GUI.ErrorFrame;

import java.io.*;

public class ModifyOneUserInformation {
	private Vector<UserInformation> list= new UserInformationRead().userInformationRead();
	private UserInformation ui;
	
	public ModifyOneUserInformation(UserInformation ui) {
		this.ui = ui;
	}
	
	public void modifyOneUserInformation() {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(ui.getId()))
				list.set(i, ui);
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
