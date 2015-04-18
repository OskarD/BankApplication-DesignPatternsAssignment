package bank.gui;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;
import bank.account.Account;
import bank.account.BankAccountException;
import bank.card.Card;
import bank.card.CreateCard;

public class Accounts {

	private JFrame frame;
	
	private User
		user;
	
	private JList
		list;
	
	private DefaultListModel
		listModel;
	
	private JTextPane txtAccountInfo;

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

		listModel = new DefaultListModel();
		
		refreshListModel();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		
		list = new JList(listModel);
		list.addListSelectionListener(listSelectionListener);
		frame.getContentPane().add(list, "cell 0 1,grow");
		
		
		frame.getContentPane().add(txtAccountInfo, "cell 1 1,grow");
		
		JButton btnAddCard = new JButton("Add Card");
		btnAddCard.addActionListener(btnAddCardListener);
		frame.getContentPane().add(btnAddCard, "flowy,cell 2 1");
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(btnWithdrawListener);
		frame.getContentPane().add(btnWithdraw, "cell 2 1");
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(btnDepositListener);
		frame.getContentPane().add(btnDeposit, "cell 2 1");
		
		
	}
	
	private ActionListener btnDepositListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(list.isSelectionEmpty() == false) {
				double amount = Double.parseDouble( JOptionPane.showInputDialog(frame, "Please specify the amount you want to deposit") );
				try {
					getSelectedAccount().withdraw(amount);
					JOptionPane.showMessageDialog(frame, "Deposit completed.");
				} catch (BankAccountException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}
			}
		}
		
	};
	
	private ActionListener btnWithdrawListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(list.isSelectionEmpty() == false) {
				double amount = Double.parseDouble( JOptionPane.showInputDialog(frame, "Please specify the amount you want to withdraw") );
				try {
					getSelectedAccount().withdraw(amount);
					JOptionPane.showMessageDialog(frame, "Withdrawal completed.");
				} catch (BankAccountException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}
			}
		}
		
	};
	
	private ListSelectionListener listSelectionListener = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			Account selectedAccount = getSelectedAccount();
			
			String accountInfo = "Account type\n" + selectedAccount.getType() + " Account\n\nCards:\n";
			
			if(selectedAccount.getCards().size() == 0)
				accountInfo += "None\n";
			else {
				for(Card card : selectedAccount.getCards()) {
					accountInfo += card.getType() + "\n";
				}
			}
			
			accountInfo += "\nBalance\n" + selectedAccount.getBalance();
			
			txtAccountInfo.setText(accountInfo);
		}
		
	};
	
	private ActionListener btnAddCardListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(list.isSelectionEmpty() == false) {
				AddCard window = new AddCard(user, getSelectedAccount());
				frame.setVisible(false);
				frame.dispose(); 
			}
		}
		
	};
	
	private Account getSelectedAccount() {
		if(list.isSelectionEmpty() == false) {
			for(Account account : user.getAccounts()) {
				if(account.getAccountNumber() == Integer.parseInt( (String) list.getSelectedValue() )) {
					return account;
				}
			}
		}
		
		return null;
	}
	
	private void refreshListModel() {
		for(Account account : user.getAccounts()) {
			
			listModel.addElement(Integer.toString(account.getAccountNumber()));
		}
	}

}
