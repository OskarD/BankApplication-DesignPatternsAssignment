package gui.tester;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BankingApplication extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankingApplication frame = new BankingApplication();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BankingApplication() {
		setTitle("Banking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateAccountGUI ca = new CreateAccountGUI();
				
				ca.setVisible(true);
//				test t = new test();
//				t.pack();
//				t.setVisible(true);
			
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Card");
		panel.add(btnNewButton_1);
		
		JPanel panLeft = new JPanel();
		contentPane.add(panLeft, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("Name: ");
		panLeft.add(lblName);
		
		txtName = new JTextField();
		panLeft.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		panLeft.add(lblType);
		
		txtType = new JTextField();
		txtType.setColumns(10);
		panLeft.add(txtType);
	}

}
