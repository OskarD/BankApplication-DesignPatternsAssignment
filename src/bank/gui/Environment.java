package bank.gui;

import java.util.ArrayList;

import bank.user.User;

public class Environment {
	
	private static ArrayList<User> users = new ArrayList<>();

	private Environment() {
		// TODO Auto-generated constructor stub
	}

	public static final ArrayList<User> getUsers() {
		return users;
	}

	public static final void setUsers(ArrayList<User> users) {
		Environment.users = users;
	}
	
	public static final void addUser(User user) {
		Environment.users.add(user);
	}
}
