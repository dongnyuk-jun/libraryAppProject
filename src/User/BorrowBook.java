package User;

import Book.*;
import java.util.*;

public class BorrowBook {
   public BorrowBook(Vector<Book>bookList,int number,String id){
      bookList.get(number).setBorrow(true);
      bookList.get(number).setId(id);
      int count=bookList.get(number).getBorrowTime()+1;
      bookList.get(number).setborrowTime(count);
      //대출 날짜 추가
      bookList.get(number).setBorrowDate(Calendar.getInstance());
      
      new BookStore(bookList);
   }
}
