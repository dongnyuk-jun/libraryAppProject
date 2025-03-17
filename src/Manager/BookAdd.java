package Manager;

import java.util.*;
import java.io.*;
import Book.*;

public class BookAdd {
	
	public BookAdd(Book book) {
	Scanner scanner = new Scanner(System.in);
	File file = new File("../LibraryApp/src/책 정보.txt");
	try {
		FileWriter filewriter = new FileWriter(file, true);
		if(file.isFile() && file.canWrite()) {
			filewriter.append(book.getBookTitle());
			filewriter.append("\n");
			filewriter.append(book.getBookAuthor());
			filewriter.append("\n");
			filewriter.append(book.getBookPublisher());
			filewriter.append("\n");
			filewriter.append("false");
			filewriter.append("\n");
			filewriter.append("0");
			filewriter.append("\n");
			filewriter.append("0");
			filewriter.append("\n");
			//대출 날짜 추가
			filewriter.append("1");
			filewriter.append("\n");
			filewriter.append("0");
			filewriter.append("\n");
			filewriter.append("1");
			filewriter.append("\n");
			
			filewriter.close();
		}
	}catch(IOException e) {
		System.out.println("파일 입출력 오류");
	}
	scanner.close();
  }
}
