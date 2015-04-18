package bank.gui;

import java.awt.Label;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListModel;

import net.miginfocom.swing.MigLayout;
import bank.account.Account;
import bank.user.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Accounts {

	private JFrame frame;
	
	private User
		user;

	/**
	 * Create the application.
	 */
	public Accounts(User user) {
		this.user = user;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		DefaultListModel listModel = new DefaultListModel();
		
		for(Account account : user.getAccounts()) {
			
			listModel.addElement(Integer.toString(account.getAccountNumber()));
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle(this.user.getUsername() + "'s Home");
		frame.getContentPane().setLayout(new MigLayout("", "[61px,grow][93px,grow][99px]", "[23px][grow]"));
		
		Label label = new Label("Accounts");
		frame.getContentPane().add(label, "flowx,cell 0 0,alignx left,aligny bottom");
		
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewAccount window = new NewAccount(user);
				frame.setVisible(false); 
				frame.dispose(); 
			}
		});
		frame.getContentPane().add(btnAddAccount, "cell 0 0,alignx left,aligny top");
		
		JLabel lblAccountInfo = new JLabel("Account Info");
		frame.getContentPane().add(lblAccountInfo, "cell 1 0");
		
		JLabel lblAccountActions = new JLabel("Account Actions");
		frame.getContentPane().add(lblAccountActions, "cell 2 0");
		
		JTextPane txtAccountInfo = new JTextPane();
		
		JList list = new JList(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Show more info about the account
				txtAccountInfo.setText("Account type\n" + user.getAccounts().get(list.getSelectedIndex()).getAccType());
			}
		});
		frame.getContentPane().add(list, "cell 0 1,grow");
		
		
		frame.getContentPane().add(txtAccountInfo, "cell 1 1,grow");
		
		JButton btnDoSomething = new JButton("Do Something");
		frame.getContentPane().add(btnDoSomething, "cell 2 1");
		
		
	}

}
