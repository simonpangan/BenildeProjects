package Database;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ContactDatabase {
	
	public void addContact(UserContact inputs){


		PrintWriter out = null;
		try {
		    out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\\\Javabuffered\\\\Contact.txt", true)));
		    out.println("");
		    out.print(inputs.getFirstname() + " " + inputs.getLastname() + " "
		    		+ inputs.getDepartment() + " " + inputs.getMobileNo() + 
		    		" " + inputs.getMobileNo());
		} catch (IOException e) {
		    System.err.println(e);
		} finally {
		    if (out != null) {
		        out.close();
		    }
		} 

		
	}
	public ArrayList<UserContact> getContactList(){
		
		ArrayList<UserContact> tempBufferedList = new ArrayList<UserContact>();

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("C:\\Javabuffered\\Contact.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				String arr[] = line.split(" ");

				UserContact user = new UserContact();

					user.setFirstname(arr[0]);
					user.setLastname(arr[1]);
					user.setDepartment(arr[2]);
					user.setMobileNo(arr[3]);
					user.setTelNo(arr[4]);
					
				tempBufferedList.add(user);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O Exception " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid: " + e.getMessage());
		}

		return tempBufferedList;
	}
}


