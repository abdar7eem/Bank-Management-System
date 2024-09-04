//AbdAl-rheem yaseen 1220783
//Anas Al-sayed 1221020

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

class Bank {
	Account abc[] = new Account[100];
	Scanner input = new Scanner(System.in);
	File file = new File("account.txt");

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	int count;

	Bank() {
		// Default constructor
	}

	boolean addAccount(Account a) {
		
		abc[count] = a;
		count++;
		return true;

	}

	public void modifyAccountDetails(int i) {

		System.out.print("Enter The new ID: ");
		int newID = input.nextInt();
		abc[i].setId(newID);
		System.out.print("Enter the new Name: ");
		String newname = input.next();
		abc[i].setName(newname);
		System.out.print("Enter the new Phone Number: ");
		long newphone = input.nextLong();
		abc[i].setPhone(newphone);
		System.out.print("Enter the new account type(S:Saving ,O:Other): ");
		char newtype = input.next().charAt(0);
		do {
			if (newtype != 's' && newtype != 'o' && newtype != 'O' && newtype != 'S') {
				System.out.println("Error ,Please enter a valid new account type (S or O).");
				System.out.print("Enter the new account type(S:Saving ,O:Other): ");
				newtype = input.next().charAt(0);
			}
		} while (newtype != 's' && newtype != 'o' && newtype != 'O' && newtype != 'S');
		abc[i].setType(newtype);
		System.out.print("Enter the new balance: ");
		double newbalance = input.nextDouble();
		abc[i].setBalance(newbalance);
		System.out.println("* Account Details Modified sucssefully *");
	}

	public Account viewAccountDetails(int i) {
		Account a = new Account();
		a = abc[i];

		return a;

	}

	

	public void displayaccounts() {
		for (int i = 0; i < count; i++) {
			System.out.print(abc[i].getId());
			System.out.print(" ");
			System.out.print(abc[i].getName());
			System.out.print(" ");
			System.out.print(abc[i].getPhone());
			System.out.print(" ");
			System.out.print(abc[i].getType());
			System.out.print(" ");
			System.out.println(abc[i].getBalance());

		}
	}

	boolean closeAccount(Account a) {
		if (a == null) {
			return false;
		}
		for (int i = 0, k = 0; i < count; i++) {
			if (abc[i].getId() == a.getId()) {

				continue;
			}
			abc[k++] = abc[i];
		}
		count--;
		return true;

	}

	boolean updateDataFile() {
		try (PrintWriter output = new PrintWriter(file)) {
			for (int i = 0; i < count; i++) {
				output.println(abc[i].getId() + "  " + abc[i].getName() + "  " + abc[i].getPhone() + "  "
						+ abc[i].getType() + "  " + abc[i].getBalance());
			}
			output.close();
			return true;
		} catch (IOException ex) {
			return false;

		}

	}

}