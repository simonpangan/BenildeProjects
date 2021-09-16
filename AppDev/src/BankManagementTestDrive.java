 
import java.util.Scanner;

import Account.UserAccount;
import Bank.BPI;
import Bank.BankFunctions;
import Bank.LandBank;
import Exceptions.LoginException;
import Exceptions.WithdrawException;
import Helper.Helper;

public class BankManagementTestDrive {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		BankFunctions bankFunctionalities = new BPI();

		String firstChoice = ""; // for login,create account
		String secondChoice = ""; // after login choice (View profile,balance inquiry.. etc)
		String chosenCategory = ""; // category for deposit and withdraw


		do {

			System.out.println("[1] - Login");
			System.out.println("[2] - Create New Account");
			System.out.println("[0] - Quit");

			System.out.print("\n  Enter Your Choice: ");

			// Change the input number to its converted text function Ex: 1 to Login
			firstChoice = Helper.firstChoiceToText(Integer.parseInt(input.nextLine()));

			switch (firstChoice) {

			case "Login":

				try {

					System.out.print("\nEnter Username: ");
					String username = input.nextLine();
					System.out.print("Enter Password: ");
					String password = input.nextLine();

					boolean isValidUser = bankFunctionalities.login(username, password);

					if (isValidUser) {

						do {
							System.out.println("\n[1] - Balance Inquiry");
							System.out.println("[2] - Cash Deposit");
							System.out.println("[3] - Cash Withdrawal");
							System.out.println("[4] - View Transanction History");
							System.out.println("[5] - View Profile");
							System.out.println("[0] - Logout");

							System.out.print("\n  Enter Your Choice: ");

							secondChoice = Helper.secondChoiceToText(Integer.parseInt(input.nextLine()));

							// Change the input number to its converted text function Ex: 1 to Balance
							// Inquiry

							var loginUserData = bankFunctionalities.getLoginUserData();

							System.out.println(""); // to add space

							switch (secondChoice) {

							case "Balance Inquiry":

								System.out.print("Your Current Balance is : " + loginUserData.getMoneyBalance());

								break;
							case "Cash Deposit":

								System.out.println("\n[1] - 100");
								System.out.println("[2] - 200");
								System.out.println("[3] - 400");
								System.out.println("[4] - 500");
								System.out.println("[5] - 1000");
								System.out.println("[6] - 2000");
								System.out.println("[7] - 4000");
								System.out.println("[8] - 8000");
								System.out.println("[9] - 10000");
								System.out.println("[10] - 20000");
								System.out.println("[0] - Exit");

								System.out.print("\n  Enter Your Choice: ");

								chosenCategory = input.nextLine();

								if (chosenCategory.equals("0"))
									break; // break immediately if user choose quit

								// get the actual value of chosen gategory
								int depositedMoney = Helper.moneyEquivalent(Integer.parseInt(chosenCategory));

								loginUserData.addMoney(depositedMoney);

								System.out.print("\n             Successfully deposited " + depositedMoney
										+ " to your account.");

								loginUserData.setTransanctionHistory(
										"Successfully deposited " + depositedMoney + " to your account.");

								break;

							case "Cash Withdrawal":

								System.out.println("\n[1] - 100");
								System.out.println("[2] - 200");
								System.out.println("[3] - 400");
								System.out.println("[4] - 500");
								System.out.println("[5] - 1000");
								System.out.println("[6] - 2000");
								System.out.println("[7] - 4000");
								System.out.println("[8] - 8000");
								System.out.println("[9] - 10000");
								System.out.println("[10] - 20000");
								System.out.println("[0] - Exit");

								System.out.print("\n  Enter Your Choice: ");

								chosenCategory = input.nextLine();

								if (chosenCategory.equals("0"))
									break; // break immediately if user choose quit

								// get the actual value of chosen gategory
								int withdrawnMoney = Helper.moneyEquivalent(Integer.parseInt(chosenCategory));

								// check if the user have adequate money for him to withdraw money
								try {

									if (loginUserData.getMoneyBalance() >= withdrawnMoney) {
										loginUserData.reduceMoney(withdrawnMoney);
										System.out.print("\n             Successfully withdrawn " + withdrawnMoney
												+ " to your account.");
										loginUserData.setTransanctionHistory(
												"Successfully withdraw " + withdrawnMoney + " to your account.");
									} else
										throw new WithdrawException(
												"\n             Unable to withdraw money. You current balance is :  "
														+ loginUserData.getMoneyBalance());

								} catch (WithdrawException e) {
									System.out.print(e.getMessage());
								}

								break;

							case "View Transanction History":

								int numberOfTransactions = loginUserData.getTransanctionHistory().size();

								var userTransanctions = loginUserData.getTransanctionHistory();

								for (int i = 0; i < numberOfTransactions; i++) {

									System.out.println((i + 1) + ". " + userTransanctions.get(i));

								}

								break;

							case "View Profile":

								System.out.println("First Name: " + loginUserData.getFirstName());
								System.out.println("Last Name: " + loginUserData.getLastName());
								System.out.println("Username: " + loginUserData.getUserName());
								System.out.println("Phone Number: " + loginUserData.getPhoneNumber());

								break;

							}

							input.nextLine(); // to stop from executing again

						} while (!secondChoice.equals("Logout"));

					}

					else
						throw new LoginException("Invalid Credentials!!");

				} catch (LoginException e) {

					System.out.println("\n" + e.getMessage());

				}

				break;

			case "Create":

				UserAccount newAccount = new UserAccount();

					System.out.print("Enter First Name: ");
					newAccount.setFirstName(input.nextLine());
					System.out.print("Enter Last Name: ");
					newAccount.setLastName(input.nextLine());
					System.out.print("Enter Username: ");
					newAccount.setUserName(input.nextLine());
					System.out.print("Enter Password: ");
					newAccount.setPassword(input.nextLine());
					System.out.print("Enter Phone Number: ");
					newAccount.setPhoneNumber(input.nextLine());

				bankFunctionalities.createAccount(newAccount);

				break;

			case "Quit":

				firstChoice = "Quit";
				break;

			}

			input.nextLine(); // to stop from executing automatically inorder to give time to clear console

		} while (!firstChoice.equals("Quit"));

		System.out.print("Thank You Please Come Again!!");

	}

}
