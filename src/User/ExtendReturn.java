package User;

import Book.*;
import java.util.*;

public class ExtendReturn {
   public ExtendReturn(Vector<Book>bookList,int number){
      bookList.get(number).extendReturn();
      
      new BookStore(bookList);
   }
}