package Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BookRead {   
   private File file;
   private FileReader fileReader;
   private BufferedReader bufReader;
   private int year;
   private int month;
   private int date;
   
   public Vector<Book> bookRead() {
      Vector<Book>bookList=new Vector<Book>();
      
      try {         
         file=new File("../LibraryApp/src/책 정보.txt");
         fileReader=new FileReader(file);
         bufReader=new BufferedReader(fileReader);
         String line;
         try {
            while(true) {
               Book book=new Book();
               line = bufReader.readLine();
               if(line==null) {
                  break;
               }
               book.setBookTitle(line);
               line = bufReader.readLine();
               book.setBookAuthor(line);
               line = bufReader.readLine();
               book.setBookPublisher(line);
               line = bufReader.readLine();
               book.setBorrow(Boolean.parseBoolean(line));
               line = bufReader.readLine();
               book.setId(line);
               line = bufReader.readLine();
               book.setborrowTime(Integer.parseInt(line));
               //대출날짜 넣기
               line = bufReader.readLine();
               year = Integer.parseInt(line);
               line = bufReader.readLine();
               month = Integer.parseInt(line);
               line = bufReader.readLine();
               date = Integer.parseInt(line);
               Calendar now = Calendar.getInstance();
               if(year == 1)
            	   now.set(1, 0, 1);
               else
            	   now.set(year, month - 1, date);
               book.setBorrowDate(now);
               //

               //line = bufReader.readLine();
               
               bookList.add(book);
            }
            fileReader.close();
            bufReader.close();
         }catch(IOException e) {
            fileReader.close();
            bufReader.close();
         }
      }catch(IOException e) {
         System.out.println("파일 열기 실패");
      }
      bookList=new BookSort().sort(bookList);
      return bookList;
   }
}

class BookSort {
   public Vector<Book> sort(Vector<Book> book) {
      Book tmpBook=new Book();
      for(int i=1;i<book.size();i++) {
         for(int j=0;j<book.size()-1;j++) {
            if(book.get(j).getBorrowTime()<book.get(j+1).getBorrowTime()) {
               tmpBook=book.get(j);
               book.set(j, book.get(j+1));
               book.set(j+1, tmpBook);
            }
         }
      }
      return book;
   }
}