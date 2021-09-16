package Account;

import java.util.ArrayList;

public class UserAccount {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String phoneNumber;
	private int moneyBalance;
	private ArrayList<String> transanctionHistory;
	
	public UserAccount() {
		transanctionHistory = new ArrayList<String>();
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(int moneyBalance) {
		this.moneyBalance = moneyBalance;
	}

	public ArrayList<String> getTransanctionHistory() {
		return transanctionHistory;
	}

	public void setTransanctionHistory(String addTransanction) {
	
		transanctionHistory.add(addTransanction);
		
	}
	
	public void  addMoney(int money) {
		moneyBalance+= money;
	}
	
	public void  reduceMoney(int money) {
		moneyBalance -= money;
	}


}
