package GUI;

import Book.*;
import Manager.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBook extends JFrame{
	private Book book=new Book();
	
	public AddBook() {
		setTitle("å �߰��ϱ�");
		setLocation(635,280);
		Container c=getContentPane();
		c.setLayout(null);
		
		//��Ʈ ����
		Font font=new Font("Agency FB ����",Font.BOLD,15);
		
		//å �̸� ��
		JLabel bookName=new JLabel("å �̸�");
		bookName.setLocation(10,0);
		bookName.setSize(70,100);
		bookName.setFont(font);
		c.add(bookName);
		
		//���� �̸� ��
		JLabel bookAuthor=new JLabel("����");
		bookAuthor.setLocation(10,50);
		bookAuthor.setSize(50,100);
		bookAuthor.setFont(font);
		c.add(bookAuthor);
		
		//���ǻ� �̸� ��
		JLabel bookPublisher=new JLabel("���ǻ�");
		bookPublisher.setLocation(10,100);
		bookPublisher.setSize(50,100);
		bookPublisher.setFont(font);
		c.add(bookPublisher);
		
		//å �̸� �ؽ�Ʈ�ʵ�
		JTextField getBookName=new JTextField(20);
		getBookName.setLocation(110,35);
		getBookName.setSize(250,30);
		c.add(getBookName);
		
		//���� �̸� �ؽ�Ʈ�ʵ�
		JTextField getBookAuthor=new JTextField(20);
		getBookAuthor.setLocation(110,85);
		getBookAuthor.setSize(250,30);
		c.add(getBookAuthor);
		
		//���ǻ� �̸� �ؽ�Ʈ�ʵ�
		JTextField getBookPublisher=new JTextField(20);
		getBookPublisher.setLocation(110,135);
		getBookPublisher.setSize(250,30);
		c.add(getBookPublisher);
		
		//��� ��ư ����
		JButton cancel = new JButton("���");
		cancel.setSize(100,30);
		cancel.setLocation(70,210);
		c.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();new ManagerMain();
			}
		});
		
		//�߰� ��ư ����
		JButton add = new JButton("�߰�");
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
					new SuccessFrame("�߰� ����","å �߰��� �����Ͽ����ϴ�.",45);
					
				}
				else {
					new ErrorFrame("�߰� ����", "������ �Է����ּ���.", 58);
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
		Font font=new Font("Agency FB ����",Font.BOLD,13);
		
		JLabel jl=new JLabel(label);
		jl.setLocation(40,50);
		jl.setSize(100,50);
		jl.setFont(font);
		c.add(jl);
		
		JButton check = new JButton("Ȯ��");
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