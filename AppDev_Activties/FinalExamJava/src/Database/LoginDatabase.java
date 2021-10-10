package Database;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoginDatabase {
	
	public boolean login(String inputUsername, String inputPassword) {
		
		for (var user : getBufferedList()) {

			if (user.getUsername().equals(inputUsername) 
					&& user.getPassword().equals(inputPassword)) {
				
				return true;
			}

		}
		
		return false;

	}

	public ArrayList<User> getBufferedList(){
		
		ArrayList<User> tempBufferedList = new ArrayList<User>();

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("C:\\Javabuffered\\Login.txt"));
			String line = null;

			while ((line = reader.readLine()) != null) {
				String arr[] = line.split(" ");

				User user = new User();

				user.setUsername(arr[0]);
				user.setPassword(arr[1]);
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

class User{
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
