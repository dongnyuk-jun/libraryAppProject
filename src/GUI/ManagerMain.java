package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Book.*;
import User.*;
import Manager.*;
import java.util.*;
import LogIn.*;

public class ManagerMain extends JFrame
{
	private Vector<Book> bookList = new Vector<Book>();
	private Vector<UserInformation> userList = new Vector<UserInformation>();
	private JTable bookTable;
	private JTable userTable;
	private JScrollPane bookScrollpane;
	private JScrollPane userScrollpane;
	
	JButton bookButton = new JButton("책 정보");
	JButton userButton = new JButton("회원 정보");
	
	JButton addBtn = new JButton("책 추가");
	JButton modifyBtn = new JButton("책 수정");
	JButton deleteBtn = new JButton("책 삭제");
	
	JPanel informPanel = new JPanel(new FlowLayout());
	
	JPanel bookDetailPanel = new JPanel();
	
	JLabel titleLabel = new JLabel("제목");
	JTextField titleField = new JTextField(50);
	JLabel authorLabel = new JLabel("저자");
	JTextField authorField = new JTextField(50);
	JLabel publisherLabel = new JLabel("출판사");
	JTextField publisherField = new JTextField(50);
	JLabel borrowLabel = new JLabel("대출현황");
	JTextField borrowField = new JTextField(50);
	JLabel borrowTimeLabel = new JLabel("대출횟수");
	JTextField borrowTimeField = new JTextField(50);
	JLabel idLabel = new JLabel("학번");
	
	JTextField idField = new JTextField(50);
	
	JPanel userDetailPanel = new JPanel();
	JLabel nameLabel = new JLabel("이름");
	JTextField nameField = new JTextField(50);
	JLabel userIdLabel = new JLabel("학번");
	JTextField userIdField = new JTextField(50);
	JLabel phoneLabel = new JLabel("전화번호");
	JTextField phoneField = new JTextField(50);
	JLabel passwordLabel = new JLabel("비밀번호");
	JTextField passwordField = new JTextField(50);
	

	private JLabel returnLabel;
	private JTextField returnText;
	private JLabel dateLabel;
	private JTextField dateText;
	
