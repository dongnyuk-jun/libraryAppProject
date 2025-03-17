package LogIn;

import java.util.Vector;

public class UserInformationCheck {
	private String userId;
	private Vector<UserInformation> list= new UserInformationRead().userInformationRead();
	
	public UserInformationCheck(String userId) {
		this.userId = userId;
	}
	
	public boolean checking() {

		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(userId))
				return false;
		}
		return true;
	}
}
