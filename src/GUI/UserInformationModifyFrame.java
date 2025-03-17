package GUI;
import javax.swing.*;

import LogIn.ModifyOneUserInformation;
import LogIn.UserInformation;
import LogIn.UserInformationRead;
import LogIn.Withdrawal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UserInformationModifyFrame extends JFrame{
	private JButton btnModify;
	private JButton btnWithdrawal;
	private JTextField idField;
	private JTextField passwordField;
	private JTextField nameField;
	private JTextField phoneField;
	private JLabel idLaber;
	private JLabel passwordLaber;
	private JLabel nameLaber;
	private JLabel phoneLaber;
	private UserInformation user;

	public UserInformationModifyFrame(UserInformation user) {
		this.user = user;
		setTitle("ȸ������ ����");
		setSize(320,230);
		setResizable(false);
		setLocation(650,300);
		JPanel panel = new JPanel();
		ModifyPanel(panel);
		add(panel);
		setVisible(true);
	}
	
	public void ModifyPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBackground(new Color(244,255,255));
		
		idLaber = new JLabel("�й�");
		idLaber.setBounds(10,10,80,25);
		panel.add(idLaber);
		
		passwordLaber = new JLabel("��й�ȣ");
		passwordLaber.setBounds(10,40,80,25);
		panel.add(passwordLaber);
		
		nameLaber = new JLabel("�̸�");
		nameLaber.setBounds(10,70,80,25);
		panel.add(nameLaber);
		
		phoneLaber = new JLabel("��ȭ��ȣ");
		phoneLaber.setBounds(10,100,80,25);
		panel.add(phoneLaber);
		
		idField = new JTextField(user.getId());
		idField.setBounds(140,10,160,25);
		idField.setEditable(false);
		panel.add(idField);
		
		passwordField = new JTextField(user.getPassword());
		passwordField.setBounds(140,40,160,25);
		panel.add(passwordField);
		
		nameField = new JTextField(user.getName());
		nameField.setBounds(140,70,160,25);
		panel.add(nameField);
		
		phoneField = new JTextField(user.getPhone());
		phoneField.setBounds(140,100,160,25);
		panel.add(phoneField);
		
		btnModify = new JButton("����");
		btnModify.setBounds(10,130,290,25);
		panel.add(btnModify);
		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				user.setPassword(passwordField.getText());
				user.setName(nameField.getText());
				user.setPhone(phoneField.getText());
				new ModifyOneUserInformation(user).modifyOneUserInformation();
				dispose();
				new SuccessFrame("���� ����", "ȸ�� ������ �����Ǿ����ϴ�.", 38);
			}
		});
		
		btnWithdrawal = new JButton("���");
		btnWithdrawal.setBounds(10,160,290,25);
		panel.add(btnWithdrawal);
		btnWithdrawal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();			
				new SuccessFrame("���� ���", "ȸ�� ���� ������ ����Ͽ����ϴ�.", 38);
			}
		});
	}
	
}
