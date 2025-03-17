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
      //list�� �� ���� ����///////////////////////////////////////
      BookRead br=new BookRead();
      bookList=br.bookRead();
      data=new String[bookList.size()][3];
      for(int i=0;i<bookList.size();i++) {
         data[i][0]=bookList.get(i).getBookTitle();
         data[i][1]=bookList.get(i).getBookAuthor();
         data[i][2]=bookList.get(i).getBookPublisher();
      }
      head=new String[3];
      head[0]="����";
      head[1]="����";
      head[2]="���ǻ�";
      ////////////////////////////////////////////////////////////
      
      
      //����Ʈ�� ����////////////////////////////////////////////////
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1200, 700);
      setTitle("���� �˻� ���α׷�");
      contentPane = new JPanel();
      contentPane.setBackground(new Color(244, 255, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      ////////////////////////////////////////////////////////////
      
      
      //�˻� �޺��ڽ�////////////////////////////////////////////////
      JComboBox<String> searchBox = new JComboBox<String>(head);
      searchBox.setFont(new Font("���� ���", Font.PLAIN, 15));
      searchBox.setBounds(23, 6, 81, 23);
      contentPane.add(searchBox);
      ////////////////////////////////////////////////////////////
      
      
      //�˻� �ؽ�Ʈ�ʵ� ����//////////////////////////////////////////
      searchText = new JTextField();
      searchText.setBounds(112, 7, 301, 21);                  
      contentPane.add(searchText);                        
      searchText.setColumns(10);                           
      ////////////////////////////////////////////////////////////
      
      
      //�˻� ��ư ����///////////////////////////////////////////////
      JButton searchButton = new JButton("\uAC80\uC0C9");
      searchButton.setFont(new Font("���� ���", Font.PLAIN, 15));
      searchButton.setBounds(425, 6, 67, 23);
      contentPane.add(searchButton);
      ////////////////////////////////////////////////////////////   
      
      //����Ʈ���� ��ư///////////////////////////////////////////////////////////////////////////////////////////////////////////
      bestSellerButton = new JButton("����Ʈ����");
      bestSellerButton.setFont(new Font("���� ���", Font.PLAIN, 15));
      bestSellerButton.setBounds(495, 6, 67, 23);
      contentPane.add(bestSellerButton);
      ////////////////////////////////////////////////////////////
      
      //�������� �г� ����////////////////////////////////////////////
      JPanel infoPanel = new JPanel();
      infoPanel.setBackground(Color.WHITE);
      infoPanel.setForeground(Color.BLACK);
      infoPanel.setBounds(622, 42, 550, 600);
      contentPane.add(infoPanel);
      infoPanel.setLayout(null);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-�����///////////////////////////////////////
      JLabel titleLabel = new JLabel("\uC81C\uBAA9");
      titleLabel.setBounds(60, 40, 45, 21);
      infoPanel.add(titleLabel);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-���� �ؽ�Ʈ�ʵ�/////////////////////////////////
      titleText = new JTextField();
      titleText.setBackground(Color.WHITE);
      titleText.setBounds(134, 40, 301, 21);
      infoPanel.add(titleText);
      titleText.setColumns(10);
      titleText.setEditable(false);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-���� ��//////////////////////////////////////
      JLabel authorLabel = new JLabel("\uC800\uC790");
      authorLabel.setBounds(60, 100, 45, 21);
      infoPanel.add(authorLabel);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-���� �ؽ�Ʈ�ʵ�/////////////////////////////////
      authorText = new JTextField();
      authorText.setEditable(false);
      authorText.setColumns(10);
      authorText.setBackground(Color.WHITE);
      authorText.setBounds(134, 100, 301, 21);
      infoPanel.add(authorText);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-���ǻ� ��////////////////////////////////////
      JLabel publisherLabel = new JLabel("\uCD9C\uD310\uC0AC");
      publisherLabel.setBounds(47, 160, 60, 21);
      infoPanel.add(publisherLabel);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-���ǻ� �ؽ�Ʈ�ʵ�////////////////////////////////
      publisherText = new JTextField();
      publisherText.setEditable(false);
      publisherText.setColumns(10);
      publisherText.setBackground(Color.WHITE);
      publisherText.setBounds(134, 160, 301, 21);
      infoPanel.add(publisherText);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-���Ⱑ�ɿ��� ��////////////////////////////////
      JLabel isBorrowLabel = new JLabel("\uB300\uCD9C \uC5EC\uBD80");
      isBorrowLabel.setBounds(32, 220, 87, 21);
      infoPanel.add(isBorrowLabel);
      
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-���Ⱑ�ɿ��� �ؽ�Ʈ�ʵ�///////////////////////////
      isBorrowText = new JTextField();
      isBorrowText.setEditable(false);
      isBorrowText.setColumns(10);
      isBorrowText.setBackground(Color.WHITE);
      isBorrowText.setBounds(134, 220, 301, 21);
      infoPanel.add(isBorrowText);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г�-���� ���� Ƚ�� ��//////////////////////////////
      JLabel borrowTimeLabel = new JLabel("\uB204\uC801 \uD69F\uC218");
      borrowTimeLabel.setBounds(32, 280, 87, 21);
      infoPanel.add(borrowTimeLabel);
      ////////////////////////////////////////////////////////////   
      
      
      ////�������� �г�-���� ���� Ƚ�� �ؽ�Ʈ�ʵ�/////////////////////////
      borrowTimeText = new JTextField();
      borrowTimeText.setEditable(false);
      borrowTimeText.setColumns(10);
      borrowTimeText.setBackground(Color.WHITE);
      borrowTimeText.setBounds(134, 280, 301, 21);
      infoPanel.add(borrowTimeText);
      ////////////////////////////////////////////////////////////
      
      
      ////�������� �г� - �ݳ� ������ ��///////////////////////////////
      returnLabel = new JLabel("�ݳ� ������");
      returnLabel.setBounds(32, 340, 87, 21);
      infoPanel.add(returnLabel);
      ////////////////////////////////////////////////////////////
      
      ////�������� �г� - �ݳ� ������ �ؽ�Ʈ ����//////////////////////////
      returnText = new JTextField();
      returnText.setEditable(false);
      returnText.setColumns(10);
      returnText.setBackground(Color.WHITE);
      returnText.setBounds(134, 340, 301, 21);
      infoPanel.add(returnText);
      ////////////////////////////////////////////////////////////
      
      
      //�������� �г�-���� ��ư////////////////////////////////////////
      borrowButton = new JButton("\uB300\uCD9C");
      borrowButton.setEnabled(false);
      borrowButton.setFont(new Font("���� ���", Font.PLAIN, 20));
      borrowButton.setBounds(80, 493, 105, 64);
      infoPanel.add(borrowButton);
      borrowButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    	      new BorrowBook(bookList,listTable.getSelectedRow(),user.getId());
    	      dispose();
    	      new UserMain(user);
    	      new SuccessFrame("����", "������ �Ϸ�Ǿ����ϴ�.", 55);
    	   }
      });
      ////////////////////////////////////////////////////////////
      
      //�������� �г�-�ݳ� ��ư////////////////////////////////////////
      returnButton = new JButton("�ݳ�");
      returnButton.setEnabled(false);
      returnButton.setFont(new Font("���� ���", Font.PLAIN, 20));
      returnButton.setBounds(210, 493, 105, 64);
      infoPanel.add(returnButton);
      returnButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  new ReturnBook(bookList,listTable.getSelectedRow());
    		  dispose();
    		  new UserMain(user);
    		  new SuccessFrame("�ݳ�","�ݳ��� �Ϸ�Ǿ����ϴ�.",55);
    	  }
      });
      ////////////////////////////////////////////////////////////
      
      extendReturnButton = new JButton("����");
      extendReturnButton.setEnabled(false);
      extendReturnButton.setFont(new Font("���� ���", Font.PLAIN, 20));
      extendReturnButton.setBounds(340, 493, 105, 64);
      infoPanel.add(extendReturnButton);
      extendReturnButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  new ExtendReturn(bookList, listTable.getSelectedRow());
    		  dispose();
    		  new UserMain(user);
    		  new SuccessFrame("����","������ �Ϸ�Ǿ����ϴ�.",55);
    	  }
      });
      
    //�α׾ƿ� ��ư////////////////////////////////////////
      logOutButton = new JButton("�α׾ƿ�");
      logOutButton.setBounds(1070,8,100,25);
      contentPane.add(logOutButton);
      logOutButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new LogInFrame();
			new SuccessFrame("�α׾ƿ�", "�α׾ƿ��� �Ǿ����ϴ�.", 55);
		}   	  
      });
      
      modifyButton = new JButton("���� ����");
      modifyButton.setBounds(950,8,100,25);
      contentPane.add(modifyButton);
      modifyButton.addActionListener(new ActionListener() {
    	  
		@Override
		public void actionPerformed(ActionEvent e) {
			new UserInformationModifyFrame(user);
		}   	  
      });
      //����~~~~~
      withdrawalButton = new JButton("ȸ�� Ż��");
      withdrawalButton.setBounds(830,8,100,25);
      contentPane.add(withdrawalButton);
      withdrawalButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(new BorrowCheck(bookList, user).borrowCheck()) {
				new Withdrawal(user).withdrawal();
				dispose();
				new LogInFrame();
				new SuccessFrame("ȸ�� Ż��", "ȸ�� Ż�� ó���Ǿ����ϴ�.", 45);
			}
			else {
				new ErrorFrame("Ż�� ����", "������ ������ �ݳ��ϰ� �������ּ���.", 15);
			}
		}   	  
      });
      
    //�α׾ƿ� ��ư////////////////////////////////////////
      
      //å ����Ʈ ��ũ����////////////////////////////////////////////
      JScrollPane listScrollPane = new JScrollPane();
      listScrollPane.setBounds(12, 42, 550, 600);
      contentPane.add(listScrollPane,BorderLayout.CENTER);

      listTable = new JTable(data, head) {
    	  private static final long serialVersionUID = 1L;
    	  public boolean isCellEditable(int row, int column) {
    		  return false;
    	  }
      };
      listTable.getTableHeader().setReorderingAllowed(false);   //����ڰ� JTable�� �̵����� ���ϰ� ��
      listTable.getTableHeader().setResizingAllowed(true);   //����ڰ� ����� ������ ������ �� �ְ���
      listTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //���� ���� ���
      listTable.setFont(new Font("���� ���", Font.PLAIN, 15));
      listScrollPane.setViewportView(listTable);            //JScrollPane�� ������Ʈ �߰��ϴ� ���
      ////////////////////////////////////////////////////////////

      
      //�˻� ��ũ����////////////////////////////////////////////
      JScrollPane searchScrollPane = new JScrollPane();
      searchScrollPane.setBounds(12, 42, 550, 600);
      contentPane.add(searchScrollPane,BorderLayout.CENTER);
      
      
      //����Ʈ���� ��ư �̺�Ʈ����//////////////////////////////////////
      bestSellerButton.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e) {
    		  listScrollPane.setVisible(true);
    		  searchScrollPane.setVisible(false);
    	  }
      });
      
      //å �˻� ����Ʈ ��ũ����////////////////////////////////////
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
			//�˻��Ѱ� �ް� 
			
			searchTable = new JTable(searchSt, head)
			{
				private static final long serialVersionUID = 1L;
				public boolean isCellEditable(int row, int column)
				{
					return false;
				}
			};
			searchTable.getTableHeader().setReorderingAllowed(false);   //����ڰ� JTable�� �̵����� ���ϰ� ��
			searchTable.getTableHeader().setResizingAllowed(true);   //����ڰ� ����� ������ ������ �� �ְ���
			searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   //���� ���� ���
			searchTable.setFont(new Font("���� ���", Font.PLAIN, 15));
			searchScrollPane.setViewportView(searchTable);            //JScrollPane�� ������Ʈ �߰��ϴ� ���
		      searchTable.addMouseListener(new MouseListener()
		    	{
		    	  public void mouseClicked(MouseEvent e) {   //Ŭ������ ��
		    	      int row=searchTable.getSelectedRow();      //���° ���� ���õƴ��� row�� ����
		    	      //���õ� ���� å ���������� ����
		    	      titleText.setText(searchList.get(row).getBookTitle());   
		    	      authorText.setText(searchList.get(row).getBookAuthor());
		    	      publisherText.setText(searchList.get(row).getBookPublisher());
		    	      if(searchList.get(row).getBorrow()==true) {
		    	         isBorrowText.setText("�Ұ���");
		    	         borrowButton.setEnabled(false);
		    	      }
		    	      else {
		    	         isBorrowText.setText("����");
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
      
      ////å ����Ʈ ��ũ����-����Ʈ���̺�////////////////////////////////
      listTable.addMouseListener(new MouseListener()
  	{
  	  public void mouseClicked(MouseEvent e) {   //Ŭ������ ��
  	      int row=listTable.getSelectedRow();      //���° ���� ���õƴ��� row�� ����
  	      //���õ� ���� å ���������� ����
  	      Calendar returnDate = bookList.get(row).getReturnDate();
  	      titleText.setText(bookList.get(row).getBookTitle());   
  	      authorText.setText(bookList.get(row).getBookAuthor());
  	      publisherText.setText(bookList.get(row).getBookPublisher());
  	      if(bookList.get(row).getBorrow()==true) {
  	         isBorrowText.setText("�Ұ���");
  	         borrowButton.setEnabled(false);
  	      }
  	      else {
  	         isBorrowText.setText("����");
  	         borrowButton.setEnabled(true);
  	      }
  	      if(returnDate.get(Calendar.YEAR) != 1) {
  	    	  returnText.setText(returnDate.get(Calendar.YEAR) + "�� " + (returnDate.get(Calendar.MONTH) + 1) + "�� " + returnDate.get(Calendar.DATE) + "��");
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