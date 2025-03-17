package GUI;

import Book.*;
import Manager.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBook extends JFrame{
	private Book book=new Book();
	
	public AddBook() {
		setTitle("책 추가하기");
		setLocation(635,280);
		Container c=getContentPane();
		c.setLayout(null);
		
		//폰트 설정
		Font font=new Font("Agency FB 보통",Font.BOLD,15);
		
		//책 이름 라벨
		JLabel bookName=new JLabel("책 이름");
		bookName.setLocation(10,0);
		bookName.setSize(70,100);
		bookName.setFont(font);
		c.add(bookName);
		
		//저자 이름 라벨
		JLabel bookAuthor=new JLabel("저자");
		bookAuthor.setLocation(10,50);
		bookAuthor.setSize(50,100);
		bookAuthor.setFont(font);
		c.add(bookAuthor);
		
		//출판사 이름 라벨
		JLabel bookPublisher=new JLabel("출판사");
		bookPublisher.setLocation(10,100);
		bookPublisher.setSize(50,100);
		bookPublisher.setFont(font);
		c.add(bookPublisher);
		
		//책 이름 텍스트필드
		JTextField getBookName=new JTextField(20);
		getBookName.setLocation(110,35);
		getBookName.setSize(250,30);
		c.add(getBookName);
		
		//저자 이름 텍스트필드
		JTextField getBookAuthor=new JTextField(20);
		getBookAuthor.setLocation(110,85);
		getBookAuthor.setSize(250,30);
		c.add(getBookAuthor);
		
		//출판사 이름 텍스트필드
		JTextField getBookPublisher=new JTextField(20);
		getBookPublisher.setLocation(110,135);
		getBookPublisher.setSize(250,30);
		c.add(getBookPublisher);
		
		//취소 버튼 구현
		JButton cancel = new JButton("취소");
		cancel.setSize(100,30);
		cancel.setLocation(70,210);
		c.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();new ManagerMain();
			}
		});
		
		//추가 버튼 구현
		JButton add = new JButton("추가");
		add.setSize(100,30);
		add.setLocation(220,210);
		c.add(add);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bn=getBookName.getText();
				book.setBookTitle(bn);
				String b1=getBookAuthor.getText();
				book.setBookAuthor(b1);
				String b2=getBookPublisher.getText();
				book.setBookPublisher(b2);

				if(bn.length()>=1&&b1.length()>=1&&b2.length()>=1) {
					dispose();
					new BookAdd(book);
					new ManagerMain();
					new SuccessFrame("추가 성공","책 추가를 성공하였습니다.",45);
					
				}
				else {
					new ErrorFrame("추가 실패", "내용을 입력해주세요.", 58);
				}
			}
		});
		
		setSize(400,300);
		setVisible(true);
	}
}

class pop extends JFrame{
	public pop(String label) {
		Container c=getContentPane();
		c.setLayout(null);
		Font font=new Font("Agency FB 보통",Font.BOLD,13);
		
		JLabel jl=new JLabel(label);
		jl.setLocation(40,50);
		jl.setSize(100,50);
		jl.setFont(font);
		c.add(jl);
		
		JButton check = new JButton("확인");
		check.setSize(100,30);
		check.setLocation(40,130);
		c.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setSize(200,200);
		setVisible(true);
	}
}