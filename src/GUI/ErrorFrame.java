package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErrorFrame extends JFrame{
	
	
	public ErrorFrame(String title, String message, int size) {
		setTitle(title);
		setSize(250,125);
		setResizable(false);
		setLocation(665,350);
				
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel errorText = new JLabel(message);
		errorText.setBounds(size, 35, 250, 25);
		panel.add(errorText);
		add(panel);
		setVisible(true);
	}
}
