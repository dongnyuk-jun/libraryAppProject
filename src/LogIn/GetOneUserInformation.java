package LogIn;

import java.util.Vector;

public class GetOneUserInformation {
	private Vector<UserInformation> list= new UserInformationRead().userInformationRead();
	
	public UserInformation getUserInformation(String id) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getId().equals(id))
				return list.get(i);
		}
		return null;
	}
}
