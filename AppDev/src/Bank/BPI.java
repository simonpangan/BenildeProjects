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

public class BPI extends BankFunctions {

	
	//class will inherit all bank functions except get Buffer
	
	@Override
	public ArrayList<UserAccount> getBufferedList(){
		ArrayList<UserAccount> tempBufferedList = new ArrayList<UserAccount>();

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("C:\\Javabuffered\\BPILIST.txt"));
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

	

}
