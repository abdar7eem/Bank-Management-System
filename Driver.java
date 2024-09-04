//AbdAl-rheem yaseen 1220783
//Anas Al-sayed 1221020

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;

class Driver {
	static Scanner input = new Scanner(System.in);
	static Bank b = new Bank();
	static Account a = new Account();

	public static void main(String[] args) throws IOException {
		// Create an array of Account objects
		Account arr[] = new Account[10];
		System.out.println("*-------------------------*");
		System.out.println("| Welcome to our ABC Bank |");
		System.out.println("*-------------------------*");
		// Upload account data from a file
		if (uploadDataFile()) {
			System.out.println("The data has been uploaded sucssefully :)");
		} else {
			System.out.println("Error while uploading data :(");
		}

		int num = 0;
		while (num != 8) {
			displayMainMenu();
			System.out.print("Enter your choise: ");
			num = input.nextInt();
			switch (num) {
			case 1: {
				try {
					// Add a new account
					System.out.print("Enter The ID: ");
					int ID = input.nextInt();
					if (search(ID) != -1) {
						System.out.println("This ID is already existed...");
					}

					else {
						System.out.print("Enter the Name: ");
						String name = input.next();
						System.out.print("Enter the Phone Number: ");
						long phone = input.nextLong();
						System.out.print("Enter the account type(S:Saving ,O:Other): ");
						char newtype = input.next().charAt(0);
						do {
							if (newtype != 's' && newtype != 'o' && newtype != 'O' && newtype != 'S') {
								System.out.println("Error ,Please enter a valid new account type (S or O).");
								System.out.print("Enter the new account type(S:Saving ,O:Other): ");
								newtype = input.next().charAt(0);
							}
						} while (newtype != 's' && newtype != 'o' && newtype != 'O' && newtype != 'S');
						System.out.print("Enter the balance: ");
						double balance = input.nextDouble();
						Account c = new Account(ID, name, phone, newtype, balance);
						b.addAccount(c);

					}
				} catch (InputMismatchException ex) {
					System.out.println("ERROR , Please enter correct values . ");

				}
			}
				break;
			case 2: {
				// Display all accounts
				b.displayaccounts();
				System.out.println(" ");
			}
				break;
			case 3: {
				// Add amount to an account
				System.out.print("Select the Account using ID: ");
				int newID = input.nextInt();
				int x = search(newID);
				if (x != -1) {
					System.out.println(" -----------------");
					System.out.println("| Account founded |");
					System.out.println(" -----------------");
					System.out.print("Please enter the amount : ");
					double amount = input.nextDouble();
					b.abc[x].addAmount(amount);
					System.out.println("Avaliable balance is: $" + b.abc[x].getBalance());
				} else {
					System.out.println(" -------------------");
					System.out.println("| Account not found |");
					System.out.println(" -------------------");
				}

			}
				break;
			case 4: {
				// Withdraw amount from an account
				System.out.print("Select the account using ID: ");
				int newID = input.nextInt();
				int i = search(newID);
				if (i != -1) {
					System.out.println(" -----------------");
					System.out.println("| Account founded |");
					System.out.println(" -----------------");
					System.out.print("Please enter the amount: ");
					double amount = input.nextDouble();
					b.abc[i].withdrawAmount(amount);

				} else {
					System.out.println(" -------------------");
					System.out.println("| Account not found |");
					System.out.println(" -------------------");
				}
			}
				break;
			case 5: {
				// View account details
				System.out.println("Select the account using ( 1-ID 2-Full Name 3-Part of the Name )");
				int c = input.nextInt();
				if (c == 1) {
					System.out.print("Enter ID: ");
					int id = input.nextInt();
					int i = search(id);
					if (i != -1) {
						Account z = b.viewAccountDetails(i);
						System.out.println("ID: " + z.getId() + " Name: " + z.getName() + " Phone Number: "
								+ z.getPhone() + " Type: " + z.getType() + " Balance: " + z.getBalance());
					} else {
						System.out.println(" -------------------");
						System.out.println("| Account not found |");
						System.out.println(" -------------------");
					}
				} else if (c == 2) {
					System.out.println("Please enter full name : ");
					String full = input.next();
					int i = searchF(full);
					if (i != -1) {
						Account z = b.viewAccountDetails(i);
						System.out.println("ID : " + z.getId() + " Name: " + z.getName() + " Phone Number: "
								+ z.getPhone() + " Type: " + z.getType() + " Balance: " + z.getBalance());
					} else {
						System.out.println(" -------------------");
						System.out.println("| Account not found |");
						System.out.println(" -------------------");
					}
				} else if (c == 3) {
					System.out.println("Enter part of the name : ");
					String part = input.next();
					int i = search(part);
					if (i != -1) {
						Account z = b.viewAccountDetails(i);
						System.out.println("ID : " + z.getId() + " Name: " + z.getName() + " Phone Number: "
								+ z.getPhone() + " Type: " + z.getType() + " Balance: " + z.getBalance());
					} else {
						System.out.println(" -------------------");
						System.out.println("| Account not found |");
						System.out.println(" -------------------");
					}
				} else
					System.out.println("Please enter a correct choice ...");

			}
				break;
			case 6: {
				// Modify account details
				System.out.print("Select the account using ( 1-ID 2-Full Name 3-Part of the Name ): ");
				int c = input.nextInt();
				if (c == 1) {
					System.out.print("Please enter ID: ");
					int id = input.nextInt();
					int i = search(id);
					if (i != -1) {
						b.modifyAccountDetails(i);
					} else {
						System.out.println(" -------------------");
						System.out.println("| Account not found |");
						System.out.println(" -------------------");
					}
				} else if (c == 2) {
					System.out.print("Please enter full name: ");
					String full = input.next();
					int i = searchF(full);
					if (i != -1) {
						b.modifyAccountDetails(i);
					} else {
						System.out.println(" -------------------");
						System.out.println("| Account not found |");
						System.out.println(" -------------------");
					}
				} else if (c == 3) {
					System.out.print("Please enter part of the name: ");
					String part = input.next();
					int i = search(part);
					if (i != -1) {
						b.modifyAccountDetails(i);
					} else {
						System.out.println(" -------------------");
						System.out.println("| Account not found |");
						System.out.println(" -------------------");
					}
				} else
					System.out.println("Please enter a correct choice ...");

			}
				break;

			case 7: {
				// Close an account
				System.out.print("Select the account using ID: ");
				int ID = input.nextInt();
				int i = search(ID);
				if (i != -1) {
					if (b.closeAccount(b.abc[i])) {
						System.out.println("The account has been close.");
					} else {
						System.out.println("ERROR , The account isn't exist.");
					}
				} else
					System.out.println("ID dose not existed.");
			}
				break;

			case 8: {
				// Exit the program and update data file
				if (b.updateDataFile()) {
					System.out.println("Data has been updated successfully ");
					System.out.println("                            -----");
					System.out.println("Thank you for choosing our | ABC | Bank.");
					System.out.println("                            -----");
					System.out.println("Good bye :)");
				} else {
					System.out.println("ERROR 404 :(");
				}
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Error, Enter a Correct Choise.");
			}
			}
		}

	}

