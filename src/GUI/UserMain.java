package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import Book.*;
import LogIn.UserInformation;
import LogIn.Withdrawal;
import User.*;
import javax.swing.ListSelectionModel;

public class UserMain extends JFrame {

   private JPanel contentPane;
   private JTextField searchText;
   private JTextField titleText;
   private JTextField authorText;
   private JTextField publisherText;
   private JTextField isBorrowText;
   private JTextField borrowTimeText;
   private Vector<Book>bookList=new Vector<Book>();
   private Vector<Book>searchList=new Vector<Book>();
   private String[]head;
   private String[][]data;
   private JTable listTable;
   private JTable searchTable;
   private JButton borrowButton;
   private JButton returnButton;
   private JButton logOutButton;
   private JButton modifyButton;
   private JButton withdrawalButton;
   private JButton bestSellerButton;
   private JButton extendReturnButton;
   private UserInformation user;
   private JLabel returnLabel;
   private JTextField returnText;
   
   public UserMain(UserInformation user) {
      this.user=user;
      //list에 들어갈 내용 정리///////////////////////////////////////
      BookRead br=new BookRead();
      bookList=br.bookRead();
      data=new String[bookList.size()][3];
      for(int i=0;i<bookList.size();i++) {
         data[i][0]=bookList.get(i).getBookTitle();
         data[i][1]=bookList.get(i).getBookAuthor();
         data[i][2]=bookList.get(i).getBookPublisher();
      }
      head=new String[3];
      head[0]="제목";
      head[1]="저자";
      head[2]="출판사";
      ////////////////////////////////////////////////////////////
      
      
      //컨텐트펜 정의////////////////////////////////////////////////
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1200, 700);
      setTitle("도서 검색 프로그램");
      contentPane = new JPanel();
      contentPane.setBackground(new Color(244, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      ////////////////////////////////////////////////////////////
      
      
      //검색 콤보박스////////////////////////////////////////////////
      JComboBox<String> searchBox = new JComboBox<String>(head);
      searchBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      searchBox.setBounds(23, 6, 81, 23);
      contentPane.add(searchBox);
      ////////////////////////////////////////////////////////////
      
      
      //검색 텍스트필드 구현//////////////////////////////////////////
      searchText = new JTextField();
      searchText.setBounds(112, 7, 301, 21);                  
      contentPane.add(searchText);                        
      searchText.setColumns(10);                           
      ////////////////////////////////////////////////////////////
      
      
      //검색 버튼 구현///////////////////////////////////////////////
      JButton searchButton = new JButton("\uAC80\uC0C9");
      searchButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      searchButton.setBounds(425, 6, 67, 23);
      contentPane.add(searchButton);
      ////////////////////////////////////////////////////////////   
      
      //베스트셀러 버튼///////////////////////////////////////////////////////////////////////////////////////////////////////////
      bestSellerButton = new JButton("베스트셀러");
      bestSellerButton.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      bestSellerButton.setBounds(495, 6, 67, 23);
      contentPane.add(bestSellerButton);
      ////////////////////////////////////////////////////////////
      
      //세부정보 패널 구현////////////////////////////////////////////
      JPanel infoPanel = new JPanel();
      infoPanel.setBackground(Color.WHITE);
      infoPanel.setForeground(Color.BLACK);
      infoPanel.setBounds(622, 42, 550, 600);
      contentPane.add(infoPanel);
      infoPanel.setLayout(null);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-제목라벨///////////////////////////////////////
      JLabel titleLabel = new JLabel("\uC81C\uBAA9");
      titleLabel.setBounds(60, 40, 45, 21);
      infoPanel.add(titleLabel);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-제목 텍스트필드/////////////////////////////////
      titleText = new JTextField();
      titleText.setBackground(Color.WHITE);
      titleText.setBounds(134, 40, 301, 21);
      infoPanel.add(titleText);
      titleText.setColumns(10);
      titleText.setEditable(false);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-저자 라벨//////////////////////////////////////
      JLabel authorLabel = new JLabel("\uC800\uC790");
      authorLabel.setBounds(60, 100, 45, 21);
      infoPanel.add(authorLabel);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-저자 텍스트필드/////////////////////////////////
      authorText = new JTextField();
      authorText.setEditable(false);
      authorText.setColumns(10);
      authorText.setBackground(Color.WHITE);
      authorText.setBounds(134, 100, 301, 21);
      infoPanel.add(authorText);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-출판사 라벨////////////////////////////////////
      JLabel publisherLabel = new JLabel("\uCD9C\uD310\uC0AC");
      publisherLabel.setBounds(47, 160, 60, 21);
      infoPanel.add(publisherLabel);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-출판사 텍스트필드////////////////////////////////
      publisherText = new JTextField();
      publisherText.setEditable(false);
      publisherText.setColumns(10);
      publisherText.setBackground(Color.WHITE);
      publisherText.setBounds(134, 160, 301, 21);
      infoPanel.add(publisherText);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-대출가능여부 라벨////////////////////////////////
      JLabel isBorrowLabel = new JLabel("\uB300\uCD9C \uC5EC\uBD80");
      isBorrowLabel.setBounds(32, 220, 87, 21);
      infoPanel.add(isBorrowLabel);
      
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-대출가능여부 텍스트필드///////////////////////////
      isBorrowText = new JTextField();
      isBorrowText.setEditable(false);
      isBorrowText.setColumns(10);
      isBorrowText.setBackground(Color.WHITE);
      isBorrowText.setBounds(134, 220, 301, 21);
      infoPanel.add(isBorrowText);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널-대출 누적 횟수 라벨//////////////////////////////
      JLabel borrowTimeLabel = new JLabel("\uB204\uC801 \uD69F\uC218");
      borrowTimeLabel.setBounds(32, 280, 87, 21);
      infoPanel.add(borrowTimeLabel);
      ////////////////////////////////////////////////////////////   
      
      
      ////세부정보 패널-대출 누적 횟수 텍스트필드/////////////////////////
      borrowTimeText = new JTextField();
      borrowTimeText.setEditable(false);
      borrowTimeText.setColumns(10);
      borrowTimeText.setBackground(Color.WHITE);
      borrowTimeText.setBounds(134, 280, 301, 21);
      infoPanel.add(borrowTimeText);
      ////////////////////////////////////////////////////////////
      
      
      ////세부정보 패널 - 반납 예정일 라벨///////////////////////////////
      returnLabel = new JLabel("반납 예정일");
      returnLabel.setBounds(32, 340, 87, 21);
      infoPanel.add(returnLabel);
      ////////////////////////////////////////////////////////////
      
      ////세부정보 패널 - 반납 예정일 텍스트 핃르//////////////////////////
      returnText = new JTextField();
      returnText.setEditable(false);
      returnText.setColumns(10);
      returnText.setBackground(Color.WHITE);
      returnText.setBounds(134, 340, 301, 21);
      infoPanel.add(returnText);
      ////////////////////////////////////////////////////////////
      
      
      //세부정보 패널-대출 버튼////////////////////////////////////////
      borrowButton = new JButton("\uB300\uCD9C");
      borrowButton.setEnabled(false);
      borrowButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      borrowButton.setBounds(80, 493, 105, 64);
      infoPanel.add(borrowButton);
      borrowButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	      new BorrowBook(bookList,listTable.getSelectedRow(),user.getId());
    	      dispose();
    	      new UserMain(user);
    	      new SuccessFrame("대출", "대출이 완료되었습니다.", 55);
    	   }
      });
      ////////////////////////////////////////////////////////////
      
      //세부정보 패널-반납 버튼////////////////////////////////////////
      returnButton = new JButton("반납");
      returnButton.setEnabled(false);
      returnButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      returnButton.setBounds(210, 493, 105, 64);
      infoPanel.add(returnButton);
      returnButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  new ReturnBook(bookList,listTable.getSelectedRow());
    		  dispose();
    		  new UserMain(user);
    		  new SuccessFrame("반납","반납이 완료되었습니다.",55);
    	  }
      });
      ////////////////////////////////////////////////////////////
      
      extendReturnButton = new JButton("연장");
      extendReturnButton.setEnabled(false);
      extendReturnButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
      extendReturnButton.setBounds(340, 493, 105, 64);
      infoPanel.add(extendReturnButton);
      extendReturnButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  new ExtendReturn(bookList, listTable.getSelectedRow());
    		  dispose();
    		  new UserMain(user);
    		  new SuccessFrame("연장","연장이 완료되었습니다.",55);
    	  }
      });
      
    //로그아웃 버튼////////////////////////////////////////
      logOutButton = new JButton("로그아웃");
      logOutButton.setBounds(1070,8,100,25);
      contentPane.add(logOutButton);
      logOutButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new LogInFrame();
			new SuccessFrame("로그아웃", "로그아웃이 되었습니다.", 55);
		}   	  
      });
      
      modifyButton = new JButton("정보 수정");
      modifyButton.setBounds(950,8,100,25);
      contentPane.add(modifyButton);
      modifyButton.addActionListener(new ActionListener() {
    	  
		@Override
		public void actionPerformed(ActionEvent e) {
			new UserInformationModifyFrame(user);
		}   	  
      });
      //여기~~~~~
      withdrawalButton = new JButton("회원 탈퇴");
      withdrawalButton.setBounds(830,8,100,25);
      contentPane.add(withdrawalButton);
      withdrawalButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(new BorrowCheck(bookList, user).borrowCheck()) {
				new Withdrawal(user).withdrawal();
				dispose();
				new LogInFrame();
				new SuccessFrame("회원 탈퇴", "회원 탈퇴가 처리되었습니다.", 45);
			}
			else {
				new ErrorFrame("탈퇴 실패", "대출한 도서를 반납하고 진행해주세요.", 15);
			}
		}   	  
      });
      
    //로그아웃 버튼////////////////////////////////////////
      
      //책 리스트 스크롤팬////////////////////////////////////////////
      JScrollPane listScrollPane = new JScrollPane();
      listScrollPane.setBounds(12, 42, 550, 600);
      contentPane.add(listScrollPane,BorderLayout.CENTER);

      listTable = new JTable(data, head) {
    	  private static final long serialVersionUID = 1L;
    	  public boolean isCellEditable(int row, int column) {
    		  return false;
    	  }
      };
      listTable.getTableHeader().setReorderingAllowed(false);   //사용자가 JTable을 이동하지 못하게 함
      listTable.getTableHeader().setResizingAllowed(true);   //사용자가 사이즈를 마음껏 조절할 수 있게함
      listTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //단일 선택 모드
      listTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      listScrollPane.setViewportView(listTable);            //JScrollPane에 컴포넌트 추가하는 방법
      ////////////////////////////////////////////////////////////

      
      //검색 스크롤팬////////////////////////////////////////////
      JScrollPane searchScrollPane = new JScrollPane();
      searchScrollPane.setBounds(12, 42, 550, 600);
      contentPane.add(searchScrollPane,BorderLayout.CENTER);
      
      
      //베스트셀러 버튼 이벤트구현//////////////////////////////////////
      bestSellerButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  listScrollPane.setVisible(true);
    		  searchScrollPane.setVisible(false);
    	  }
      });
      
      //책 검색 리스트 스크롤팬////////////////////////////////////
      searchButton.addActionListener(new ActionListener() {
    	  
		@Override
		public void actionPerformed(ActionEvent e) {
			int searchType;
			String searchValue;
			
			listScrollPane.setVisible(false);
			searchScrollPane.setVisible(true
					);
			searchType = searchBox.getSelectedIndex();
			searchValue = searchText.getText();
			
			searchList = new SearchBook(searchType, searchValue, bookList).bookSearch();
			String [][] searchSt = new String[searchList.size()][3];
			for(int i = 0; i < searchList.size(); i++)
			{
				searchSt[i][0] = searchList.get(i).getBookTitle();
				searchSt[i][1] = searchList.get(i).getBookAuthor();
				searchSt[i][2] = searchList.get(i).getBookPublisher();
			}	
			//검색한거 받고 
			
			searchTable = new JTable(searchSt, head)
			{
				private static final long serialVersionUID = 1L;
				public boolean isCellEditable(int row, int column)
				{
					return false;
				}
			};
			searchTable.getTableHeader().setReorderingAllowed(false);   //사용자가 JTable을 이동하지 못하게 함
			searchTable.getTableHeader().setResizingAllowed(true);   //사용자가 사이즈를 마음껏 조절할 수 있게함
			searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //단일 선택 모드
			searchTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			searchScrollPane.setViewportView(searchTable);            //JScrollPane에 컴포넌트 추가하는 방법
		      searchTable.addMouseListener(new MouseListener()
		    	{
		    	  public void mouseClicked(MouseEvent e) {   //클릭했을 때
		    	      int row=searchTable.getSelectedRow();      //몇번째 열이 선택됐는지 row에 저장
		    	      //선택된 열의 책 세부정보를 띄우기
		    	      titleText.setText(searchList.get(row).getBookTitle());   
		    	      authorText.setText(searchList.get(row).getBookAuthor());
		    	      publisherText.setText(searchList.get(row).getBookPublisher());
		    	      if(searchList.get(row).getBorrow()==true) {
		    	         isBorrowText.setText("불가능");
		    	         borrowButton.setEnabled(false);
		    	      }
		    	      else {
		    	         isBorrowText.setText("가능");
		    	         borrowButton.setEnabled(true);
		    	      }
		    	      if(searchList.get(row).getId().equals(user.getId())) {
		    	    	  returnButton.setEnabled(true);
		    	    	  extendReturnButton.setEnabled(true);
		    	      }
		    	      else {
		    	    	  returnButton.setEnabled(false);
		    	    	  extendReturnButton.setEnabled(false);
		    	      }
		    	      borrowTimeText.setText(Integer.toString(searchList.get(row).getBorrowTime()));
		    	   }    	   
		    	   public void mouseEntered(MouseEvent e) {}    	   
		    	   public void mouseExited(MouseEvent e) {}
		    	   public void mousePressed(MouseEvent e) {}    	   
		    	   public void mouseReleased(MouseEvent e) {}
		    	});
		}   	  
      });
      
      ////책 리스트 스크롤팬-리스트테이블////////////////////////////////
      listTable.addMouseListener(new MouseListener()
  	{
  	  public void mouseClicked(MouseEvent e) {   //클릭했을 때
  	      int row=listTable.getSelectedRow();      //몇번째 열이 선택됐는지 row에 저장
  	      //선택된 열의 책 세부정보를 띄우기
  	      Calendar returnDate = bookList.get(row).getReturnDate();
  	      titleText.setText(bookList.get(row).getBookTitle());   
  	      authorText.setText(bookList.get(row).getBookAuthor());
  	      publisherText.setText(bookList.get(row).getBookPublisher());
  	      if(bookList.get(row).getBorrow()==true) {
  	         isBorrowText.setText("불가능");
  	         borrowButton.setEnabled(false);
  	      }
  	      else {
  	         isBorrowText.setText("가능");
  	         borrowButton.setEnabled(true);
  	      }
  	      if(returnDate.get(Calendar.YEAR) != 1) {
  	    	  returnText.setText(returnDate.get(Calendar.YEAR) + "년 " + (returnDate.get(Calendar.MONTH) + 1) + "월 " + returnDate.get(Calendar.DATE) + "일");
  	      }
  	      else {
	    	  returnText.setText("");
  	      }
  	      if(bookList.get(row).getId().equals(user.getId())) {
  	    	  returnButton.setEnabled(true);
	    	  extendReturnButton.setEnabled(true);
  	      }
  	      else {
  	    	  returnButton.setEnabled(false);
	    	  extendReturnButton.setEnabled(false);
  	      }
  	      borrowTimeText.setText(Integer.toString(bookList.get(row).getBorrowTime()));
  	   }    	   
  	   public void mouseEntered(MouseEvent e) {}    	   
  	   public void mouseExited(MouseEvent e) {}
  	   public void mousePressed(MouseEvent e) {}    	   
  	   public void mouseReleased(MouseEvent e) {}
  	});
      ////////////////////////////////////////////////////////////
      setVisible(true);    
   }
}