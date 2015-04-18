package gui.tester;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class CreateCardHGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtOwner;
	private JTextField txtType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					CreateCardHGUI frame = new CreateCardHGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public CreateCardHGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);
		
		JLabel lblOwner = new JLabel("Owner:");
		panelTop.add(lblOwner);
		
		txtOwner = new JTextField();
		panelTop.add(txtOwner);
		txtOwner.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		panelTop.add(lblType);
		
		txtType = new JTextField();
		panelTop.add(txtType);
		txtType.setColumns(10);
		
		JPanel panBelow = new JPanel();
		contentPane.add(panBelow, BorderLayout.SOUTH);
		
		JButton btnCreateCard = new JButton("Create Card");
		panBelow.add(btnCreateCard);
		
		JButton btnCancel = new JButton("Cancel");
		panBelow.add(btnCancel);
	}

}
