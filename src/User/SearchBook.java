package User;

import Book.*;
import java.util.*;

public class SearchBook
{
	private int type;	//0제목, 1저자, 2출판사
	private String searchValue;
	private Vector<Book> searchList = new Vector<Book>();
	private Vector<Book> bookList;
	
	public SearchBook(int type, String searchValue, Vector<Book> bookList)
	{
		this.type = type;
		this.searchValue = searchValue;
		this.bookList = bookList;
	}
	
	public Vector<Book> bookSearch()
	{
		for(int i = 0; i < bookList.size(); i++)
		{
			if(type == 0 && bookList.get(i).getBookTitle().contains(searchValue))
				searchList.add(bookList.get(i));
			else if(type == 1 && bookList.get(i).getBookAuthor().contains(searchValue))
				searchList.add(bookList.get(i));
			else if(type == 2 && bookList.get(i).getBookPublisher().contains(searchValue))
				searchList.add(bookList.get(i));
		}
		
		return searchList;
	}
}