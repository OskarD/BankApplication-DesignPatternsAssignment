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
import bank.employee.BranchManager;
import bank.employee.BranchPresident;
import bank.loan.LoanHandler;
import bank.loan.LoanRequest;

public class Accounts {

	private JFrame frame;
	
	private User
		user;
	
	private JList
		list;
	
	private DefaultListModel
		listModel;
	
	private JTextPane 
		txtAccountInfo = new JTextPane();

	/**
	 * Create the application.
	 */
	public Accounts(User user) {
		this.user = user;
		initialize();		
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
		btnAddAccount.addActionListener(btnAddAccountListener);
		frame.getContentPane().add(btnAddAccount, "cell 0 0,alignx left,aligny top");
		
		JLabel lblAccountInfo = new JLabel("Account Info");
		frame.getContentPane().add(lblAccountInfo, "cell 1 0");
		
		JLabel lblAccountActions = new JLabel("Account Actions");
		frame.getContentPane().add(lblAccountActions, "cell 2 0");
		
		//JTextPane txtAccountInfo;
		
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
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(btnTransferListener);
		frame.getContentPane().add(btnTransfer, "cell 2 1");
		
		JButton btnRequestLoan = new JButton("Request Loan");
		btnRequestLoan.addActionListener(btnRequestLoanListener);
		frame.getContentPane().add(btnRequestLoan, "cell 2 1");
		
		frame.setVisible(true);
	}
	
	private ActionListener btnRequestLoanListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(list.isSelectionEmpty() == false) {
				double amount = Double.parseDouble( JOptionPane.showInputDialog(frame, "Please specify the amount you want to request a loan for") );
				
				LoanRequest request = new LoanRequest("Requested loan", amount);
				BranchManager bM = new BranchManager();
				BranchPresident bP = new BranchPresident();
				bM.setNextHandler(bP);
				
				try {
					bM.authorize(request);
					getSelectedAccount().deposit(amount);
					refreshListModel();
					JOptionPane.showMessageDialog(frame, "The loan has been approved, and the money deposited");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}
			}
		}
	};
	
	private ActionListener btnTransferListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(list.isSelectionEmpty() == false) {
				Transfer window = new Transfer(user, getSelectedAccount());
			}
		}
	};
	
	private ActionListener btnDepositListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(list.isSelectionEmpty() == false) {
				double amount = Double.parseDouble( JOptionPane.showInputDialog(frame, "Please specify the amount you want to deposit") );
				try {
					getSelectedAccount().deposit(amount);
					JOptionPane.showMessageDialog(frame, "Deposit completed.");
					refreshListModel();
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
					refreshListModel();
				} catch (BankAccountException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}
			}
		}
		
	};
	
	private ListSelectionListener listSelectionListener = new ListSelectionListener() {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			if(list.isSelectionEmpty() == false) {

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
	
	private ActionListener btnAddAccountListener = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			NewAccount window = new NewAccount(user);
			frame.setVisible(false); 
			frame.dispose(); 
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
	};

	private void refreshListModel() {
		listModel.clear();
		txtAccountInfo.setText("");
		for(Account account : user.getAccounts()) {
			
			listModel.addElement(Integer.toString(account.getAccountNumber()));
		}
	}

}
