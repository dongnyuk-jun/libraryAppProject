package Manager;

import Book.*;
import java.util.*;

public class BookModify
{
	public BookModify(Vector<Book>bookList, Book afterBook, int row)
	{
		bookList.get(row).setBookTitle(afterBook.getBookTitle());
		bookList.get(row).setBookAuthor(afterBook.getBookAuthor());
		bookList.get(row).setBookPublisher(afterBook.getBookPublisher());
		new BookStore(bookList);
	}
}