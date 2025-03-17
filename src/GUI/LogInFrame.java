package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import LogIn.*;

public class LogInFrame extends JFrame{
	
	private JButton btnLogin;
	private JButton btnJoin;
	private JPasswordField passText;
	private JTextField userText;
	private ButtonGroup group = new ButtonGroup();
    private JRadioButton userRB;
    private JRadioButton managerRB;
    private int mode = -1;
    
	public LogInFrame() {
		 setTitle("로그인");
	     setSize(280, 230);
	     setResizable(false);
	     setLocation(650, 300);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);	       
	     JPanel panel = new JPanel();	      
	     LoginPanel(panel);	       	    
	     add(panel);
	     setVisible(true);
	}
	
	 public void LoginPanel(JPanel panel){
	        panel.setLayout(null);     
	        panel.setBackground(new Color(244,255,255));
	        
	        JLabel userLabel = new JLabel("학번");
	        userLabel.setBounds(10, 10, 80, 25);
	        panel.add(userLabel);       
	        
	        JLabel passLabel = new JLabel("비밀번호");
	        passLabel.setBounds(10, 40, 80, 25);
	        panel.add(passLabel);       
	        
	        userText = new JTextField(20);
	        userText.setBounds(100, 10, 160, 25);
	        panel.add(userText);      
	       
	        passText = new JPasswordField(20);
	        passText.setBounds(100, 40, 160, 25);
	        panel.add(passText);
	     
	        btnLogin = new JButton("로그인");
	        btnLogin.setBounds(10, 130, 250, 25);
	        panel.add(btnLogin);
	        btnLogin.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	char pas[] = new char[1024];
	            	pas = passText.getPassword();
	            	String password = new String(pas);	     	            	
	                LogIn login = new LogIn(userText.getText(), password);
	                if(mode==0) {
	                if(login.checkLogIn("../LibraryApp/src/회원 정보.txt")==true) {
	                	GetOneUserInformation gOUI = new GetOneUserInformation();
	                	UserInformation one = gOUI.getUserInformation(userText.getText());
	                	dispose();
	                	new UserMain(one);
	                }
	                else {
	                	new ErrorFrame("로그인 실패", "학번 또는 비밀번호를 다시 확인하세요.", 12);
	                }
	                }
	                else if(mode==1) {
	                	if(login.checkLogIn("../LibraryApp/src/매니저 정보.txt")==true) {
	                		dispose();
	                		new ManagerMain();
	                	}
	                	else 
	                		new ErrorFrame("로그인 실패", "학번 또는 비밀번호를 다시 확인하세요.", 12);
	                }
	                else 
	                	new ErrorFrame("로그인 실패", "모드를 선택하세요.",65);
	                
	            }
	        });
	        
	        btnJoin = new JButton("회원가입");
	        btnJoin.setBounds(10, 160, 250, 25);
	        panel.add(btnJoin);
	        btnJoin.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	               if(mode==0)
	            	new JoinFrame();
	               else if(mode==1)
	            	   new ErrorFrame("가입 오류", "관리자 회원가입은 불가능합니다.",27);
	               else
	            	   new JoinFrame();
	            }
	        });	
	        
	        userRB = new JRadioButton("회원");
	        userRB.setBounds(50,70,50,50);
	        userRB.setBackground(new Color(244,255,255));
	        group.add(userRB);
	        panel.add(userRB);
	        userRB.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		mode = 0;
	        	}
	        });
	        
	        managerRB = new JRadioButton("관리자");
	        managerRB.setBackground(new Color(244,255,255));
	        managerRB.setBounds(150,70,80,50);
	        group.add(managerRB);
	        panel.add(managerRB);
	        managerRB.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		mode = 1;
	        	}
	        });
	    }
	 
	public static void main(String[] args) {
		new LogInFrame();
	}
}
