package User;

import Book.*;
import java.util.*;

public class ReturnBook {
	public ReturnBook(Vector<Book>bookList, int number) {
		bookList.get(number).setBorrow(false);
		bookList.get(number).setId("0");
		//대출날짜, 반납날짜 없애기
		Calendar now = Calendar.getInstance();
		now.set(1, 0, 1);
		bookList.get(number).setBorrowDate(now);
		
		new BookStore(bookList);
	}
}
