import java.util.Scanner;

import Database.ContactDatabase;
import Database.LoginDatabase;
import Database.UserContact;
import Exception.LoginException;

public class examTestDrive {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean isValidUser = true;

		do {
			try {

				System.out.print("\nEnter Username: ");
				String username = input.nextLine();
				System.out.print("Enter Password: ");
				String password = input.nextLine();

				LoginDatabase loginDB = new LoginDatabase();

				isValidUser = loginDB.login(username, password);

				if (isValidUser) {

					ContactDatabase contactDB = new ContactDatabase();

					System.out.println("[1] -  View Contact List: ");
					System.out.println("[2] -  Add Contact List: ");
//					System.out.println("[0] -  Logout: ");
					String inputChoice = input.nextLine();

//					
//					if (inputChoice.equals(0)) {
//						break;
//					}
					switch (inputChoice) {

					case "1":
						System.out.print("-----List of Contacts User-----");
						System.out.println("");
						
						for (var user : contactDB.getContactList()) {

							System.out.println("Firstname: " + user.getFirstname());
							System.out.println("Lastname: " + user.getLastname());
							System.out.println("Department: " + user.getDepartment());
							System.out.println("Mobile No: " + user.getMobileNo());
							System.out.println("Tel No: " + user.getTelNo());
							
							
		
						

							System.out.println("");
						}
						break;
					case "2":
						
							UserContact user = new UserContact();
						
							System.out.print("-----Add User Contactr-----");
							System.out.println("");

							System.out.println("");
							System.out.println("Firstname: ");
							 user.setFirstname(input.nextLine());
							System.out.println("Lastname: ");
							 user.setLastname(input.nextLine());
							System.out.println("Department: ");
							 user.setDepartment(input.nextLine());
							System.out.println("Mobile No: ");
							 user.setMobileNo(input.nextLine());
							System.out.println("Tel No: ");
							 user.setTelNo(input.nextLine());
							 
							 
							System.out.println("");
							
							System.out.print("Do you want to save this record? (Y/N): ");
							String saverecord = input.nextLine();
							
							if(saverecord.equals("Y")) {
								contactDB.addContact(user);
							}
						
						break;
					}

				}

				else
					throw new LoginException("Invalid Credentials!!");

			} catch (LoginException e) {

				System.err.println("\n" + e.getMessage());

			}
		} while (!isValidUser);

	}
}
