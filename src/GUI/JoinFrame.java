package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import LogIn.*;

public class JoinFrame extends JFrame{
	private JButton join;
	private JButton cancle;
	private JTextField userId;
	private JTextField userName;
	private JTextField userPhone;
	private JPasswordField userPassward;
	
	
	public JoinFrame() {
		setTitle("회원가입");
		setSize(280,230);
		setResizable(false);
		setLocation(650,300);
		JPanel panel = new JPanel();
		JoinPanel(panel);
		add(panel);
		setVisible(true);
	}
	
	public void JoinPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel idLabel = new JLabel("학번");
		idLabel.setBounds(10,10,80,25);
		panel.add(idLabel);
		JLabel passLabel = new JLabel("비밀번호");
		passLabel.setBounds(10,40,80,25);
		panel.add(passLabel);
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(10,70,80,25);
		panel.add(nameLabel);
		JLabel phoneLabel = new JLabel("전화번호");
		phoneLabel.setBounds(10,100,80,25);
		panel.add(phoneLabel);
		userId = new JTextField(20);
		userId.setBounds(100,10,160,25);
		panel.add(userId);
		userPassward = new JPasswordField(20);
		userPassward.setBounds(100,40,160,25);
		panel.add(userPassward);
		userName = new JTextField(20);
		userName.setBounds(100,70,160,25);
		panel.add(userName);
		userPhone = new JTextField(20);
		userPhone.setBounds(100,100,160,25);
		panel.add(userPhone);
		
		join = new JButton("회원가입");
		join.setBounds(10,130,250,25);
		panel.add(join);
		join.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinMember jm = new JoinMember();
				char pas[] = new char[1024];
				pas = userPassward.getPassword();
				String password = new String(pas);
				if(userId.getText().length() <1 || password.length() <1 || userName.getText().length() <1 || userPhone.getText().length() <1)
					new ErrorFrame("회원가입 실패", "회원 정보를 다시 확인하세요.", 15);
				
				else {
					UserInformationCheck uic = new UserInformationCheck(userId.getText());
					if(uic.checking()==true) {
						jm.run(userId.getText(), password, userName.getText(), userPhone.getText()); 
						dispose();
						new SuccessFrame("회원가입", "가입되었습니다.", 75);
					}
					else {
						new ErrorFrame("회원중복","이미 가입된 학번입니다.",55);
					}	
				}
			}
			
		});
		cancle = new JButton("취소");
		cancle.setBounds(10,160,250,25);
		panel.add(cancle);
		cancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
