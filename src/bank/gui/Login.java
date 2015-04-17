package bank.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.Label;

import javax.swing.JButton;

import bank.user.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmLogin;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(170, 103, 86, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		Label label = new Label("Username");
		label.setBounds(102, 101, 62, 22);
		frmLogin.getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setUsername(textField.getText());
				Accounts window = new Accounts(user);
				frmLogin.setVisible(false); 
				frmLogin.dispose(); 
			}
		});
		btnNewButton.setBounds(266, 102, 89, 23);
		frmLogin.getContentPane().add(btnNewButton);
	}
}
