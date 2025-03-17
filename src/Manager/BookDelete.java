package Manager;

import java.util.*;
import Book.*;

public class BookDelete
{
	public BookDelete(Book book)
	{
		Vector<Book> bookList = new Vector<Book>();
		BookRead br = new BookRead();
		bookList = br.bookRead();
		
		for(int i = 0; i < bookList.size(); i++)
		{
			if(bookList.get(i).getBookTitle().equals(book.getBookTitle()))
			{
				bookList.remove(i);
				break;
			}
		}
		
		new BookStore(bookList);
	}
}