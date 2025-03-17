package Book;
import java.util.Calendar;

public class Book {
   private String bookTitle;
   private String bookAuthor;
   private String publisher;
   private boolean borrow;
   private String id;
   private int borrowTime;
   private Calendar borrowDate;
   private Calendar returnDate;
   
   public void setBookTitle(String bookTitle) {
      this.bookTitle = bookTitle;
   }
   
   public void setBookAuthor(String bookAuthor) {
      this.bookAuthor = bookAuthor;
   }
   
   public void setBookPublisher(String publisher) {
      this.publisher = publisher;
   }
   
   public void setBorrow(boolean borrow) {
      this.borrow = borrow;
   }
   
   public void setId(String id2) {
      this.id = id2;
   }

   public void setborrowTime(int borrowTime) {
      this.borrowTime=borrowTime;
   }
   
   public void setBorrowDate(Calendar borrowDate) {
	   this.borrowDate = borrowDate;
	   if(borrowDate.get(Calendar.YEAR) == 1)
		   this.borrowDate.set(1, 0, 1);
	   setReturnDate(this.borrowDate);
   }
   public void setReturnDate(Calendar borrowDate) {
	   returnDate = Calendar.getInstance();
	   returnDate.set(borrowDate.get(Calendar.YEAR), borrowDate.get(Calendar.MONTH), borrowDate.get(Calendar.DATE));
	   returnDate.set(Calendar.DATE, returnDate.get(Calendar.DATE) + 14);
   }
  
   public void extendReturn() {
	   returnDate.set(Calendar.DATE, returnDate.get(Calendar.DATE) + 7);
   }
   public String getBookTitle() {
      return bookTitle;
   }
   
   public String getBookAuthor() {
      return bookAuthor;
   }
   
   public String getBookPublisher() {
      return publisher;
   }
   
   public String getId() {
      return id;
   }
   
   public boolean getBorrow() {
      return borrow;
   }
   
   public int getBorrowTime() {
      return borrowTime;
   }
   
   public Calendar getBorrowDate() {
	   return borrowDate;
   } 
   
   public Calendar getReturnDate() {
	   return returnDate;
   }
}