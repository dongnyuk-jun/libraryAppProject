package User;

import java.util.*;
import Book.*;
import LogIn.UserInformation;

public class BorrowCheck {
	private UserInformation ui;
	private Vector<Book> bookList;
	
	public BorrowCheck(Vector<Book> bookList ,UserInformation ui) {
		this.bookList = bookList;
		this.ui = ui;
	}
	
	public boolean borrowCheck() {
		for(int i=0; i<bookList.size(); i++) {
			if(bookList.get(i).getId().equals(ui.getId()))
				return false;	
		}
		return true;
	}
}