	public ManagerMain()
	{
		setTitle("관리자메인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BookRead br = new BookRead();
		bookList = br.bookRead();
		
		//UserInformationRead uir = new UserInformationRead();
		//userList = uir.userInformationRead();
		
		Container c = getContentPane();
		c.setBackground(new Color(244, 255, 255));
		c.setLayout(null);
		
		UserInformationRead uir=new UserInformationRead();
		userList=uir.userInformationRead();
		
		c.add(informPanel);
		informPanel.setBackground(new Color(244, 255, 255));
		informPanel.add(bookButton);
		informPanel.add(userButton);
		
		informPanel.setBounds(20, 0, 500, 40);
		
		c.add(bookDetailPanel);

		bookDetailPanel.setBounds(622, 42, 550, 550);
		bookDetailPanel.setLayout(null);
		
		titleLabel.setBounds(60, 40, 45, 21);
		titleField.setBounds(134, 40, 301, 21);
		titleField.setColumns(10);
		titleField.setEditable(false);
		titleField.setBackground(Color.WHITE);
		bookDetailPanel.add(titleLabel);
		bookDetailPanel.add(titleField);
		
		authorLabel.setBounds(60, 100, 45, 21);
		authorField.setBounds(134, 100, 301, 21);
		authorField.setColumns(10);
		authorField.setEditable(false);
		authorField.setBackground(Color.WHITE);
		bookDetailPanel.add(authorLabel);
		bookDetailPanel.add(authorField);
		
		publisherLabel.setBounds(48, 160, 60, 21);
		publisherField.setBounds(134, 160, 301, 21);
		publisherField.setColumns(10);
		publisherField.setEditable(false);
		publisherField.setBackground(Color.WHITE);
		bookDetailPanel.add(publisherLabel);
		bookDetailPanel.add(publisherField);
		
		borrowLabel.setBounds(35, 220, 87, 21);
		borrowField.setBounds(134, 220, 301, 21);
		borrowField.setColumns(10);
		borrowField.setEditable(false);
		borrowField.setBackground(Color.WHITE);
		bookDetailPanel.add(borrowLabel);
		bookDetailPanel.add(borrowField);
		
		borrowTimeLabel.setBounds(35, 280, 87, 21);
		borrowTimeField.setBounds(134, 280, 301, 21);
		borrowTimeField.setColumns(10);
		borrowTimeField.setEditable(false);
		borrowTimeField.setBackground(Color.WHITE);
		bookDetailPanel.add(borrowTimeLabel);
		bookDetailPanel.add(borrowTimeField);
		
		idLabel.setBounds(60, 340, 45, 21);
		idField.setBounds(134, 340, 301, 21);
		idField.setColumns(10);
		idField.setEditable(false);
		idField.setBackground(Color.WHITE);
		bookDetailPanel.add(idLabel);
		bookDetailPanel.add(idField);
		
		
		bookDetailPanel.setVisible(true);
		bookDetailPanel.setBackground(Color.WHITE);
		
		c.add(userDetailPanel);
		
		userDetailPanel.setLayout(null);
		userDetailPanel.setBackground(Color.WHITE);
		
		nameLabel.setBounds(60, 40, 45, 21);
		nameField.setBounds(134, 40, 301, 21);
		nameField.setColumns(10);
		nameField.setEditable(false);
		nameField.setBackground(Color.WHITE);
		
		userIdLabel.setBounds(60, 100, 45, 21);
		userIdField.setBounds(134, 100, 301, 21);
		userIdField.setColumns(10);
		userIdField.setEditable(false);
		userIdField.setBackground(Color.WHITE);
		
		passwordLabel.setBounds(35, 160, 60, 21);
		passwordField.setBounds(134, 160, 301, 21);
		passwordField.setColumns(10);
		passwordField.setEditable(false);
		passwordField.setBackground(Color.WHITE);
		
		phoneLabel.setBounds(35, 220, 87, 21);
		phoneField.setBounds(134, 220, 301, 21);
		phoneField.setColumns(10);
		phoneField.setEditable(false);
		phoneField.setBackground(Color.WHITE);
		
		userDetailPanel.add(nameLabel);
		userDetailPanel.add(nameField);
		userDetailPanel.add(userIdLabel);
		userDetailPanel.add(userIdField);
		userDetailPanel.add(passwordLabel);
		userDetailPanel.add(passwordField);
		userDetailPanel.add(phoneLabel);
		userDetailPanel.add(phoneField);
		
		////////////////////////////////////////////////////////////
	    dateLabel = new JLabel("대출일");
	    dateLabel.setBounds(35, 400, 87, 21);
	    bookDetailPanel.add(dateLabel);
	    ////////////////////////////////////////////////////////////
	    
	    ////////////////////////////////////////////////////////////
	    dateText = new JTextField();
	    dateText.setEditable(false);
	    dateText.setColumns(10);
	    dateText.setBackground(Color.WHITE);
	    dateText.setBounds(134, 400, 301, 21);
	    bookDetailPanel.add(dateText);
	    ////////////////////////////////////////////////////////////
	      
	    ////////////////////////////////////////////////////////////
	    returnLabel = new JLabel("반납 예정일");
	    returnLabel.setBounds(35, 460, 87, 21);
	    bookDetailPanel.add(returnLabel);
	    ////////////////////////////////////////////////////////////
	      
	    ////////////////////////////////////////////////////////////
	    returnText = new JTextField();
	    returnText.setEditable(false);
	    returnText.setColumns(10);
	    returnText.setBackground(Color.WHITE);
	    returnText.setBounds(134, 460, 301, 21);
	    bookDetailPanel.add(returnText);
	    ////////////////////////////////////////////////////////////
		
		userDetailPanel.setBounds(622, 42, 550, 550);
		
		userDetailPanel.setVisible(false);

		String [] bookHeader = { "제목", "저자", "출판사" };
		String [][] bookSt = new String[bookList.size()][3];
		for(int i = 0; i < bookList.size(); i++)
		{
			bookSt[i][0] = bookList.get(i).getBookTitle();
			bookSt[i][1] = bookList.get(i).getBookAuthor();
			bookSt[i][2] = bookList.get(i).getBookPublisher();
		}

		bookTable = new JTable(bookSt, bookHeader)
		{
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		bookTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bookTable.getTableHeader().setResizingAllowed(true);
		bookTable.getTableHeader().setReorderingAllowed(false);


		String [] userHeader = { "이름", "학번", "전화번호" };
		String[][] userSt = new String[userList.size()][3];
		for(int i = 0; i < userList.size(); i++)
		{
			userSt[i][0] = userList.get(i).getName();
			userSt[i][1] = userList.get(i).getId();
			userSt[i][2] = userList.get(i).getPhone();
		}

		userTable = new JTable(userSt, userHeader)
		{
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		userTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userTable.getTableHeader().setResizingAllowed(true);
		userTable.getTableHeader().setReorderingAllowed(false);
		
		bookScrollpane = new JScrollPane(bookTable);
		bookScrollpane.setBounds(10, 40, 550, 600);
		userScrollpane = new JScrollPane(userTable);
		userScrollpane.setBounds(10, 40, 550, 600);
		
		c.add(bookScrollpane);
		c.add(userScrollpane);

		bookScrollpane.setVisible(true);
		userScrollpane.setVisible(false);
		
		addBtn.setBounds(1050,600,100,30);
		c.add(addBtn);
		modifyBtn.setBounds(100, 500, 155, 44);
		modifyBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		modifyBtn.setEnabled(false);
		bookDetailPanel.add(modifyBtn);
		deleteBtn.setBounds(300, 500, 155, 44);
		deleteBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		deleteBtn.setEnabled(false);
		bookDetailPanel.add(deleteBtn);
		
		JButton logOutButton = new JButton("로그아웃");
		logOutButton.setBounds(1070,8,100,25);
		c.add(logOutButton);
		logOutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LogInFrame();
				new SuccessFrame("로그아웃", "로그아웃이 되었습니다.", 55);
			}		
		});
		
		bookButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				userScrollpane.setVisible(false);
				bookScrollpane.setVisible(true);
				bookDetailPanel.setVisible(true);
				userDetailPanel.setVisible(false);
			}
		});
		
		userButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				userScrollpane.setVisible(true);
				bookScrollpane.setVisible(false);
				bookDetailPanel.setVisible(false);
				userDetailPanel.setVisible(true);
			}
		});

		addBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new AddBook();
				dispose();
			}
		});
		
		modifyBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new ModifyBook(bookList,bookTable.getSelectedRow());
			}
		});
		
		deleteBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				new BookDelete(bookList.get(bookTable.getSelectedRow()));
				new ManagerMain();
				new SuccessFrame("삭제 성공","삭제를 성공하였습니다.",55);
			}
		});
		
		bookTable.addMouseListener(new MouseListener() {	//대출일, 반납예정일 추가
			public void mouseClicked(MouseEvent e) {
				int row = bookTable.getSelectedRow();
				Calendar borrowDate = bookList.get(row).getBorrowDate();
				Calendar returnDate = bookList.get(row).getReturnDate();
				titleField.setText(bookList.get(row).getBookTitle());
				authorField.setText(bookList.get(row).getBookAuthor());
				publisherField.setText(bookList.get(row).getBookPublisher());
				if(bookList.get(row).getBorrow()==true) {
					borrowField.setText("대출 중");
				}
				else {
					borrowField.setText("보유 중");
				}
				borrowTimeField.setText(Integer.toString(bookList.get(row).getBorrowTime()));
				idField.setText(bookList.get(row).getId());
				
				modifyBtn.setEnabled(true);
				if(bookList.get(row).getBorrow()==false) {
					deleteBtn.setEnabled(true);
				}
				else
					deleteBtn.setEnabled(false);
				if(borrowDate.get(Calendar.YEAR) != 1) {
		  	    	  dateText.setText(borrowDate.get(Calendar.YEAR) + "년 " + (borrowDate.get(Calendar.MONTH) + 1) + "월 " + borrowDate.get(Calendar.DATE) + "일");
		  	    	  returnText.setText(returnDate.get(Calendar.YEAR) + "년 " + (returnDate.get(Calendar.MONTH) + 1) + "월 " + returnDate.get(Calendar.DATE) + "일");
		  	      }
		  	      else {
		  	    	dateText.setText("");
			    	  returnText.setText("");
		  	      }
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e){}
		});
		
		userTable.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int row=userTable.getSelectedRow();
				nameField.setText(userList.get(row).getName());
				userIdField.setText(userList.get(row).getId());
				phoneField.setText(userList.get(row).getPhone());
				passwordField.setText(userList.get(row).getPassword());
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e){}
		});
		
		setSize(1200, 700);
		setVisible(true);
	}
}