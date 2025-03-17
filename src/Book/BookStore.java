package Book;

import java.util.*;
import java.io.*;

public class BookStore {
   
   private File file=new File("../LibraryApp/src/책 정보.txt");
   
   public BookStore(Vector<Book>bookList) {
      try {
         FileWriter ft=new FileWriter(file);
         for(int i=0;i<bookList.size();i++) {
            ft.write(bookList.get(i).getBookTitle()+"\n");
            ft.write(bookList.get(i).getBookAuthor()+"\n");
            ft.write(bookList.get(i).getBookPublisher()+"\n");
            ft.write(Boolean.toString(bookList.get(i).getBorrow())+"\n");
            ft.write(bookList.get(i).getId()+"\n");
            ft.write(Integer.toString(bookList.get(i).getBorrowTime())+"\n");
            //대출 날짜 넣기
			ft.write(bookList.get(i).getBorrowDate().get(Calendar.YEAR) + "\n");
			ft.write(bookList.get(i).getBorrowDate().get(Calendar.MONTH) + 1 + "\n");
			ft.write(bookList.get(i).getBorrowDate().get(Calendar.DATE) + "\n");
			//
            
         }
         ft.close();
      }catch(IOException e) {
         e.printStackTrace();
      }
   }
}

