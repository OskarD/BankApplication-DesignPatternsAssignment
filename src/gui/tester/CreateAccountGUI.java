package gui.tester;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class CreateAccountGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtType;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateAccountGUI frame = new CreateAccountGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public CreateAccountGUI() {
		setTitle("Create Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panBelow = new JPanel(new GridLayout(1, 2));
		contentPane.add(panBelow, BorderLayout.SOUTH);
		
		JButton btnCreate = new JButton("Create");
		panBelow.add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		panBelow.add(btnCancel);
		
		JPanel panTop = new JPanel(new GridLayout(1,2));
		contentPane.add(panTop, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("Name:");
		panTop.add(lblName);
		
		txtName = new JTextField();
		panTop.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		panTop.add(lblType);
		
		txtType = new JTextField();
		panTop.add(txtType);
		txtType.setColumns(10);
	}

}
