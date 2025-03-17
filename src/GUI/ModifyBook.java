package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import Book.*;
import Manager.*;

public class ModifyBook extends JFrame
{
	private JPanel modifyPanel;
	
	private JLabel title;
	private JLabel author;
	private JLabel publisher;
	
	private JTextField titleField;
	private JTextField authorField;
	private JTextField publisherField;
	
	private JButton cancelBtn;
	private JButton modifyBtn;
	
	public ModifyBook(Vector<Book>bookList,int row)
	{
		setTitle("책 수정하기");
		
		Container c = getContentPane();
		
		modifyPanel = new JPanel();
		c.add(modifyPanel);
		modifyPanel.setSize(550, 550);
		modifyPanel.setLayout(null);
		
		title = new JLabel("제목");
		author = new JLabel("저자");
		publisher = new JLabel("출판사");
		
		title.setBounds(70, 50, 80, 30);
		author.setBounds(70, 150, 50, 30);
		publisher.setBounds(70, 250, 50, 30);
		
		titleField = new JTextField(bookList.get(row).getBookTitle());
		authorField = new JTextField(bookList.get(row).getBookAuthor());
		publisherField = new JTextField(bookList.get(row).getBookPublisher());
		
		titleField.setBounds(130, 50, 300, 30);
		authorField.setBounds(130, 150, 300, 30);
		publisherField.setBounds(130, 250, 300, 30);
		
		modifyPanel.add(title);
		modifyPanel.add(author);
		modifyPanel.add(publisher);
		
		modifyPanel.add(titleField);
		modifyPanel.add(authorField);
		modifyPanel.add(publisherField);
		
		cancelBtn = new JButton("취소");
		modifyBtn = new JButton("수정");
		
		cancelBtn.setBounds(70, 450, 60, 30);
		modifyBtn.setBounds(370, 450, 60, 30);
		
		modifyPanel.add(cancelBtn);
		modifyPanel.add(modifyBtn);
		
		cancelBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new ManagerMain();
			}
		});
		
		modifyBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Book afterBook = new Book();
				
				afterBook.setBookTitle(titleField.getText());
				afterBook.setBookAuthor(authorField.getText());
				afterBook.setBookPublisher(publisherField.getText());
				
				
				dispose();
				new BookModify(bookList, afterBook, row);
				
				new ManagerMain();
				new SuccessFrame("수정 성공","수정되었습니다.",80);
			}
		});
		
		setVisible(true);
		setSize(600, 600);
	}
}