	public static boolean uploadDataFile() throws FileNotFoundException {
		try {
			// Read data from file and populate account array
			File file = new File("account.txt");
			Scanner in = new Scanner(file);

			int i = 0;
			while (in.hasNext()) {
				int id = in.nextInt();
				String name = in.next();
				long phonenumber = in.nextLong();
				char type = in.next().charAt(0);
				double balance = in.nextDouble();
				b.abc[i] = new Account(id, name, phonenumber, type, balance);
				i++;
			}
			b.setCount(i);
			in.close();

			return true;

		} catch (FileNotFoundException ex) {
			return false;
		}
	}

	public static void displayMainMenu() {
		//display the menu
		System.out.println("Please Select an Operation (1-8): ");
		System.out.println("*--------------------------------------------------------------------------------------*");
		System.out.println("| 1- Add Account.                 2- View All Accounts .             3- Add Amount.    |");
		System.out.println("| 4- Withdraw Amount.             5- View Account Details.           6- Modify Account |");
		System.out.println("| 7- Close an Account .           8- Exit                                              |");
		System.out.println("*--------------------------------------------------------------------------------------*");
	}

	public static int search(int search) {

		for (int i = 0; i < b.getCount(); i++) {
			if (b.abc[i].getId() == search) {
				return i;
			}

		}
		return -1;
	}

	public static int search(String xy) {

		for (int i = 0; i < b.getCount(); i++) {
			if (b.abc[i].getName().contains(xy)) {
				return i;
			}

		}
		return -1;
	}

	public static int searchF(String xy) {

		for (int i = 0; i < b.getCount(); i++) {
			if (b.abc[i].getName().equals(xy)) {
				return i;
			}

		}
		return -1;
	}
}
