package Bank;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Account.UserAccount;
import Helper.Helper;

public  class  BankFunctions {

private ArrayList<UserAccount> runTimeList;
	private UserAccount loginUserData;

	public BankFunctions() {
		runTimeList = new ArrayList<UserAccount>();
	}


	public Boolean login(String inputUsername, String inputPassword) {

		for (var user : getAccountsList()) { 

			if (user.getUserName().equals(inputUsername) && user.getPassword().equals(inputPassword)) {
				loginUserData(user);
				return true;
			}

		}

		
		return false;
	}

	public void  loginUserData(UserAccount loginUserData) {
		this.loginUserData = loginUserData;
	}
	

	public UserAccount getLoginUserData() {
		return loginUserData;
	}
	
	
	public void createAccount(UserAccount inputNewAccount) {

		UserAccount user = new UserAccount();

		user.setFirstName(inputNewAccount.getFirstName());
		user.setLastName(inputNewAccount.getLastName());
		user.setUserName(inputNewAccount.getUserName());
		user.setPassword(inputNewAccount.getPassword());
		user.setPhoneNumber(inputNewAccount.getPhoneNumber());
		user.setMoneyBalance(0);
		// Automatically set balance to 0 after cretion of account
		user.setTransanctionHistory("Created Account at " + Helper.getDate());
		// Automatically Add Transanction history after creation

		runTimeList.add(user);
	}

	public ArrayList<UserAccount> getAccountsList() {

		ArrayList<UserAccount> tempAccountList = new ArrayList<UserAccount>();

		var BufferedList = getBufferedList();
		var RunTimeList = getRunTimeList();

		
		tempAccountList = (ArrayList<UserAccount>) Stream.of(BufferedList, RunTimeList).flatMap(x -> x.stream())
				.collect(Collectors.toList());
		// Merge both Buffered List and RunTimeList

		return tempAccountList;
	}

	public ArrayList<UserAccount> getBufferedList(){
		ArrayList<UserAccount> tempBufferedList = new ArrayList<UserAccount>();

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("C:\\Javabuffered\\UserList.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				String arr[] = line.split(" ");

				UserAccount user = new UserAccount();

				user.setFirstName(arr[0]);
				user.setLastName(arr[1]);
				user.setUserName(arr[2]);
				user.setPassword(arr[3]);
				user.setPhoneNumber(arr[4]);
				user.setMoneyBalance(Integer.parseInt(arr[5]));
				user.setTransanctionHistory("Created account using Buffered");
				
				user.setTransanctionHistory("Atomatically add " + Integer.parseInt(arr[5])+ " money using Buffered");
		
	
				tempBufferedList.add(user);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O Exception " + e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Invalid Number Format " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid: " + e.getMessage());
		}

		return tempBufferedList;
	}


	public ArrayList<UserAccount> getRunTimeList() {

		return runTimeList;
	}
}
